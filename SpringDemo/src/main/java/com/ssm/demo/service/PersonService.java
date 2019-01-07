package com.ssm.demo.service;

import com.ssm.demo.entity.User;

public interface PersonService {

    /**
     * 根据id查找具体用户
     * @param id
     * @return
     */
    User findPersonById(long id);
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
    void updataPerson(User person);

    /**
     * 插入用户信息
     * @param person
     */
    void insertPerson(User person);

}
