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
                "2.17",
                "10.14",
                "9.19",
                "4.10",
                "4.13",
                "4.15",
                "1.11",
                "2.17",
                "10.4"
        };
        String pattern = "([1-9]|10)(\\.([1-9]|(1\\d)|20))?";
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
        };
        Arrays.asList(invalidTestStrings).forEach( string -> {
            System.out.println(string.matches(pattern));
        });
    }
}
