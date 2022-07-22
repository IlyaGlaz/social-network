package org.glaz.network.database.entity.enums;

import org.springframework.security.core.GrantedAuthority;

public enum UserType implements GrantedAuthority {

    USER,
    MODERATOR,
    ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
