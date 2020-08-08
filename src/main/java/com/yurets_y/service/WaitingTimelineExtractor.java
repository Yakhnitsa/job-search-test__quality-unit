package com.yurets_y.service;

import com.yurets_y.entity.StorageEntity;

public interface WaitingTimelineExtractor {
    StorageEntity getStorageEntity(String query);
}
