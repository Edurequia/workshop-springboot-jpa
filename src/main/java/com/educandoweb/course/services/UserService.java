package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

@Service // registra a classe como um componente do spring, 
// dai ele vai poder ser injetado automaticamente com o @Autowired no UserService
public class UserService {
	
	@Autowired // Spring faz automaticamente associação com a classe UserRepository, fazendo injeção de dependencia
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id); //optional é implementado pois o repository.findById pode 
		return obj.get();			   // retornar um valor nulo, dai o obj.get retorna o valor q ta contido
	}									// no optional, que pode ser o id ou uma exceção por estar vazio
	
}
