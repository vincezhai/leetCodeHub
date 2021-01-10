package kuang.newFeature;

import com.sun.xml.internal.bind.v2.model.annotation.RuntimeAnnotationReader;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.stream.Stream;

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
