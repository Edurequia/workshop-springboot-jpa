package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.repositories.CategoryRepository;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;

@Service // registra a classe como um componente do spring, 
// dai ele vai poder ser injetado automaticamente com o @Autowired no CategoryService
public class CategoryService {
	
	@Autowired // Spring faz automaticamente associação com a classe CategoryRepository, fazendo injeção de dependencia
	private CategoryRepository repository;
	
	public List<Category> findAll(){
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id); //optional é implementado pois o repository.findById pode 
		return obj.get();			   // retornar um valor nulo, dai o obj.get retorna o valor q ta contido
	}									// no optional, que pode ser o id ou uma exceção por estar vazio
	
	public Category insert(Category category) {
		return repository.save(category);
	}
}
