package com.example.jwtauthentications;

import com.example.jwtauthentications.model.User;
import com.example.jwtauthentications.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class JwtAuthenticationsApplication {

	@Autowired
	private UserRepository userRepository;

	@PostConstruct
	public void initUser(){
		List<User> user = Stream.of(
				new User(1,"elias","elias",1l),
				new User(2,"zak","zak",2l)
		).collect(Collectors.toList());
       userRepository.saveAll(user);
	}

	public static void main(String[] args) {
		SpringApplication.run(JwtAuthenticationsApplication.class, args);
	}

}
