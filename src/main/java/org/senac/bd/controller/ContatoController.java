package org.senac.bd.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.senac.bd.domain.Contato;
import org.senac.bd.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/contato")
public class ContatoController {
	
	@Autowired
	private ContatoRepository repository;
	
	@PostMapping
	public Contato save(@RequestBody Contato contato) {
		return repository.save(contato);
	}
	
	@GetMapping
	public List<Contato> findAll() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Integer id) {
		Optional<Contato> result = repository.findById(id);
		if (result.isPresent()) {
			return ResponseEntity.ok(result.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		
		repository.deleteById(id);
	}
	
	@PostMapping("/imagem")
	public void update(@RequestParam("contato") String contato, MultipartFile file) {
	     System.out.println(file);
	     System.out.println(contato);
	     //System.out.println(contato.getImagem());
	     
	}

	
	
	
	
}
