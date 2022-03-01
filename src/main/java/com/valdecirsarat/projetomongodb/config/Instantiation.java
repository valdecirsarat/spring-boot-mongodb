package com.valdecirsarat.projetomongodb.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.valdecirsarat.projetomongodb.domain.Post;
import com.valdecirsarat.projetomongodb.domain.User;
import com.valdecirsarat.projetomongodb.dto.AuthorDTO;
import com.valdecirsarat.projetomongodb.dto.CommentDTO;
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
		
		
		Post post1 = new Post(null, Instant.parse("2019-06-20T19:53:07Z"), "partiu viagem", "Vou viajar para São paulo. Abraços",new AuthorDTO( maria));
		Post post2 = new Post(null, Instant.parse("2020-06-20T19:53:07Z"), "Bom dia", "Acordei feliz hj",new AuthorDTO( maria));
		
		CommentDTO c1 = new CommentDTO("Valeu mano", Instant.parse("2019-06-20T19:57:07Z"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Aproveite", Instant.parse("2019-06-20T20:57:07Z"), new AuthorDTO(bob));
		CommentDTO c3 = new CommentDTO("Tenha um otimo dia", Instant.parse("2021-06-20T19:57:07Z"), new AuthorDTO(alex));
		
		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().addAll(Arrays.asList(c3));
		
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
	}
	

}
