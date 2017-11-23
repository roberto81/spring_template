package com.example.demo.config;

import com.example.demo.repository.NotaRepository;
import com.example.demo.service.NotaService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import java.awt.print.PrinterAbortException;

@Profile("test")
@Configuration
public class BeanTestConfig {


    @Bean(name = "notaTestRepository")
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
