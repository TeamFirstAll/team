package com.fpi.bims.service;

import com.fpi.bims.dao.repository.UserRepository;
import com.fpi.bims.model.BaseRegion;
import com.fpi.bims.model.BaseRegionDao;
import com.fpi.bims.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author  kangkang_sun
 * @date  2018/01/15
 */
@Service
public class BaseRegionServiceImpl implements BaseRegionService {

    Logger logger = LoggerFactory.getLogger(BaseRegionServiceImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Resource
    private BaseRegionDao baseRegionDao;


    @Override
    public List<BaseRegion> findRegion(String name, Pageable pageable) {
        List<Map<String,Object>> list = jdbcTemplate.queryForList("SELECT * FROM BASE_REGION");
        List<BaseRegion> regionList = new ArrayList<BaseRegion>();
        for (int i=0;i<list.size();i++){
            BaseRegion region = new BaseRegion();
            region.setName(list.get(i).get("name").toString());
            regionList.add(region);
        }
        return regionList;
    }

    @Override
    public List<BaseRegion> findRegion(String name) {
        List<BaseRegion> list =  new ArrayList<BaseRegion>();
        try{
             list = baseRegionDao.selectByPrimaryKey(name);
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

}