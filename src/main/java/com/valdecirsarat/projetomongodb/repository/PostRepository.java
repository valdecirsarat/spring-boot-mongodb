package com.valdecirsarat.projetomongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.valdecirsarat.projetomongodb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
	

}
