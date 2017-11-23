package com.example.demo.service;

import com.example.demo.dto.NotaDTO;
import com.example.demo.entity.Nota;
import com.example.demo.repository.NotaRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class NotaServiceTest {

    @Autowired
    private NotaRepository notaTestRepository;

    @Autowired
    private NotaService notaTestService;

    @Test
    public void addNotaTest(){

        Nota nota = new Nota();
        nota.setId(1);
        nota.setTitle("prima");
        nota.setDescription("prima nota");

        Nota notaMock = Mockito.spy(nota);

        NotaDTO nota1 = new NotaDTO();
        nota1.setTitle("prima");
        nota1.setDescription("prima nota");

        Mockito.when(notaTestRepository.save(Mockito.any(Nota.class))).thenReturn(notaMock);
        NotaDTO resultSave = notaTestService.addNota(nota1);

        Assert.assertNotNull("nota not null", resultSave);
    }

}
