package com.fpi.bims.service;

import com.fpi.bims.dao.repository.UserRepository;
import com.fpi.bims.model.BaseRegion;
import com.fpi.bims.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author  kangkang_sun
 * @date  2018/01/15
 */
@Service
public class UserServiceImpl implements UserService {

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private JdbcTemplate jdbcTemplate;



    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateUser(User user) {
        saveUser(user);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.delete(id);
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public User findUserByName(String name) {
        return userRepository.findByUserName(name);
    }

    @Override
    public Page<User> findPageByName(String name, Pageable pageable) {
        logger.info("findPageByName, name=" + name);
        return userRepository.findPageByName(name, pageable);
    }

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

}