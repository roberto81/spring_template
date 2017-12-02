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

/*
    Come suggerisce il nome dell'annotazione permette di attivare uno specifico profilo
    quando viene avviata l'applicazione e creatto l'application context
 */
@ActiveProfiles("test")
/*
    l'annotazione @RunWith permette di avviare il test tramite la classe specificata
    nella classe.
    SpringJUnit4ClassRunner.class è l'estensione della classe BlockJUnit4ClassRunner.
    SpringJUnit4ClassRunner fornisce le funzionalitò di Spring TextContext Framework a
    JUnit standard mediante TestContextManager e le relative classi di supporto e annotazioni.
 */
@RunWith(SpringJUnit4ClassRunner.class)
/*
    L'annotazione viene utilizzata per creare un ApplicationContext da utilizzare per il test
    in questo caso l'unico ApplicationContext definito è quello della classe DemoApplication
 */
@SpringBootTest
public class NotaServiceTest {

    /*
        l'autowired della proprietà notaTestRepository sarò assegnata a un oggetto Mock definito
        nella classe BeanTestConfig per i seguenti motivi:
        1) Questa classe è annotata con l'annotazione @ActiveProfiles("test")
        2) Dato che il profilo attivato è quello di test verranno creati tutti i Bean definiti nella
           classe BeanTestConfig.
        3) Di tutti i Bean creati prendiamo quello con il nome notaTestRepository e questo si puo fare
           chiamando la proprietà in questa classe con il nome assegnato al Bean.
     */
    @Autowired
    private NotaRepository notaTestRepository;

    // come l'Autowired precedente
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
