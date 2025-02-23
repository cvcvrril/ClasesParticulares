package org.example.config;

import org.example.dao.data.StaticLists;
import org.springframework.context.annotation.Bean;


@org.springframework.context.annotation.Configuration
public class Config {

    /**
     * Arreglar dependencias relacionadas con mysql
     * **/

    @Bean
    public StaticLists staticLists(){
        return new StaticLists();
    }

}
