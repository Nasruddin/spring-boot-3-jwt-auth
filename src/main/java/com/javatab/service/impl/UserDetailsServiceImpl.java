package com.javatab.service.impl;

import com.javatab.domain.entity.User;
import com.javatab.model.factory.UserFactory;
import com.javatab.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User aUser = this.userRepository
            .findByUsername(username)
            .orElseThrow(
                    () -> new UsernameNotFoundException(String.format("No user found with username '%s'.", username)));
    return UserFactory.create(aUser);
  }

}
