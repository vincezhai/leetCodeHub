package com.zwx.leetcode.string;

public class L_E_557 {

    /*
    * 通过StringBuilder可以用带的reverse算法反转
    * String 类是不可变类，即一旦一个String对象被创建以后，包含在这个对象中的字符序列是不可改变的，直至这个对象被销毁。
    * StringBuilder、StringBuffer 代表一个字符序列可变的字符串，
    * append()、insert()、reverse()、setCharAt()、setLength()
    * 方法可以改变这个字符串对象的字符序列。
    * 一旦通过StringBuffer生成了最终想要的字符串，就可以调用它的toString()方法将其转换为一个String对象。
    */

    public static void main(String[] args) {
        L_E_557 reverseString = new L_E_557();
        String  s = "123 456 789";
        System.out.println(reverseString.f2(s));
    }

    public  String f1 (String s){
        String [] input = s.split(" ");
        String res = new String();
        for (int i = 0; i < input.length ; i++) {
            input[i] = reverse(input[i]);
            res += (input[i] + " ");
        }
        return res.substring(0,res.length()-1);
    }

    public String reverse(String s){
        String output = "";
        for (int i = 0; i < s.length(); i++) {
            output += s.charAt(s.length()-i-1);
        }
        return output;
    }

    public String f2(String s){
        String[] inputArr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String str : inputArr){
            //sb.append(new StringBuffer(str).reverse() + " ");
            sb.append(new StringBuilder(str).reverse() + " ");
        }
        return sb.substring(0,sb.length()-1).toString();
    }
}
