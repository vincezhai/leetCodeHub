<center>Java基础知识</center>
# JVM基础

## 基础结构

jvm分为几个区域：

java堆、方法区域、java栈、本地栈、程序计数器

（线程共享的：java堆、方法区）会出现OutOfMemery，垃圾回收主要在这里

（线程私有的：java栈、本地栈、程序计数器）会出现StackOverflow，不进行垃圾回收

### Java堆：

堆中存放的的都是类的实例，

存储：class对象（jdk1.8中在堆区）、对象实例、对象中的各种非静态成员变量、

一个jvm只有一个堆内存，大小可调节

### 方法区：

特殊的堆，

存储：静态变量、静态代码块、静态方法、类的基本结构（但class对象是在堆中的）、常量、常量池

换而言之：static 修饰的、final 修饰的、常量池、类的元数据（不是class对象，jdk1.8中如此）

### java栈

栈主要 **为方法服务**，**线程级**
首先，压入main方法入栈，继续压一些方法，
再逐步退出方法出栈，main方法出栈，java栈周期结束

**存储**：八种基本数据类型、实例的方法、对象的引用（其实例是在堆中的，仅有引用在栈中）

java栈的基本结构是**栈帧**：
包含：方法索引、输出输入参数、本地变量、class引用、父帧、子帧

### 本地栈

与栈一样为方法服务

主要对本地的方法服务，即非 java 的方法，也成为 C 栈

### 程序计数器

用于存放下一条指令所在单元的地址的地方 

tip：

由于静态的变量、方法 存放在方法区，在类加载时就已经确定了，即类加载时就已经在堆中了，且线程共享
因此可以直接通过类名调用，无需实例化；

对于非静态的变量、方法，必须在实例化后，才能调用，因为只有实例化后，对象才出现在堆中，在栈中引用堆中实例才能实现调用。



## 类加载器

 java文件（源代码） 编译  class文件（字节码）

### 类加载步骤

- **加载**：

  类加载器将 **class字节码文件 加载到 内存 中**

  静态数据转成方法区的运行时数据结构

  生成 class 对象，放在堆中

- 链接：类的二进制数据合并到 jre 中

  **验证**：保证符合jvm规范

  **准备**：正式为类变量分配内存，并设置默认初始值（即静态方法变量，在类加载时就已经在方法区中了）

  **解析**：虚拟机常量池内的符号引用（常量名）替换成直接引用（地址）

- **类初始化**：

  执行 clinit 方法，合并类变量与静态代码块

  如果父类没有初始化，会先初始化父类

  保证一个类的 clinit 方法在多线程中被正确加锁与同步



### 初始化触发条件：

- 主动引用（一定会发生类的初始化）

  new一个对象

  jvm启动，会初始化main方法所在类

  调用静态方法与静态成员

  发射调用类

  调用子类时，触发其父类的首次调用

- 被动引用（不会发生类的初始化）

  调用子类的父类静态变量，不会初始化子类

  数组定义类引用，不会触发初始化，因为只分配了空间而已

  常量在链接阶段已经存在，因此不会触发父类或者子类的初始化

- 

  

```java
public class Test01 {
    static {
        System.out.println("main类被加载");
    }

    public static void main(String[] args) {
        // 调用子类的父类静态变量，不会初始化子类
        System.out.println("Son.a = " + Son.a);

        // 数组定义类引用，不会触发初始化，因为只分配了空间而已
        Son[] array = new Son[5];

        // 常量在链接阶段已经存在，因此不会触发父类或者子类的初始化
        System.out.println("Son.M = " + Son.M);
    }
}

class Father{
    public static int a = 1;
    static {
        System.out.println("父类被加载");
    }
}

class Son extends Father{
    public static int b  = 0;
    public static final int M = 111;
    static {
        System.out.println("子类被加载");
    }
}
```



### 类加载器作用

分类：       【java程序调不到 爷爷，因为他是c写的】

（爷爷）Bootstap ClassLoader 引导类加载器：装载 rt.jar （java核心库）

（爸爸）Extension ClassLoader 拓展类加载器：装载 jre/lib/ext 目录下的 jar 包 （java拓展库）

（儿子）System ClassLoader 系统类加载器：装载 项目中的jar包 （最常用的，自己引入的jar包）

作用：加载class文件

<img src=".\image\1609853265107.png" alt="1609853265107" style="zoom: 67%;" />



### 双亲委派机制

 为了保证安全，运行一个类之前，会层层向上找
app classLoader  ---  EXC classLoader ---  boot classLoader（最后会使用最后找到的类）

1、类加载器收到类加载请求

2、委派其父类加载器完成，层层委托，直到根加载器（bootstap ClassLoader）

3、启动加载器检查能否加载当前类，能就结束，否则，抛出异常，通知子类加载

4、重复3

如果最后仍然找不到可以加载的加载器，那么就会报出 class not found

![1609855026358](.\image\1609855026358.png)

### 类初始化顺序

clinit 方法是类加载时的初始化完成的，

init 方法是实例化构造时候进行初始化的

在类首次加载时，会调用 clinit 方法，然后构造时调用 init 方法

在类非首次调用时，只会调用 init 方法

- 调用 clinit 方法时：

  对静态变量、静态代码块进行处理，处理先后顺序按照代码中先后顺序决定

- 调用 init 方法时：

  对类进行初始化，先调用普通变量、普通代码块、再调用构造函数

  先父类、再子类

因此，对于首次加载类而言，其加载顺序如下：

1、父类静态变量及静态代码块（执行顺序由代码先后顺序决定）

2、子类静态变量及静态代码块（执行顺序由代码先后顺序决定）

3、父类普通变量及普通代码块（执行顺序由代码先后顺序决定）

4、父类构造函数

5、子类普通变量及普通代码块（执行顺序由代码先后顺序决定）

6、子类构造函数





## 沙箱安全机制

https://blog.csdn.net/qq_30336433/article/details/83268945



## native

native关键字：java作用范围覆盖不到，需要调用c++接口

会进入本地方法栈，调用 JNI 接口，调用本地方法库

```java
private native void start0();
```

作用：拓展java使用，融合多种语言



## 三种JVM

- sun公司 ：hotspot
- orcale公司 ：JRockit
- IBM公司 ：J9VM



## JVM调优

### 堆区域划分

堆内存分为三个区域：

- 新生区：new

  伊甸园区

  幸存者01区

  幸存者02区

- 养老区：old

- 永久区：perm（常驻内存，jdk自身携带对象，不会垃圾回收，关闭虚拟机释放）

  - jdk1.6之前：永久带，常量池在方法区
  - jdk1.7：永久带，慢慢退化，常量池在堆中
  - jdk1.8以后：无永久带，常量池在元空间（使用系统内存）

 在JDK1.8 hotspot移除了永久代用元空间(Metaspace)取而代之, 这时候字符串常量池还在堆, 运行时常量池还在方法区, 只不过方法区的实现从永久代变成了元空间(Metaspace)  

![1609866665380](.\image\1609866665380.png)

### JVM参数

默认情况，分配的总内存 = 1/4 电脑内存， 初始化内存 = 1/64 电脑内存

```java
long max = Runtime.getRuntime().maxMemory();
long total = Runtime.getRuntime().totalMemory();
System.out.println("max = " + max/(double)1024/1024 + "MB");
System.out.println("total = " + total/(double)1024/1024 + "MB");

```

修改参数 

```shell
## 调节参数
## -Xms 初始化分配内存的大小， 也就是当你的虚拟机启动后， 就会分配这么大的堆内存给你 
## -Xmx 最大分配内存的大小
## -Xmn：设置年轻代大小
## -Xss：设置每个线程的堆栈大小
## PrintGCDetails : 打印详情信息
-Xms1024m -Xmx1024m -XX:+PrintGCDetails

## 堆大小 = 新生代 + 老年代   （元空间是逻辑上存在的）
## 因为元空间是直接内存，直接用的物理机上内存，与jvm无关
Heap
 PSYoungGen      total 305664K, used 15729K [0x00000000eab00000, 0x0000000100000000, 0x0000000100000000)
  eden space 262144K, 6% used [0x00000000eab00000,0x00000000eba5c420,0x00000000fab00000)
  from space 43520K, 0% used [0x00000000fd580000,0x00000000fd580000,0x0000000100000000)
  to   space 43520K, 0% used [0x00000000fab00000,0x00000000fab00000,0x00000000fd580000)
 ParOldGen       total 699392K, used 0K [0x00000000c0000000, 0x00000000eab00000, 0x00000000eab00000)
  object space 699392K, 0% used [0x00000000c0000000,0x00000000c0000000,0x00000000eab00000)
 Metaspace       used 3231K, capacity 4496K, committed 4864K, reserved 1056768K
  class space    used 353K, capacity 388K, committed 512K, reserved 1048576K

```



### 排查工具

出现OOM故障

内存快照分析工具：MAT、JProfiler

- 分析Dump内存文件
- 获取堆中数据
- 获得大的对象

产生dump文件：

```shell
##配置参数：
-Xms1m -Xmx8m -XX:+HeapDumpOnOutOfMemoryError
```

![1609870574018](.\image\1609870574018.png)



## GC算法

![1609871221910](image\1609871221910.png)

heap三大区域：

- 新生代
- 幸存区（from ， to）
- 老年区

轻GC：新生代 + 幸存区

重GC：老年区



gc算法：

- 标记清楚法
- 标记压缩
- 复制算法
- 引用计数器



### 引用计数器法

![1609871391333](.\image\1609871391333.png)

### 复制算法





# Java8新特性

接口方法默认是 public abstract 的修饰符，但是jdk1.8允许在接口中写static方法

```java
interface Inter{
    int func1();
    default int func2(String s){return 0;}
    static String func3(){return null;}
}

//sout getMethods()
method = public default int kuang.newFeature.Inter.func2(java.lang.String)
method = public abstract int kuang.newFeature.Inter.func1()
method = public static java.lang.String kuang.newFeature.Inter.func3()
```

- default 关键词

  - 只能在接口中使用

  - 含义代表普通方法（需要写具体的方法体）
  - 好处，default方法可以被重写，实现接口也可以继承这个方法，这样可以兼容，
    【比如 有一个接口用了很久，后续要添加一个方法，
    如果直接加，原有的实现类没实现新的方法，报错；
    这时如果将新加的方法设置default，能够新旧类都可以正常使用】

  

## lambda表达式

### 概念

函数式表达式【函数参数  ->   函数体】【简化了匿名内部类】

- 前提：抽象方法只有一个的接口（允许有其他的方法）
-  接口默认继承Java.lang.Object，所以如果接口显示声明覆盖了Object中方法，那么也不算抽象方法。 
- 注解： @FunctionInterface ，只是为了编译器检查方便

 lambda表达式是只实现接口中唯一的抽象方法的匿名实现类

### 表达式形式

Lambda 表达式，也可称为闭包，允许把函数作为一个参数，使代码更简洁。

Lambda 表达式简单写法

不需要参数，返回值为 5 () -> 5

接收一个参数(数字类型),返回其2倍的值 x -> 2 * x；

接受2个参数(数字),并返回他们的差值 (x, y) -> x – y；

接收2个int型整数,返回他们的和 (int x, int y) -> x + y；

接受一个 string 对象,并在控制台打印,不返回任何值(看起来像是返回void) (String s) -> System.out.print(s)；



快速实现接口（只有一个抽象方法的）

```java
// 创建数据（使用匿名内部类）
List<Integer> list = new ArrayList<Integer>(){
    {
        add(5);
        add(1);
        add(6);
        add(7);
    }
};
List<Integer> list_copy = new ArrayList<>(list);
// List<Integer> list_copy = list;

//************* comparator **************
// 匿名内部类
list.sort(new Comparator<Integer>() {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o1 - o2;
    }
});
// lambda表达式
list.sort((o1,o2)->{return o1- o2;});

// sout
// 也是个labmda 表达式 
// 【Consumer 这个接口，也是FunctionInterface接口】
list.forEach((o)-> System.out.print(o + " "));



// *****************  runnable ***********
// 匿名内部类实现 runable 接口
Runnable runnable1 = new Runnable() {
    @Override
    public void run() {
        System.out.println("匿名内部类");
    }
};

// 实现 runnable 接口
Runnable runnable = ()-> System.out.println("start");
new Thread(runnable).start();


```



### 方法引用

https://segmentfault.com/a/1190000021411722

:: 表示调用的方法

引用方法，代替表达式中的重写的内容

- 其中引用方法的参数类型 必须匹配上 默认传递的类型

- 调用方法，User::static方法，实例::普通方法，类似这样

  - 类 :: 实例方法
  - 类 :: 静态方法
  - 对象 :: 实例方法

  第一种使用方式，第一个参数变成方法的接收者，并且其他参数也传递给该方法。
  例如：

  ```java
  String :: compareToIgnoreCase 等价于 (x,y) -> x.compareToIgnoreCase(y)
  ```

  第二种使用方式，所有的参数传递给静态方法。
  例如：

  ```java
  Objects :: isNull 等价于 x -> Objects.isNull(x)
  ```

  第三种使用方式，在给定的对象上调用方法，并且参数传递给实例方法。
  例如：

  ```java
  System.out :: println 等价于 x-> System.out.println(x)
  ```

```java
public class Lambda {
    public static void main(String[] args) {
        List<User> list = new ArrayList<User>(){
            {
                add(new User("aa",28));
                add(new User("a",18));
                add(new User("aaa",38));
            }
        };

        
        list.sort(User :: compare);
        list.forEach(o-> System.out.println(o.age));
        
        System.out.println();

        list.forEach(User :: myString);
    }
}

class User{
    public  String name;
    public  int age;
    public static final int time = 2;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static int compare(User a, User b){
        return a.age - b.age;
    }

    public void myString() {
        for (int i = 0; i < 1 ;i++) {
            System.out.println("User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}');
        }
        System.out.println();
        }
}
```





### 匿名内部类

相当于接口的构造函数

```java
public class Lambda {
    public static void main(String[] args) {
        // 显示类实现接口
        class Hello01 implements HelloWorld{
            @Override
            public void greet(String name) {
                System.out.println("hello " + name);
            }
        }
        new Hello01().greet("01");

        // 匿名内部类
        HelloWorld hello02 = new HelloWorld() {
            @Override
            public void greet(String name) {
                System.out.println("hello " + name);
            }
        };
        hello02.greet("02");

        // lambda表达式
        HelloWorld hello03 = (s)->{
            System.out.println("hello " + s);
        };
        hello03.greet("03");
    }
}

interface HelloWorld {
    public void greet(String name);
}
```

list的直接赋值【匿名内部类的构造函数】

```java
public static void main(String[] args) {
    // 第一个大括号，内部类
    List<Integer> list = new ArrayList<Integer>(){
        // 初始化代码块【作为构造函数】
        {
            add(1); // 相当于this.add(1);
            add(2); // 相当于this.add(2);
        }
    };
}


// 初始代码块执行优先级较高，
// 正因此，对于 list 可以当作一个构造器
HelloWorld hello02 = new HelloWorld() {
    int num = 0;
    {
        this.greet("jack" );
        num ++;
        System.out.println("初始化代码块 ：num 01  = " + num);
        System.out.println("初始化代码块");
    }
    @Override
    public void greet(String name) {
        System.out.println("overRide : num = " + num);
        System.out.println("overRide : hello " + name);
    }

};
hello02.greet("tom");
```

### 表达式对数值封闭

表达式对数值封闭，对变量不封闭

【但是必须是 final 或者 隐形的final 才可以】

```java
// 例子1
public class Test {
    static int num = 99; // static 缺省了 final
    public static void main(String[] args) {
        num++;
        Consumer<Integer> consumer = (o) -> {
            System.out.println(num);
        };

        new ArrayList<Integer>(){{
            add(1);
            add(2);
        }}.forEach(consumer);
        // 100 ；100
    }
}

// 例子2
public static void main(String[] args) {
    int num = 99;
    // 注释掉 num++,可以编译 打印99 99
    // 放出 num++，不可编译，因为不是 final，也没有隐形 final
    // num++;
    Consumer<Integer> consumer = (o) -> {
        System.out.println(num);
    };

    new ArrayList<Integer>(){{
        add(1);
        add(2);
    }}.forEach(consumer);
}
```



## stream

### 特性

- 不是数据结构，不保存数据

- 不会改变数据源，最后会输出另一个对象来保存（peek修改了）
- 惰性求值，只对操作进行记录，最后才会执行计算

```java
List<String> peopleList = new ArrayList<String>(){{
            add("a,20");
            add("b,29");
        }};

// peek修改了
System.out.println("before");
List<People> list = peopleList.stream().map(People::new).sorted((o1, o2) -> o1.age - o2.age).collect(Collectors.toList());
list.forEach(o-> System.out.println( o.toString()));
System.out.println("ing");
list.stream().peek(o->o.age = 100).forEach(o-> System.out.println(o.toString()));
System.out.println("after");
list.forEach(o-> System.out.println( o.toString()));

// sout
before
People{name='a', age=20}
People{name='b', age=29}
ing
People{name='a', age=100}
People{name='b', age=100}
after
People{name='a', age=100}
People{name='b', age=100}
```



### 创建流

```java
// collection
List<Integer> list = new ArrayList<Integer>(){{
    add(1);
    add(2);
    add(3);
    add(4);
}};
list.parallelStream();
list.stream();

// array
int[] nums = new int[10];
Arrays.stream(nums);

// Stream 类
Stream.of(1,2,3);
Stream.of("a","b");

Stream.generate(new Supplier<Double>() {
    @Override
    public Double get() {
        return Math.random();
    }
});
```



### 流操作

#### 中间操作：可以返回流的，链式操作

- filter  limit  skip  distinct  sorted   peek

```java
List<Integer> list = new ArrayList<Integer>(){{
            add(1);
            add(2);
            add(3);
            add(41);
            add(32);
            add(0);
        }};

// 常规操作
Stream<Integer> stream = list.stream().skip(1).filter(o->o!=0).distinct().sorted().limit(2);
stream.forEach(o -> System.out.print(o + " "));
System.out.println();

list.forEach(o-> System.out.println(o));
list.stream().distinct().sorted().map(String::valueOf).forEach(o-> System.out.println(o.charAt(0)));
```



- map操作
  - map: 实现的 function接口，改变数据类型
  - peek:实现的 consumer接口。改变数据内部属性等等

```java
// map功能：将元素从一种类型变成另一种类型
// 实现接口时 Function<T, R> ，实现其apply方法
List<String> peopleList = new ArrayList<String>(){{
add("a,20");
add("b,29");
add("c,21");
add("d,22");
add("e,29");
add("f,21");
}};

// lambda 表达式 实现 
peopleList.stream().map(
o -> new People(o.split(",")[0],Integer.valueOf(o.split(",")[1]))
).forEach(o-> System.out.println(o.toString()));

// 引用构造方法 实现
peopleList.stream().map(People::new).sorted((o1, o2) -> o1.age - o2.age)
.forEach(o-> System.out.println(o.toString()));

// people 类定义
class People{
    public String name;
    public int age;

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public People(String str) {
        this.name = str.split(",")[0];
        this.age = Integer.valueOf(str.split(",")[1]);
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
```



#### 终端操作：结束操作并返回

- anyMatch()
- allMatch()
- noneMatch()

```java
public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("周杰伦");
        list.add("王力宏");
        list.add("陶喆");
        list.add("林俊杰");

boolean  anyMatchFlag = list.stream().anyMatch(element -> element.contains("王"));
boolean  allMatchFlag = list.stream().allMatch(element -> element.length() > 1);
boolean  noneMatchFlag = list.stream().noneMatch(element -> element.endsWith("沉"));
System.out.println(anyMatchFlag);
System.out.println(allMatchFlag);
System.out.println(noneMatchFlag);
```

- reduce操作

  三种重载方法

  ```java
  public static void main(String[] args) {
          List<Integer> list = new ArrayList<Integer>(){{
              add(4);
              add(41);
              add(5);
              add(10);
          }};
          int res = 0;
  
          // 进行累加操作，a，b是先后顺序
          res = list.stream().reduce((a,b)->a+b).get();
          System.out.println("res = " + res); // 60
  
          // 增加了初始值
          res = list.stream().reduce(100,(a,b)->a+b);
          System.out.println("res = " + res); // 160
  
          // 弥补1、2不足，摆脱了返回值类型的限制
          // 第1个方法，返回的是optional类型，所以需要 get 取出
          // 第2个方法，有了初始值，所以不会出 null ，因此可以直接取出
          // 第三个可以指定返回类型
          long resLong = list.stream().reduce(100L,(a,b)->a+b,(a,b)->0L);
          System.out.println("res = " + resLong); // 160
  
          // eg2
          List<Integer> numList = Arrays.asList(1, 2, 3, 4, 5, 6);
          ArrayList<String> result = numList.stream().reduce(new ArrayList<String>(), (a, b) -> {
              a.add("element-" + Integer.toString(b));
              return a;
          }, (a, b) -> null);
          System.out.println(result);
      }
  ```

  

- collect操作

  流转会数组或集合

  - .toArray(String[]::new)【转成数组】
  - .collect(Collectors.toList());【转成list】
  -  .collect(Collectors.toCollection(ArrayList::new)); 【转成 arrayList】



# Java IO

https://www.cnblogs.com/CQqf/p/10795656.html

节点流

- 字节流
- 字符流

处理流

- 缓存流
- 对象流



## 字节流

### 基础分类

- ByteArrayInputStream
- FileInputStream
- StringBufferInputStream（@Deprecated）



- PipedInputStream 【线程通信】
- BufferInputStream【装饰类】
- FilterInputStream 及其子类【装饰类】
- ObjectInputStream【对象流-序列化】

输出基本一致对应

### IO对比

![1610559448317](C:\Users\zwx\AppData\Roaming\Typora\typora-user-images\1610559448317.png)



### 实战

这是IO读取的基本框架

- 选择 合适 输入输出流

- 设置 buffer

- while循环条件

  while( (len= is.read(buffer)) != -1)

- while循环体

  os.write(buffer,0,len);

- finally内关闭流

```java
// 字节流 - fileinputStream （本地文件）
InputStream is = null;
OutputStream os = null;

try {
    is = new FileInputStream("start");
    os = new FileOutputStream("end");

    byte[] buffer = new byte[4];
    int len = 0;
    while( (len= is.read(buffer)) != -1){
        os.write(buffer,0,len);
    }
} catch (IOException e) {
    e.printStackTrace();
} finally {
    os.close();
    is.close();
}

// 字节流 - 字符数组
InputStream is = null;
OutputStream os = null;
byte[] input = new byte[8];
for (int i = 0; i < 8; i++) {
    input[i] = (byte) ('a' +  i);
}

try {
    is = new ByteArrayInputStream(input);
    os = new ByteArrayOutputStream(4);

    int len = 0;
    byte[] buf = new byte[2];
    while ((len = is.read(buf))!= -1){
        os.flush();
        os.write(buf,0,len);
    }
    System.out.println(os.toString());
} catch (IOException e) {
    e.printStackTrace();
} finally {
    os.close();
    is.close();
}
```

read多种方式

- 读取 字符
- 读取 buffer数组
- 读取buffer数组，并指定偏置

```java
// 测试 read 三种方法
InputStream is = null;
OutputStream os = null;

try {
    is = new FileInputStream("start"); // abcd
    os = new FileOutputStream("end"); // 空文件

    // 使用 read() 一个一个字符读取
    // 返回：一个字节（-1-255）
    //int len = is.read();
    // os.write(len);

    // read(byte[]) ，读入字节数组
    // 返回：实际读入的字节数
    int len = 0;

    byte[] buf = new byte[8];
    len = is.read(buf);//4,尽管buffer有8个位置，但是总共就只有4个字符

    //byte[] buf = new byte[2];
    //len = is.read(buf);//2, buffer有2个位置，本次只读到ab，需要再读一次，才能读全abcd

    os.write(buf,0,len);
} catch (IOException e) {
    e.printStackTrace();
} finally {
    os.close();
    is.close();
}
```



## 字符流

### 基础分类

- CharArrayReader
- StringReader
- FileReader【实际是通过 字符流转字节流 实现的】



- InputStreamReader【字符流 转 字节流】



- PipedReader【线程通信】
- BufferReader【装饰类】
- FilterReader及其子类【装饰类】
- ObjectInputStream【对象流-序列化】

Writer 基本与之对应

### IO对比

![1610556538120](C:\Users\zwx\AppData\Roaming\Typora\typora-user-images\1610556538120.png)



### 实战

```java
// 字符流 字符串
Reader reader = null;
Writer writer = null;
try {
    reader = new StringReader("I am you father");
    writer = new StringWriter();
    int len = 0;
    while ((len = reader.read())!= -1){
        // 注意：这里 flush ，下面还会有输出
        // 原因：StringWriter 里的 flush 方法是空方法，没卵用
        writer.flush()
        writer.write(len);
    }
    System.out.println(writer.toString());
} catch (IOException e){
    e.printStackTrace();
} finally {
    reader.close();
    writer.close();
}
```

FileReader 

```java
File src = new File("srcFile");
File dst = new File("dst");

FileReader fr = new FileReader(src);
FileWriter fw = new FileWriter(dst);
char[] buffer = new char[25];

int len = 0;
while ((len = fr.read(buffer))!=-1){
    fw.write(buffer,0,len);
    fw.flush();
}
```



## 字符字节转换

### 构造方法：

- 创建一个使用默认字符集的 InputStreamReader 

  InputStreamReader(InputStream in)

- 创建使用给定字符集的 InputStreamReader
  InputStreamReader(InputStream in, Charset cs)

- 创建使用给定字符集解码器的 InputStreamReader
  InputStreamReader(InputStream in, CharsetDecoder dec)

- 创建使用指定字符集的 InputStreamReader

  InputStreamReader(InputStream in, String charsetName)

### 特有方法：

- 返回此流使用的字符编码的名称 

  String getEncoding() 

### 实战

```java
PrintWriter out = new PrintWriter(System.out,false);
// 将键盘输入的字节流 转换 字符流 ，使用 缓冲流
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
String line = null;
while ((line = br.readLine())!=null){
    if("exit".equals(line)){
        System.exit(1);
    }
    out.println(line);
    // 如果 PrintWrite 设置成 autoflush 为 true，就不需要这一行
    out.flush();
}
```



## Buffer流【高效】

采用了装饰者模式

### BufferReader

BufferedReader：字符缓冲流，从字符输入流中读取文本，缓冲各个字符，从而实现字符、数组和行的高效读取。

#### 构造方法

- 创建一个使用默认大小输入缓冲区的缓冲字符输入流
  BufferedReader(Reader in)
- 创建一个使用指定大小输入缓冲区的缓冲字符输入流
  BufferedReader(Reader in, int sz)

#### 特有方法

- 读取一个文本行
  String readLine()

#### 2）.BufferedWriter

BufferedWriter：字符缓冲流，将文本写入字符输出流，缓冲各个字符，从而提供单个字符、数组和字符串的高效写入。

#### 特有方法

- 写入一个行分隔符
  void newLine() 

### 实战

```java
String readLine()
    //生成字符缓冲流对象
BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("test.txt")));
String str;
//一次性读取一行
while ((str = reader.readLine()) != null) {
    System.out.println(str);// 爱生活，爱Android
}

//关闭流
reader.close();
```

