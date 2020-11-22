package com.zwx.leetcode.string;

import java.util.Stack;

/*
利用栈处理匹配问题，这里的题目没说清楚，应该是必须全部分完，从左往右分
空就进栈，相同也进栈，不同出栈，如果空了就说明匹配完成了
 */

public class L_E_1221 {
    public static void main(String[] args) {

        //String s = "RLRRLLRLRL";
        //String s = "RLLLLRRRLR";

        //匹配字符串
        String s = "LLLLRRRR";
        //System.out.println("f2(s) = " + f2(s));

        //匹配括号
        String str = "abc((dfg)jkkl(k))";
        System.out.println("match(str) = " + match(str));
    }

    public static int match(String s){
        int res =0;
        Stack<Character> stack = new Stack<Character>();
        for(char c : s.toCharArray()){
            if(!(c == ')' || c == '(' ))
            {continue;}
            if(stack.isEmpty() || c == stack.peek()){
                stack.push(c);
            }
            else {
                stack.pop();
                res ++;
            }
        }

        if(stack.isEmpty())
            System.out.println( "matched");
        else
            System.out.println( "not fully matched");
        return res;
    }

    public static int f2(String s){
        int res = 0;
        Stack<Character> stack = new Stack<Character>();
        char[] chArray = s.toCharArray();
        for (char ch : chArray) {
            if(stack.isEmpty()){
                stack.push(ch);
            }
            else {
                if(ch == stack.peek()){
                    stack.push(ch);
                }
                else {
                    stack.pop();
                }
            }
            if(stack.isEmpty())
            res++;
        }
        return res;
    }

    // incorrect 。。。
    public static int f1(String s){
        int res = 0;
        int cnt = 0;
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == 'R')
                cnt++;
        }

        for (int i = 1; i <= cnt; i++) {
            String strR="";
            String strL="";
            for (int j = 1; j <= i; j++) {
                strR+="R";
            }
            for (int j = 1; j <= i; j++) {
                strL+="L";
            }
            String s1 = strL + strR;
            String s2 = strR + strL;

/*            if(s1.equals(s)  || s2.equals(s)){
                System.out.println("i am here");
                return 1;
            }*/

            System.out.println("s1 + s2 = " + s1 + " " + s2);
            int subres1 = cntcontain(s, s1);
            int subres2 = cntcontain(s,s2);
            res += subres1 + subres2;
            System.out.println("subres1 ,subres2 = " + subres1 + " , " + subres2);
            System.out.println("***************************");
        }
        return res/2;
    }

    public static int cntcontain(String all, String substr){
        int orglength = all.length();
        all = all.replace(substr,"");
        //System.out.println("all = " + all);
        return (orglength - all.length())/substr.length();
    }


}
