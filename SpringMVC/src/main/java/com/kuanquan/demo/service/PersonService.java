package com.kuanquan.demo.service;

import com.kuanquan.demo.entity.Person;

public interface PersonService {
    Person findPersonById(long id);
    String findPersonName(long id);
    void deletePerson(long id);
    void updataPerson(Person person);
    void insertPerson(Person person);
}
