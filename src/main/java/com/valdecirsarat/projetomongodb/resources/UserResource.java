package com.valdecirsarat.projetomongodb.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.valdecirsarat.projetomongodb.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity< List<User>> findAll(){
		List<User> list = new ArrayList<>();
		User maria = new User("001", "Maria", "maria@gmail.com");
		User bob = new User("002", "Bob", "bob@gmail.com");
		User alex = new User("003", "Alex", "alex@gmail.com");
		
		list.addAll(Arrays.asList(maria, bob, alex));
		
		return ResponseEntity.ok().body(list);
	}

}
