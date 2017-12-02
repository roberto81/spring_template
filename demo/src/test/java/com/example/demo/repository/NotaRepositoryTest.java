package com.example.demo.repository;


import com.example.demo.entity.Nota;
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
public class NotaRepositoryTest {

    @Autowired
    private NotaRepository notaTestRepository;

    @Test
    public void addNotaTest(){

        Nota nota1 = new Nota();
        nota1.setId(1);
        nota1.setTitle("prima");
        nota1.setDescription("prima descrizione");

        Mockito.when(notaTestRepository.save( Mockito.any(Nota.class))).thenReturn(nota1);
        Nota nota1Result1 = notaTestRepository.save(nota1);
        Assert.assertNotNull("Nota not be null", nota1Result1);

        Assert.assertEquals(nota1Result1.getId(),nota1.getId());
        Assert.assertEquals(nota1Result1.getTitle(), nota1.getTitle());
        Assert.assertEquals(nota1Result1.getDescription(),nota1.getDescription());

        Nota nota2 = new Nota();
        nota2.setId(2);
        nota2.setTitle("seconda");
        nota2.setDescription("seconda descrizione");

        Mockito.when(notaTestRepository.save( Mockito.any(Nota.class))).thenReturn(nota2);
        Nota nota1Result2 = notaTestRepository.save(nota2);
        Assert.assertNotNull("Nota not be null", nota1Result2);

        Assert.assertEquals(nota1Result2.getId(),nota2.getId());
        Assert.assertEquals(nota1Result2.getTitle(), nota2.getTitle());
        Assert.assertEquals(nota1Result2.getDescription(),nota2.getDescription());

        Assert.assertNotEquals(nota1Result1,nota1Result2);
    }

}
