package org.senac.bd.controller;

import java.util.List;

import javax.validation.Valid;

import org.senac.bd.domain.Marca;
import org.senac.bd.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/marca")
public class MarcaController {
	
	@Autowired
	private MarcaRepository repository;
	
	@GetMapping
	public List<Marca> findAll() {
		Sort s = Sort.by("nome", "id");
		return repository.findAll(s);
	}
	
	@PostMapping
	public Marca save(@RequestBody @Valid Marca m) {
		return repository.save(m);
	}
	

}
