package com.example.starbuckcustomermanager.configuration.mernis;

import com.example.starbuckcustomermanager.mernis.DAKKPSPublicSoap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MernisConfig {
    @Bean
    public DAKKPSPublicSoap getMernis(){
        return new DAKKPSPublicSoap();
    }

}
