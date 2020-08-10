package com.yurets_y.application.service;

import com.yurets_y.application.entity.WaitingTimelineEntity;
import com.yurets_y.application.storage.StorageService;
import com.yurets_y.application.entity.QueryEntity;

import java.util.List;

public class MainExecutorImpl implements MainExecutor {

    private final String LINE_SEPARATOR = System.lineSeparator();

    private QueryExtractor queryExtractor;

    private WaitingTimelineExtractor wtExtractor;

    private StorageService storage;

    public MainExecutorImpl(QueryExtractor queryExtractor, WaitingTimelineExtractor wtExtractor, StorageService storage) {
        this.queryExtractor = queryExtractor;
        this.wtExtractor = wtExtractor;
        this.storage = storage;
    }

    @Override
    public String executeQuery(String query) {
        String queryPattern = "^D\\s.*";
        String wtPattern = "^C\\s.*";

        if(query.matches(queryPattern)){
            QueryEntity queryEntity = queryExtractor.getQuery(query);
            if(queryEntity != null){
                List<WaitingTimelineEntity> storageEntities = storage.findByQueryEntity(queryEntity);
                return getAverageData(storageEntities);
            }
            return "";
        }
        else if(query.matches(wtPattern)){
            WaitingTimelineEntity wtEntity = wtExtractor.getWaitingTimelineEntity(query);
            if(wtEntity != null)
                storage.save(wtEntity);
        }
        return "";
    }

    private String getAverageData(List<WaitingTimelineEntity> storageEntities){
        Double average = storageEntities.stream()
                .mapToLong(WaitingTimelineEntity::getWaitingTime)
                .average()
                .orElse(-1);

        return average == -1 ? "-" + LINE_SEPARATOR
            :Math.round(average) + LINE_SEPARATOR;
    }
}
