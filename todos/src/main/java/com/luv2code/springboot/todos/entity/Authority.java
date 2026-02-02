package com.luv2code.springboot.todos.entity;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Embeddable;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
public class Authority implements GrantedAuthority {

    @SuppressWarnings("unused")
    private String authority;

    public Authority(String authority) {
        this.authority = authority;
    }

    @Override
    public @Nullable String getAuthority() {
        return null;
    }

}
