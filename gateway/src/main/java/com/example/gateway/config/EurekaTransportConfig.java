package com.example.gateway.config;


import com.netflix.discovery.shared.transport.jersey3.Jersey3TransportClientFactories;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.netflix.discovery.shared.transport.jersey.TransportClientFactories;

@Configuration
public class EurekaTransportConfig {
    @Bean
    public TransportClientFactories<?> transportClientFactories() {
        return new Jersey3TransportClientFactories();
    }
}
