package com.yurets_y.storage;

import com.yurets_y.entity.QueryEntity;
import com.yurets_y.entity.StorageEntity;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class StorageServiceImpl implements StorageService{

    private List<StorageEntity> storageEntities;

    public StorageServiceImpl() {
        storageEntities = new LinkedList<>();
    }

    @Override
    public List<StorageEntity> findByQueryEntity(QueryEntity queryEntity) {
        return storageEntities.stream()
                .filter(storageEntity -> isStorageEntityMatchesQueryEntity(storageEntity,queryEntity))
                .collect(Collectors.toList());
    }

    @Override
    public void save(StorageEntity entity) {
        storageEntities.add(entity);
    }

    public boolean isStorageEntityMatchesQueryEntity(StorageEntity storageEntity, QueryEntity queryEntity){


        if(!isIdMatches(storageEntity.getServiceId(),queryEntity.getServiceId())) return false;
        if(!isIdMatches(storageEntity.getQuestionId(),queryEntity.getQuestionId())) return false;
        if(storageEntity.getResponseType() != queryEntity.getResponseType()) return false;

        return isDateMatchesPeriod(storageEntity.getDate(),queryEntity.getDateFrom(),queryEntity.getDateUntil());
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
