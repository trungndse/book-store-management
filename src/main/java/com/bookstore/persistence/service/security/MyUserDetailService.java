package com.bookstore.persistence.service.security;


import com.bookstore.persistence.model.Role;
import com.bookstore.persistence.model.User;
import com.bookstore.persistence.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service("userDetailsService")
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserService service;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = service.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("No user found with username: " + email);
        }

        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        return  new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword().toLowerCase()
                , enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, getAuthorities(user.getRoles()) );
    }

    private static List<GrantedAuthority> getAuthorities (Collection<Role> roles) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }

}
