package com.travel.authservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
public class Role {
    @Id
    private String id;
    private String roleName;
}
