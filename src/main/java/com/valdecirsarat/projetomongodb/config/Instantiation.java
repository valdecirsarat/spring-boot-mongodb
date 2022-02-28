package com.valdecirsarat.projetomongodb.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.valdecirsarat.projetomongodb.domain.Post;
import com.valdecirsarat.projetomongodb.domain.User;
import com.valdecirsarat.projetomongodb.repository.PostRepository;
import com.valdecirsarat.projetomongodb.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		userRepository.deleteAll();
		
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");

		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		
		Post post1 = new Post(null, Instant.parse("2019-06-20T19:53:07Z"), "partiu viagem", "Vou viajar para São paulo. Abraços", maria);
		Post post2 = new Post(null, Instant.parse("2020-06-20T19:53:07Z"), "Bom dia", "Acordei feliz hj",maria);
		postRepository.saveAll(Arrays.asList(post1, post2));
	}
	

}
