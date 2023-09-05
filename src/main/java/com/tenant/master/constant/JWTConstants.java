package com.tenant.master.constant;

public class JWTConstants {

    public static final long ACCESS_TOKEN_VALIDITY_SECONDS = 5*60*60;
    public static final String SIGNING_KEY = "helloworld";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
}
//eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMSIsImF1ZCI6IjEiLCJzY29wZXMiOlt7ImF1dGhvcml0eSI6IlJPTEVfQURNSU4ifV0sImlzcyI6InN5c3RlbSIsImlhdCI6MTYyMDkxMjU5MywiZXhwIjoxNjIwOTMwNTkzfQ.E0s5O1NiqqU8SetRJGjjqD7FhARJfJrwijwxF8oyOXA