package com.zwx.leetcode.stack_query;

import java.util.Stack;

public class L_M_394 {
    public static void main(String[] args) {
        String s = "32[a]bc";
        s = "3[a]2[bc]";
        s = "2[abc]3[cd]ef";
        s= "abc3[cd]xyz";
        s = "3[a2[c]]";
        s= "10[leetcode]";
        //s = "3[a]2[bc]";
        System.out.println("f0(s) = " + f0(s));
        System.out.println("f1(s) = " + f1(s));
    }

    // 字母一个栈，数字一个栈
    public static String f1(String s) {
        StringBuffer ans=new StringBuffer();
        Stack<Integer> multiStack=new Stack<>();
        Stack<StringBuffer> ansStack=new Stack<>();
        int multi=0;
        for(char c:s.toCharArray()){
            if(Character.isDigit(c)) {
                // 计算次数（并考虑到多位的数字）
                multi=multi*10+c-'0';
            }
            else if(c=='['){
                ansStack.add(ans);
                multiStack.add(multi);
                // 重置
                ans=new StringBuffer();
                multi=0;
            }else if(Character.isAlphabetic(c)){
                ans.append(c);
            }else{
                // 针对 ']' 的情况
                StringBuffer ansTmp=ansStack.pop();
                int tmp = multiStack.pop();
                // 这时由于已经统计了 重复单元、次数，从各自栈中取出数据，进行复制操作即可
                for(int i=0;i<tmp;i++)
                    ansTmp.append(ans);
                ans=ansTmp;
            }
        }
        return ans.toString();
    }

    // 对非']'字符入栈，
    // 遇到']'字符，栈里找到'['，找到需要重复的单元
    // 然后找到数字，对重复单元复制多次，字符串入栈
    // 记得pop出来是倒叙的，因此重复单元、输出要进行反转
    public static String f0(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if( ch == ']' ){
                // 找到重复的字符串
                String oneStr = new String();
                while ( stack.peek() != '['){
                    oneStr += stack.pop();
                }
                oneStr = reverse(oneStr);
                // 按次数复制单个字符串
                String timeStr = "";
                stack.pop();
                //找到重复次数
                String time = "";
                while (stack.peek() >= '0' && stack.peek() <= '9' ){
                    time += stack.pop();
                    if(stack.isEmpty()){
                        break;
                    }
                }
                for (int j = 0; j < Integer.valueOf(reverse( time) ) ; j++) {
                    timeStr += oneStr;
                }
                // 重组后的字符串压栈
                for (int j = 0; j <timeStr.length() ; j++) {
                    stack.push( timeStr.charAt(j) );
                }
            } else {
                stack.push(ch);
            }
        }
        //构造输出结果
        String res = "";
        while ( !stack.isEmpty() ){
            res += stack.pop();
        }
        res = reverse(res);
        return res;
    }

    public static String reverse(String s){
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

}
