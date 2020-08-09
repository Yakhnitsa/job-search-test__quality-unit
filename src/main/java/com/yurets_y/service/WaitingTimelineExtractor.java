package com.yurets_y.service;

import com.yurets_y.entity.WaitingTimelineEntity;

public interface WaitingTimelineExtractor {
    WaitingTimelineEntity getWaitingTimelineEntity(String query);
}
