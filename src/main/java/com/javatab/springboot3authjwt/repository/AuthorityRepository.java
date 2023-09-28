package com.javatab.springboot3authjwt.repository;

import com.javatab.springboot3authjwt.model.Authority;
import com.javatab.springboot3authjwt.model.EAuthority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
    Optional<Authority> findByAuthority(EAuthority authority);
}
