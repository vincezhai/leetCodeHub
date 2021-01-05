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

<img src="C:\Users\zwx\AppData\Roaming\Typora\typora-user-images\1609853265107.png" alt="1609853265107" style="zoom: 67%;" />



### 双亲委派机制

 为了保证安全，运行一个类之前，会层层向上找
app classLoader  ---  EXC classLoader ---  boot classLoader（最后会使用最后找到的类）

1、类加载器收到类加载请求

2、委派其父类加载器完成，层层委托，直到根加载器（bootstap ClassLoader）

3、启动加载器检查能否加载当前类，能就结束，否则，抛出异常，通知子类加载

4、重复3

如果最后仍然找不到可以加载的加载器，那么就会报出 class not found

![1609855026358](C:\Users\zwx\AppData\Roaming\Typora\typora-user-images\1609855026358.png)

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

![1609866665380](C:\Users\zwx\AppData\Roaming\Typora\typora-user-images\1609866665380.png)

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

![1609870574018](C:\Users\zwx\AppData\Roaming\Typora\typora-user-images\1609870574018.png)



## GC算法



私有的，每个线程都有一个计数器