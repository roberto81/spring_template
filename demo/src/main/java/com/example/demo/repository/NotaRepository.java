package com.example.demo.repository;

import com.example.demo.entity.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotaRepository extends JpaRepository<Nota,Integer> {
    @Override
    List<Nota> findAll();

    @Override
    void flush();

    @Override
    <S extends Nota> S save(S s);

    @Override
    Nota findOne(Integer integer);

    @Override
    void delete(Integer integer);

    @Override
    void delete(Nota nota);
}
