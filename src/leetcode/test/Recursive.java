package leetcode.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Recursive {
    public static void main(String[] args) {
        // 阶乘 | 斐波那契
        for (int i = 2; i < 3; i++) {

            Stack<Integer> stack = new Stack<>();

            // System.out.print( "res = " + factorial(i, stack) + " | ");

            System.out.print( "res = " + fabric(i) + " | ");

            while (!stack.isEmpty()){
                System.out.print( stack.pop() + " " );
            }

            System.out.println();
        }
    }

    // frog
    public static int fogStep (int step){
        int ans = 0;
        if(step == 1 ){
            return 1;
        }

        ans = fogStep( step - 1 ) + fogStep( step - 2 );
        return ans;
    }


    // 阶乘
    public static int factorial(int num, Stack<Integer> stack){
        int res = 0;
        if (num == 1){
            stack.push(1);
            return 1;
        } else {
            stack.push(num);
        }
        res = num * factorial(num - 1, stack);
        return res;
    }

    // 斐波那契数列 ( n >= 2 )
    public static int fabric (int num){
        int res = 0;
        if(num == 1 || num == 2){
            return 1;
        }

        res = fabric(num - 1) + fabric(num - 2);
        return res;
    }
}
