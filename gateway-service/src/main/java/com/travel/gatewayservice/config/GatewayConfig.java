package com.travel.gatewayservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Autowired
    AuthenticationFilter authenticationFilter;

    @Bean
    public RouteLocator routes(RouteLocatorBuilder routeLocatorBuilder){
        return routeLocatorBuilder.routes()
                .route("auth-service",
                        r -> r.path("/api/v1/auth/**")
                                .filters(f-> f.filter(authenticationFilter))
                                .uri("http://localhost:8081/"))

                .route("blog-service",
                        r->r.path("/api/v1/blog/**")
                                .filters(f -> f.filter(authenticationFilter))
                                .uri("http://localhost:8082"))
                .build();
    }
}
