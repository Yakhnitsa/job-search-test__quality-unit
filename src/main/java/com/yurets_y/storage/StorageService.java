package com.yurets_y.storage;

import com.yurets_y.entity.QueryEntity;
import com.yurets_y.entity.StorageEntity;

import java.util.List;

public interface StorageService {

    List<StorageEntity> findByQueryEntity(QueryEntity queryEntity);

    void save(StorageEntity entity);

}
