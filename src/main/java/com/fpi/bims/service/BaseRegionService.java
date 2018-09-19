package com.fpi.bims.service;

import com.fpi.bims.model.BaseRegion;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @author  zhaokun
 * @date  2018/09/15
 */
@Service
public interface BaseRegionService {

    /**
     * 根据用户名称查询用户列表
     * @return
     */
    public List<BaseRegion> findRegion(String name, Pageable pageable);
    /**
     * 根据用户名称查询用户列表
     * @return
     */
    public List<BaseRegion> findRegion(String name);
}
