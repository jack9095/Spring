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

    @Override
    public String findPersonName(long id) {
        return personMapperDao.findPersonName(id);
    }

    @Override
    public void deletePerson(long id) {
        System.out.println("删除一条记录 id = " + id);
        personMapperDao.deletePerson(id);
    }

    @Override
    public void updataPerson(Person person) {
        personMapperDao.updataPerson(person);
    }

    @Override
    public void insertPerson(Person person) {
        personMapperDao.insertPerson(person);
    }
}
