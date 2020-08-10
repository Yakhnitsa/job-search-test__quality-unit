package com.yurets_y.application.storage;

import com.yurets_y.application.entity.QueryEntity;
import com.yurets_y.application.entity.WaitingTimelineEntity;

import java.util.List;

public interface StorageService {

    List<WaitingTimelineEntity> findByQueryEntity(QueryEntity queryEntity);

    void save(WaitingTimelineEntity entity);

}
