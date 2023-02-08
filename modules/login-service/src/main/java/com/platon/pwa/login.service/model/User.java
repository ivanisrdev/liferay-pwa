package com.platon.pwa.login.service.model;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class User implements Serializable {
    
    private final String userName;
    
    private final String password;
    
}
