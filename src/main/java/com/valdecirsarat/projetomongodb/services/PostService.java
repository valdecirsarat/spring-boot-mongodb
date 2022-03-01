package com.valdecirsarat.projetomongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valdecirsarat.projetomongodb.domain.Post;
import com.valdecirsarat.projetomongodb.repository.PostRepository;
import com.valdecirsarat.projetomongodb.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;
	
	
	public Post findById(String id) {
		
		Optional<Post> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado"));
			
	}
	
	public List<Post> findByTitle(String text){
		return repository.findByTitle(text);
	}
}














