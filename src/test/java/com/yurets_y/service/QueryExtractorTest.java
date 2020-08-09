package com.yurets_y.service;


import java.util.Arrays;

public class QueryExtractorTest {

    public static void main(String[] args){
        QueryExtractor extractor = new QueryExtractorImpl();
        System.out.println("valid data test....");
        Arrays.asList(validData()).forEach(string ->{
            System.out.println("\t" + extractor.getQuery(string));
        });
        System.out.println("invalid data test....");
        Arrays.asList(invalidData()).forEach(string ->{
            System.out.println("\t" + extractor.getQuery(string));
        });
    }

    private static String[] validData(){
        return new String[]{
            "D 1 10.1 P 01.12.2012",
            "D 1 10.1 P 11.12.2012-31.12.2012",
            "D 1 10.1 P 11.12.2012",
            "D 1 10.1 P 01.01.2012",
            "D 1 10.1 P 01.02.2012",
            "D 1 10.1 P 01.12.2020-31.12.2012",
            "D 1.1 5.5.1 P 31.08.2012",
            "D 3 10.2 N 02.10.2012",
            "D * 5.5.1 P 01.11.2012",
            "D 1.1 * P 01.11.2012",
            "D * * P 01.11.2012",
        };
    }
    private static String[] invalidData(){
        return new String[]{
                "D 11 0.11 P 01.12.2012",
                "D 1.4 10.0 S 31.12.2012",
                "D 1.3 10.1.4 P 2012.01.17",
                "D 10.4 0.1.15 P 01.01.2012",
                "D 1 10.1 s 01.02.2012",
                "D 1 10.1 P 2020 48",
                "D 1.1 5.5.1 P 2020.01.08",
                "D 3 10.2 n 02.10.2012",
                "D 1.1 5.5.1 01.11.2012",
                "D 1.1 5.5.1 01.11.2012",
                "D 1.1 5.5.* N 01.11.2012",
                "D 1.* 5.5.1 P 01.11.2012 - 01.11.2012",
        };
    }
}
