package com.study.auth.security.service;

import com.study.auth.security.model.SecurityUser;
import com.study.auth.security.repository.SecurityUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private SecurityUserRepository securityUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SecurityUser user = securityUserRepository.findByUsername(username);
        if (user != null) {
            return user;
        }
        throw new UsernameNotFoundException(username);
    }

}
