package com.gmail.romkatsis.healthhub.utils.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    CUSTOMER, DOCTOR;

    @Override
    public String getAuthority() {
        return name();
    }
}
