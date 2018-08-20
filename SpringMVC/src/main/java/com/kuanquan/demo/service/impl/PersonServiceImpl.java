package com.kuanquan.demo.service.impl;

import com.kuanquan.demo.dao.PersonMapperDao;
import com.kuanquan.demo.entity.Person;
import com.kuanquan.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("personServiceImpl")
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonMapperDao personMapperDao;
    public Person findPersonById(long id) {
        return personMapperDao.findPersonById(id);
    }
}
