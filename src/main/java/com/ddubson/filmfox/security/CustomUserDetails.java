package com.ddubson.filmfox.security;

import com.ddubson.filmfox.models.User;
import com.ddubson.filmfox.models.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CustomUserDetails implements UserDetails {
    private static final long serialVersionUID = 1L;
    private User user;
    private List<String> userRoles;

    public CustomUserDetails(User user, List<UserRole> userRoles) {
        this.user = user;
        if (userRoles != null && userRoles.size() > 0) {
            this.userRoles = userRoles.stream().map(UserRole::getRole).collect(Collectors.toList());
        } else {
            this.userRoles = null;
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String roles = StringUtils.collectionToCommaDelimitedString(userRoles);
        return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
