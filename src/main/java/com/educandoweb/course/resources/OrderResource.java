package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.services.OrderService;

@RestController // indica que OrderResource é um controlador REST, que lida com as requisições HTTP e retorna as respostas adequadas 
@RequestMapping(value = "/orders")
public class OrderResource {
	
	@Autowired
	private OrderService service;
	
	@GetMapping // mapear uma rota HTTP GET para o método findAll()
	public ResponseEntity<List<Order>> findAll(){ // ResponseEntity permite retornar respostas HTTP personalizadas,
		List<Order> list = service.findAll();	//especificando o corpo, o status e os cabeçalhos da resposta. 
		return ResponseEntity.ok().body(list);	//Isso ajuda a controlar melhor o formato da resposta e 
												//fornecer informações adicionais ao cliente que está consumindo a API.
	
	}
	
	@GetMapping(value = "/{id}") //indica que a requisição aceita um id dentro da url
	public ResponseEntity<Order> findById(@PathVariable Long id){
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
