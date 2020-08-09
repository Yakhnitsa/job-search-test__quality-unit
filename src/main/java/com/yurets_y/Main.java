package com.yurets_y;

import com.yurets_y.service.*;
import com.yurets_y.storage.StorageService;
import com.yurets_y.storage.StorageServiceImpl;

import java.util.Arrays;

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
        String lineSeparator = System.lineSeparator();
        String[] args = arg.split(lineSeparator);
        execute(args);
    }
    private static void execute(String[] args){
        StorageService storageService = new StorageServiceImpl();
        QueryExtractor queryExtractor = new QueryExtractorImpl();
        WaitingTimelineExtractor waitingTimelineExtractor = new WaitingTimelineExtractorImpl();

        MainExecutor mainExecutor = new MainExecutorImpl(queryExtractor,waitingTimelineExtractor,storageService);

        StringBuilder sb = new StringBuilder();
        Arrays.asList(args).forEach(line ->{
            sb.append(mainExecutor.executeQuery(line));
        });
        System.out.println(sb);
    }
}
