package com.yurets_y.service;

import com.yurets_y.entity.QueryEntity;
import com.yurets_y.entity.StorageEntity;
import com.yurets_y.storage.StorageService;

import java.util.List;

public class MainExecutorImpl implements MainExecutor {

    private final String LINE_SEPARATOR;

    private QueryExtractor queryExtractor;

    private WaitingTimelineExtractor wtExtractor;

    private StorageService storage;

    public MainExecutorImpl(QueryExtractor queryExtractor, WaitingTimelineExtractor wtExtractor, StorageService storage) {
        this.LINE_SEPARATOR = System.lineSeparator();
        this.queryExtractor = queryExtractor;
        this.wtExtractor = wtExtractor;
        this.storage = storage;
    }

    @Override
    public String executeQuery(String query) {
        String queryPattern = "^[D,d]\\s.*";
        String wtPattern = "^[C,c]\\s.*";

        if(query.matches(queryPattern)){
            QueryEntity queryEntity = queryExtractor.getQuery(query);
            if(queryEntity != null){
                List<StorageEntity> storageEntities = storage.findByQueryEntity(queryEntity);
                return getStatisticData(storageEntities);
            }
            return "";
        }
        else if(query.matches(wtPattern)){
            StorageEntity storageEntity = wtExtractor.getStorageEntity(query);
            if(storageEntity != null)
                storage.save(storageEntity);
        }
        return "";
    }

    private String getStatisticData(List<StorageEntity> storageEntities){

        return "-";
    }
}
