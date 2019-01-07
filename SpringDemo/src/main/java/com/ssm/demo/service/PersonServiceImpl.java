package com.ssm.demo.service;

import com.ssm.demo.dao.PersonMapperDao;
import com.ssm.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonMapperDao personMapperDao;

    @Override
    public User findPersonById(long id) {
        return personMapperDao.findPersonById(id);
    }

    @Override
    public String findPersonName(long id) {
        return personMapperDao.findPersonName(id);
    }

    @Override
    public void deletePerson(long id) {
        personMapperDao.deletePerson(id);
    }

    @Override
    public void updataPerson(User person) {
        personMapperDao.updataPerson(person);
    }

    @Override
    public void insertPerson(User person) {
        personMapperDao.insertPerson(person);
    }
}