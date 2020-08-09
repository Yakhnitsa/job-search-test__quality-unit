package com.yurets_y.service;

import com.yurets_y.entity.QueryEntity;

public interface QueryExtractor {

    QueryEntity getQuery(String query);
}
