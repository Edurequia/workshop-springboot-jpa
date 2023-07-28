package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;

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
		return obj.orElseThrow(() -> new ResourceNotFoundException(id)); // retornar um valor nulo, dai o obj.get retorna o valor q ta contido
	}												// no optional, que pode ser o id ou uma exceção por estar vazio
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public User update(Long id, User obj) {
		//não fica no banco de dados ainda, assim da pra mexer nele e dps efetuar operação no banco
		User entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
