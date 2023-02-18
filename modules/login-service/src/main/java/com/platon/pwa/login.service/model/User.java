package com.platon.pwa.login.service.model;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
public class User implements Serializable {
    
    private String userName;
    
    private String password;
    
}
