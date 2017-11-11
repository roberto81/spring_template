package com.example.demo.repository;

import com.example.demo.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact,Integer> {
    @Override
    List<Contact> findAll();

    @Override
    <S extends Contact> S saveAndFlush(S s);

    @Override
    <S extends Contact> S save(S s);

    @Override
    Contact findOne(Integer integer);

    @Override
    void delete(Integer integer);

    @Override
    void delete(Contact contact);

    @Override
    void flush();
}
