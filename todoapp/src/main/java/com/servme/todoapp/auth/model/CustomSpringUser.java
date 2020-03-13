package com.servme.todoapp.auth.model;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class CustomSpringUser  extends org.springframework.security.core.userdetails.User{

    @Getter
    private Long userId;

    public CustomSpringUser(String username, String password, Collection<? extends GrantedAuthority> authorities, Long userId) {
        super(username, password, authorities);
        this.userId = userId;
    }

    public CustomSpringUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }
}
