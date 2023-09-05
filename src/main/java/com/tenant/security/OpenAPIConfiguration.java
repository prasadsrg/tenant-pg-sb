package com.tenant.security;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@SecurityScheme(
//        name = "Authorization", // can be set to anything
//        type = SecuritySchemeType.HTTP,
//        scheme = "bearer-key"
//)
@OpenAPIDefinition(
        info = @Info(title = "Tenant API", version = "v1"),
        security = @SecurityRequirement(name = "bearer-key")
)
//@Operation(security = { @SecurityRequirement(name = "bearer-key") })
//@Operation(security = { @SecurityRequirement(name = "bearer-key") })
class OpenAPIConfiguration {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")));
    }
}

//eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMSIsImF1ZCI6IjEiLCJzY29wZXMiOlt7ImF1dGhvcml0eSI6IlJPTEVfQURNSU4ifV0sImlzcyI6InN5c3RlbSIsImlhdCI6MTYyMDkxMzA5NiwiZXhwIjoxNjIwOTMxMDk2fQ.sA9qeiLg5eNKfqWRApkVtH-DKGUqUZDkD2GHzoKQXK4