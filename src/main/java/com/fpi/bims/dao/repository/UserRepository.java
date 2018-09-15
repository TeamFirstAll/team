package com.fpi.bims.dao.repository;

import com.fpi.bims.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author  kangkang_sun
 * @date  2018/01/15
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    /**
     * 根据名称查询用户信息
     * @param name
     * @return
     */
    @Query("select t from User t where t.name = :name")
    User findByUserName(@Param("name") String name);

    /**
     * 根据名称查询用户分页信息
     * @param name
     * @param pageable
     * @return
     */
    @Query(value = "select * from t_b_user t where t.name like %:name% ORDER BY ?#{#pageable}",
            countQuery = "select count(*) from tbl_user t where t.name like %:name%",
            nativeQuery = true)
    Page<User> findPageByName(@Param("name") String name, Pageable pageable);

}
