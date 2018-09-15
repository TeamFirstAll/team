package com.fpi.bims.service;

import com.fpi.bims.model.BaseRegion;
import com.fpi.bims.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author  kangkang_sun
 * @date  2018/01/15
 */
@Service
public interface UserService {

    /**
     * 添加用户信息
     *
     * @param user
     */
    public void saveUser(User user);

    /**
     * 更新用户信息
     *
     * @param user
     */
    public void updateUser(User user);


    /**
     * 删除用户信息
     *
     * @param id
     */
    public void deleteUserById(Long id);

    /**
     * 根据yonghuID查询用户信息
     *
     * @param id
     * @return
     */
    public User findUserById(Long id);


    /**
     * 根据用户名称查询用户信息
     *
     * @param name
     * @return
     */
    public User findUserByName(String name);

    /**
     * 根据用户名称查询用户列表
     * @param name
     * @param pageable
     * @return
     */
    public Page<User> findPageByName(String name, Pageable pageable);

    /**
     * 根据用户名称查询用户列表
     * @return
     */
    public List<BaseRegion> findRegion(String name, Pageable pageable);

}