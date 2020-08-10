package com.yurets_y.application.service;

import com.yurets_y.application.entity.WaitingTimelineEntity;

public interface WaitingTimelineExtractor {
    WaitingTimelineEntity getWaitingTimelineEntity(String query);
}
