package service;

import java.util.Arrays;
import java.util.regex.Pattern;

public class SimplePatternsTest {


    public static void serviceIdPatternTest(){
        String[] testStrings = {"1.1","2.4","15","10.2","11","1.3"};
        String patternString = "([1-9]|10)(\\.[1-3])?";
        Arrays.asList(testStrings).forEach( string -> {
            System.out.println(string.matches(patternString));
        });
    }
    public static void questionPatternIdTest(){
        String[] validTestString={
                "1",
                "2",
                "5",
                "2.17.1",
                "10.14.5",
                "9.19.3",
                "4.10.5",
                "4.13.1",
                "4.15.2",
                "1.11.3",
                "2.17.3",
                "10.4.1"
        };
        String pattern = "([1-9]|10)(\\.([1-9]|(1\\d)|20))?(\\.[1-5])?";
        Arrays.asList(validTestString).forEach( string -> {
            System.out.println(string.matches(pattern));
        });
        System.out.println("Invalid strings test");

        String[] invalidTestStrings = {
                "1.21",
                "0.14",
                "10.41",
                "9.61",
                "9.99",
                "9.20.0",
                "9.20.6",
                "9.21.5",
                "11.20.1",
        };
        Arrays.asList(invalidTestStrings).forEach( string -> {
            System.out.println(string.matches(pattern));
        });
    }
}
