package com.zwx.leetcode.design;

public class Test {

    public static void main(String[] args) {

        // WordsFrequency
        /*String[] book = {"i", "have", "an", "apple", "he", "have", "a", "pen"};
        WordsFrequency wordsFrequency = new WordsFrequency(book);
        wordsFrequency.get("you"); //返回0，"you"没有出现过
        wordsFrequency.get("have"); //返回2，"have"出现2次
        wordsFrequency.get("an"); //返回1
        wordsFrequency.get("apple"); //返回1
        wordsFrequency.get("pen"); //返回1*/

        LRUCache lruCache = new LRUCache(2);

        System.out.println(1);
        lruCache.get(2);
        lruCache.sout();

        System.out.println(2);
        lruCache.put(2,6);
        lruCache.sout();

        System.out.println(3);
        lruCache.get(1);
        lruCache.sout();

        System.out.println(4);
        lruCache.put(1,5);
        lruCache.sout();

        System.out.println(5);
        lruCache.put(1,2);
        lruCache.sout();

        System.out.println(6);
        lruCache.get(1);
        lruCache.sout();

        System.out.println(7);
        lruCache.get(2);
        lruCache.sout();

        /*System.out.println(8);
        lruCache.get(3);
        lruCache.sout();

        System.out.println(9);
        lruCache.get(4);
        lruCache.sout();*/
    }


}
