package com.yurets_y.service;


import java.util.Arrays;

public class WaitingTimelineExtractorTest {

    public static void main(String[] args){
        WaitingTimelineExtractor extractor = new WaitingTimelineExtractorImpl();
        System.out.println("valid data test....");
        Arrays.asList(validData()).forEach(string ->{
            System.out.println("\t" + extractor.getStorageEntity(string));
        });
        System.out.println("invalid data test....");
        Arrays.asList(invalidData()).forEach(string ->{
            System.out.println("\t" + extractor.getStorageEntity(string));
        });
    }

    private static String[] validData(){
        return new String[]{
                "C 10 10.1 P 01.12.2012 65",
                "C 9 10.1 P 31.12.2012 114",
                "C 4 10.1 P 11.12.2012 15",
                "C 3 10.1 P 01.01.2012 115",
                "C 3.1 10.1 P 01.02.2012 85",
                "C 3.3 10.1 P 01.12.2020 48",
                "C 1.1 5.5.1 P 31.08.2012 117",
                "C 3 10.2 N 02.10.2012 100",
                "C 10.3 5.5.1 P 01.11.2012 117",
                "C 1 10.20.4 P 01.12.2012 65"
        };
    }
    private static String[] invalidData(){
        return new String[]{
                "C 11 0.11 P 01.12.2012 65",
                "C 1.4 10.0 P 31.12.2012 114",
                "C 1.5 10.1.6 P 11.12.2012 15",
                "C 10.4 0.1.15 P 01.01.2012 115",
                "C 1 10.1 s 01.02.2012 85",
                "C 1 10.1 P 2020 48",
                "C 1.1 5.5.1 P 2020.01.08 117",
                "C 3 10.2 n 02.10.2012 100",
                "C 1.1 5.5.1 01.11.2012 117.4",
                "C 1.1 5.5.1 01.11.2012 117.5",
                "C 1.1 5.5.8 N 01.11.2012 117",
        };
    }
}
