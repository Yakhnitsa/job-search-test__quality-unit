package com.yurets_y.storage;

import com.yurets_y.entity.QueryEntity;
import com.yurets_y.entity.StorageEntity;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class StorageServiceImpl implements StorageService{

    private List<StorageEntity> storageEntities;

    public StorageServiceImpl() {
        storageEntities = new LinkedList<>();
    }

    @Override
    public List<StorageEntity> findByQueryEntity(QueryEntity queryEntity) {

        return null;
    }



    @Override
    public void save(StorageEntity entity) {

    }

    public boolean isStorageEntityMatchesQueryEntity(StorageEntity storageEntity, QueryEntity queryEntity){
        String optionalIndexPattern = "(\\.\\d)?(\\.\\d)?";
        String serviceIdPattern = queryEntity.getServiceId() + optionalIndexPattern;
        String questionIdPattern = queryEntity.getQuestionId() + optionalIndexPattern;

        if(!storageEntity.getServiceId().matches(serviceIdPattern)) return false;
        if(!storageEntity.getQuestionId().matches(questionIdPattern)) return false;
        if(storageEntity.getResponseType() != queryEntity.getResponseType()) return false;

        return isDateMatchesPeriod(storageEntity.getDate(),queryEntity.getDateFrom(),queryEntity.getDateUntil());
    }

    private boolean isDateMatchesPeriod(Date testDate, Date dateFrom, Date dateUntil){
        if(dateFrom == null) return false;
        return  (!testDate.before (dateFrom) && (dateUntil == null || !testDate.after (dateUntil)));
    }
}
