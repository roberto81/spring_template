package com.example.demo.config;


import com.example.demo.entity.audit.AuditorAwareImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration

/*
    abilita l'Auditing per le operazioni di insert, update, delete.
    l'annotazione un parametro opzionale che identifica il nome del Bean
 */
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class JpaConfig {

    /*
        definisce il Bean utilizzato per l'auditing
     */
    @Bean
    public AuditorAware<String> auditorAware() {
        return new AuditorAwareImpl();
    }

}
