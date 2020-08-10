package com.yurets_y.application;

import com.yurets_y.application.service.*;
import com.yurets_y.application.storage.StorageService;
import com.yurets_y.application.storage.StorageServiceImpl;

public class Main {

    public static void main(String[] args) {
        if(args.length == 0) return;
        if(args.length == 1){
            splitAndExecute(args[0]);
        }else{
            execute(args);
        }
    }

    private static void splitAndExecute(String arg){
        String lineSeparator = "(\\r\\n)|(\\n)";
        String[] args = arg.split(lineSeparator);
        execute(args);
    }
    private static void execute(String[] args){
        int lineCount = 0;
        try{
            lineCount = Integer.parseInt(args[0]);
        }catch (Exception e){
            e.printStackTrace();
        }
        //Correcting data based on passed arguments
        lineCount = lineCount < args.length ? lineCount : args.length -1;

        StorageService storageService = new StorageServiceImpl();
        QueryExtractor queryExtractor = new QueryExtractorImpl();
        WaitingTimelineExtractor waitingTimelineExtractor = new WaitingTimelineExtractorImpl();

        MainExecutor mainExecutor = new MainExecutorImpl(queryExtractor,waitingTimelineExtractor,storageService);

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <=lineCount; i++){
            sb.append(mainExecutor.executeQuery(args[i]));
        }
        System.out.println(sb);
    }
}
