package com.kuanquan.demo.dao;

import com.kuanquan.demo.entity.Person;
import org.springframework.stereotype.Repository;

@Repository("personMapperDao")
public interface PersonMapperDao {
    Person findPersonById(long id);
}
