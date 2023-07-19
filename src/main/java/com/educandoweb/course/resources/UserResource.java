package com.educandoweb.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;

@RestController // indica que UserResource é um controlador REST, que lida com as requisições HTTP e retorna as respostas adequadas 
@RequestMapping(value = "/users")
public class UserResource {
	
	@GetMapping // mapear uma rota HTTP GET para o método findAll()
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "Maria", "maria@gmail.com", "9999999999", "12345");
		return ResponseEntity.ok().body(u);
	}
	
}
