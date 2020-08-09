package com.yurets_y.storage;

import com.yurets_y.entity.QueryEntity;
import com.yurets_y.entity.WaitingTimelineEntity;

import java.util.List;

public interface StorageService {

    List<WaitingTimelineEntity> findByQueryEntity(QueryEntity queryEntity);

    void save(WaitingTimelineEntity entity);

}
