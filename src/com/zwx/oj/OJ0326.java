package com.zwx.oj;

public class OJ0326 {
    public static void main(String[] args) {
    /*    String strs = "9computer012, 118computer1a, 1a02hw";

        for(String str : strs.split(",")){

            int res = encodeString(str.trim());

            System.out.println("str = " + str + " , " + "res " + res );
        }*/
        for (double i = 0; i < 20; i+=0.5) {
            System.out.println("i = " + i + " : " + func(i));
        }



    }

    private static String func(double num) {
        if(num >= RULER[RULER.length - 1]){
            return " > " + RULER[RULER.length - 1];
        }
        if(num < RULER[0]){
            return " < " + RULER[0];
        }
        for (int begin = 0, end = 1; begin < RULER.length && end < RULER.length; begin++, end++) {
            if( num >= RULER[begin] && num < RULER[end] ) {
                return "（" + RULER[begin] +  " ~ " + RULER[end] + "）";
            }
        }
        return "logic error";
    }

    private static final int[] RULER = new int[]{0,1,3,5,7,9,10};

    /*private static int encodeString(String encodeStr) {
        int res = -1;

        for (int i = 0; i < encodeStr.length(); i++) {
            if( Character.isDigit(encodeStr.charAt(i)) ){
                
            }

        }

        return res;
    }*/
}
