package com.springbootlearning.SpringSecEx.Service;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.springbootlearning.SpringSecEx.Model.UserPrinciple;
import com.springbootlearning.SpringSecEx.Model.Users;
import com.springbootlearning.SpringSecEx.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = repo.findByUsername(username);
        if (user == null) {
            System.out.println("user not found");
            throw new UsernameNotFoundException("user not found");

        }
        return new UserPrinciple(user);
    }
}
