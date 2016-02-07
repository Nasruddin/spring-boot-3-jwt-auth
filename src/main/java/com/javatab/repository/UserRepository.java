package com.javatab.repository;

import com.javatab.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

  public User findByUsername(String username);

}
