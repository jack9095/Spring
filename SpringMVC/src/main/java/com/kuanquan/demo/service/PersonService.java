package com.kuanquan.demo.service;

import com.kuanquan.demo.entity.User;

public interface PersonService {
    // 根据id查找具体用户
    User findPersonById(long id);
    // 根据id查找用户名称
    String findPersonName(long id);
    // 根据id删除用户
    void deletePerson(long id);
    // 更新用户信息
    void updataPerson(User person);
    // 插入用户信息
    void insertPerson(User person);
}
