package com.yurets_y.storage;

import com.yurets_y.entity.QueryEntity;
import com.yurets_y.entity.WaitingTimelineEntity;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class StorageServiceImpl implements StorageService{

    private List<WaitingTimelineEntity> storageEntities;

    public StorageServiceImpl() {
        storageEntities = new LinkedList<>();
    }

    @Override
    public List<WaitingTimelineEntity> findByQueryEntity(QueryEntity queryEntity) {
        return storageEntities.stream()
                .filter(storageEntity -> isStorageEntityMatchesQueryEntity(storageEntity,queryEntity))
                .collect(Collectors.toList());
    }

    @Override
    public void save(WaitingTimelineEntity entity) {
        storageEntities.add(entity);
    }

    public boolean isStorageEntityMatchesQueryEntity(WaitingTimelineEntity wtEntity, QueryEntity queryEntity){


        if(!isIdMatches(wtEntity.getServiceId(),queryEntity.getServiceId())) return false;
        if(!isIdMatches(wtEntity.getQuestionId(),queryEntity.getQuestionId())) return false;
        if(wtEntity.getResponseType() != queryEntity.getResponseType()) return false;

        return isDateMatchesPeriod(wtEntity.getDate(),queryEntity.getDateFrom(),queryEntity.getDateUntil());
    }

    private boolean isDateMatchesPeriod(Date testDate, Date dateFrom, Date dateUntil){
        if(dateFrom == null) return false;
        return  (!testDate.before (dateFrom) && (dateUntil == null || !testDate.after (dateUntil)));
    }

    private boolean isIdMatches(String storageEntityId, String queryId){
        if(queryId.matches("\\*")) return true;
        String serviceIdPattern = queryId + "(\\.\\d+)?(\\.\\d+)?";
        return storageEntityId.matches(serviceIdPattern);
    }
}
