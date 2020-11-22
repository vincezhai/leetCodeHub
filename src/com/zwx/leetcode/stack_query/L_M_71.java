package com.zwx.leetcode.stack_query;
import java.util.Stack;

public class L_M_71 {
    public static void main(String[] args) {
        String s = "/home//foo/";
        //s = "/home/.././foo/";
       // s = "/a/../../b/../c//.//";
        //s = "/a/./b/../../c/";
       // s = "/../";
        //s = "/a//b////c/d//././/..";
        System.out.println("s = " + s);
        System.out.println("f(s) = " + f(s));
    }

    public static String f(String path){
        path = path + "/";
        String res = new String("/");
        Stack<String> resList = new Stack<>();
        char[] array = path.toCharArray();
        // 遍历字符串
        for (int i = 0; i < array.length; i++) {
            String element = new String();
            char ch = array[i];
            //取出element
            if( ch != '/'){
                while ( ch != '/'){
                    element += ch;
                    i++;
                    ch = array[i];
                }
            }
            // 存在 element,且不为 '.' 进入操作处理
            // 分 ‘word’ , ‘..’ 两种情况
            if(!element.isEmpty() && !element.equals(".")) {
                if( "..".equals(element) ){
                    // 如果不为空，返回上一级（删除一个元素）
                    if( !resList.isEmpty()){
                        resList.pop();
                    }
                } else{
                    //提取出单词
                    resList.push(element);
                }
            }
        }
        // output
        for ( String str : resList ) {
            res += ( str + "/" );
        }
        //防止/被消去
        if("/".equals(res)){
            return res;
        }
        return res.substring(0,res.length() -1);
    }
}
