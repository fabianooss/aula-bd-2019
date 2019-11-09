package org.senac.bd.controller;

import java.util.List;

import javax.validation.Valid;

import org.senac.bd.domain.Avaliacao;
import org.senac.bd.repository.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoController {
	
	@Autowired
	private AvaliacaoRepository repository;

	
	@PostMapping
	public Avaliacao salvar(@RequestBody @Valid Avaliacao avaliacao) {
		return repository.save(avaliacao);
	}
	
	@GetMapping
	public Page<Avaliacao> findAll() {
		PageRequest page = PageRequest.of(0, 20, Sort.by("data"));
		return repository.findAll(page);
	}
}
