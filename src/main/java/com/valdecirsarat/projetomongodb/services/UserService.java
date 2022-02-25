package com.valdecirsarat.projetomongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valdecirsarat.projetomongodb.domain.User;
import com.valdecirsarat.projetomongodb.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
		
	}

}
