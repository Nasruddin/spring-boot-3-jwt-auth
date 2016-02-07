package com.javatab;

import com.javatab.domain.entity.Task;
import com.javatab.domain.entity.User;
import com.javatab.repository.TaskRepository;
import com.javatab.repository.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class AuthJwtBootApplication {

	@Bean
	public InitializingBean insertDefaultUsers() {
		return new InitializingBean() {

			@Autowired
			private UserRepository userRepository;

			@Autowired
			private TaskRepository taskRepository;

			@Override
			public void afterPropertiesSet() {
				addUser("admin", "admin");
				addUser("user", "user");

				addTask(1, "I have to create a repo", false);
				addTask(2, "Commit to the repo", false);
				addTask(3, "Add proper README", false);
			}

			private void addUser(String username, String password) {
				User user = new User();
				user.setUsername(username);
				user.setPassword(new BCryptPasswordEncoder().encode(password));
				user.setAuthorities(username.equals("admin") ? "ADMIN" : "USER");
				userRepository.save(user);
			}

			private void addTask(long id, String aTask, boolean isCompleted) {
				Task task = new Task();
				task.setId(id);
				task.setTask(aTask);
				task.setCompleted(isCompleted);
				taskRepository.save(task);
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(AuthJwtBootApplication.class, args);
	}
}
