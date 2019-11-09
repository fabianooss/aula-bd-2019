package org.senac.bd.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.senac.bd.domain.Carro;
import org.senac.bd.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carro")
public class CarroController {
	
	@Autowired
	private CarroRepository repository;
	
	@GetMapping
	public List<Carro> findAll() {
		return repository.findAll();
	}
	
	@PostMapping
	public Carro salvar(@RequestBody @Valid Carro carro) {
		return repository.save(carro);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> find(@PathVariable("id") Integer id) {
		Optional<Carro> carro = repository.findById(id);
		if (carro.isPresent()) {
			return ResponseEntity.ok(carro.get());
		}
		return ResponseEntity.notFound().build();
	}
}
