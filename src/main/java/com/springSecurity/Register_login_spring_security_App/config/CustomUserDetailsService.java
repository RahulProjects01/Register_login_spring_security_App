package com.springSecurity.Register_login_spring_security_App.config;

import com.springSecurity.Register_login_spring_security_App.entity.User;
import com.springSecurity.Register_login_spring_security_App.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      User user =  userRepo.findByEmail(username);

      if(user == null){
          throw new UsernameNotFoundException("user not found");
      }else {
          return new CustomUser(user);
      }
    }
}
