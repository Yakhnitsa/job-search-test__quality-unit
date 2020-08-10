package com.yurets_y.application.service;

import com.yurets_y.application.entity.QueryEntity;

public interface QueryExtractor {

    QueryEntity getQuery(String query);
}
