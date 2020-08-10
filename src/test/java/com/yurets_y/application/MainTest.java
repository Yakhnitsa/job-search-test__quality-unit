package com.yurets_y.application;


public class MainTest {
    public static void main(String[] args){
        Main.main(getTestData());
    }
    
    private static String[] getTestData(){
        return new String[]{
                "15\n" +
                        "C 1 10.1 P 01.12.2012 65\n" +
                        "C 1 10.2 P 01.12.2012 80\n" +
                        "C 1 10.20.4 P 01.12.2012 35\n" +
                        "C 9 10.1 P 31.12.2012 114\n" +
                        "C 4 10.1 P 11.12.2012 15\n" +
                        "C 3 10.1 P 01.01.2012 115\n" +
                        "C 3.1 10.1 P 01.02.2012 85\n" +
                        "C 3.3 10.1 P 01.12.2020 48\n" +
                        "C 1.1 5.5.1 P 31.08.2012 117\n" +
                        "C 3 10.2 N 02.10.2012 100\n" +
                        "C 10.3 5.5.1 P 01.11.2012 117\n" +
                        "D 1 10 P 01.12.2012-31.12.2012\n" +
                        "D 3 10 N 02.10.2012-31.12.2012\n" +
                        "D * * P 01.12.2012-31.12.2012\n" +
                        "D * * P 01.12.2012-31.12.2012",
        };
    }

    private static String[] testDataFromTask(){
        return new String[]{
                "7",
           "C 1.1 8.15.1 P 15.10.2012 83",
           "C 1 10.1 P 01.12.2012 65",
           "C 1.1 5.5.1 P 01.11.2012 117",
           "D 1.1 8 P 01.01.2012-01.12.2012",
           "C 3 10.2 N 02.10.2012 100",
           "D 1 * P 8.10.2012-20.11.2012",
           "D 3 10 P 01.12.2012",
        };

    }

}
