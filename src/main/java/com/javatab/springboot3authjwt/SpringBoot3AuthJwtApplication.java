package com.javatab.springboot3authjwt;

import com.javatab.springboot3authjwt.model.ApplicationUser;
import com.javatab.springboot3authjwt.model.Authority;
import com.javatab.springboot3authjwt.model.EAuthority;
import com.javatab.springboot3authjwt.repository.AuthorityRepository;
import com.javatab.springboot3authjwt.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class SpringBoot3AuthJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot3AuthJwtApplication.class, args);
	}

	@Bean
	CommandLineRunner run(AuthorityRepository authorityRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			if (authorityRepository.findByAuthority(EAuthority.ADMIN).isPresent()) return;
			authorityRepository.save(new Authority(EAuthority.USER));
			List<Authority> lAuthority =  authorityRepository.saveAll(
					List.of(new Authority(EAuthority.ADMIN), new Authority(EAuthority.WRITE), new Authority(EAuthority.READ)));
			Set<Authority> authorities = new HashSet<>(lAuthority);
			ApplicationUser admin = new ApplicationUser(1, "admin", passwordEncoder.encode("password"), authorities);
			userRepository.save(admin);
		};
	}
}
