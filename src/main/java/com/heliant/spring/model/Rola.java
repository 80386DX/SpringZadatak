package com.heliant.spring.model;

import org.springframework.security.core.GrantedAuthority;

public enum Rola implements GrantedAuthority {
    RADNIK, ADMIR;


    @Override
    public String getAuthority() {
        return null;
    }
}
