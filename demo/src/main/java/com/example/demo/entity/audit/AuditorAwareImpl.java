package com.example.demo.entity.audit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.AuditorAware;

/*
    implementazione dell'interfaccia AiditorAware che sarà utilizzata da JPA per
    popolare i campi delle entita annotati con @CreatedBy @LastModifiedBy
 */
public class AuditorAwareImpl implements AuditorAware<String> {

    @Value("${spring.application.name}")
    private String createBy;

    @Override
    public String getCurrentAuditor() {
        return createBy;
    }


}
