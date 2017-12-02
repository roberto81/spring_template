package com.example.demo.repository;

import com.example.demo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/*
    questa interfaccia realizza le operazioni CRUD per l'entitò Person.
 */
public interface Personrepository extends JpaRepository<Person,Integer> {

    @Override
    List<Person> findAll();

    @Override
    Person findOne(Integer integer);

    @Override
    <S extends Person> S save(S s);

    @Override
    void delete(Integer integer);

    @Override
    void delete(Person person);

    @Override
    <S extends Person> S saveAndFlush(S s);
}
