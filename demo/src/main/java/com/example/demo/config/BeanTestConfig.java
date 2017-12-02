package com.example.demo.config;

import com.example.demo.repository.NotaRepository;
import com.example.demo.service.NotaService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import java.awt.print.PrinterAbortException;

// l'annotazione viene utilizzata per identificare che la classe verra utilizzata
// come Configuration nel profilo di test
@Profile("test")
@Configuration
public class BeanTestConfig {


    /*
        definisce il nome per il Bean che viene creato in fase di startUp da spring boot
        quando si attiva il profilo test
     */
    @Bean(name = "notaTestRepository")
    /*
        come suggerise l'annotazione viene utilizzata per vincolare spring boot a utilizzare
        questo bean quando richiesto. Es: quando richiesto con l'annotazione @Autowired
     */
    @Primary
    public NotaRepository notaRepository(){
        return Mockito.mock(NotaRepository.class);
    }

    @Bean(name = "notaTestService" )
    @Primary
    public NotaService notaService(NotaService notaService){
        return Mockito.spy( notaService);
    }

}
