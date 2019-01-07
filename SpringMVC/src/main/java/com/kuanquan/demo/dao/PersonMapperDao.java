package com.kuanquan.demo.dao;

import com.kuanquan.demo.entity.Person;
import org.springframework.stereotype.Repository;

@Repository("personMapperDao")
public interface PersonMapperDao {
    /**
     * 根据id查找具体用户
     * @param id
     * @return
     */
    Person findPersonById(long id);

    /**
     * 根据id查找用户名称
     * @param id
     * @return
     */
    String findPersonName(long id);

    /**
     * 根据id删除用户
     * @param id
     */
    void deletePerson(long id);

    /**
     * 更新用户信息
     * @param person
     */
    void updataPerson(Person person);

    /**
     * 插入用户信息
     * @param person
     */
    void insertPerson(Person person);
}
