package com.yurets_y;



public class MainTest {
    public static void main(String[] args){
//        SimplePatternsTest.serviceIdPatternTest();
//        SimplePatternsTest.questionPatternIdTest();
        String testString = "d and some one else";
        String testString2 = "D";
        System.out.println(testString.matches("^[D,d]\\s.*"));
    }
}
