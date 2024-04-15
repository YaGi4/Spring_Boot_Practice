package com.example.Practice.Service;

import com.example.Practice.Model.Role;
import lombok.Data;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Data
public class JwtAuthentication implements Authentication {

    private boolean authenticated;
    private String userName;
    private Set<Role> roles = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { return roles; }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return userName;
    }

    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        this.authenticated = isAuthenticated;
    }

    @Override
    public String getName() { return userName; }

    public void setAuthorities(Role role) { this.roles.add(role); }
}
