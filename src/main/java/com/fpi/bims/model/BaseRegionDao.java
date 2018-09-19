package com.fpi.bims.model;

import java.util.List;

public interface BaseRegionDao {

    List<BaseRegion> selectByPrimaryKey(String name);
}
