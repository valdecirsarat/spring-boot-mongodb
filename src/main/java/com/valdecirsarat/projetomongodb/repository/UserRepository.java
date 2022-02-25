package com.valdecirsarat.projetomongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.valdecirsarat.projetomongodb.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
	

}
