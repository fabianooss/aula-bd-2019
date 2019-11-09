package org.senac.bd.controller;

import java.io.IOException;
import java.util.Optional;

import org.senac.bd.domain.Foto;
import org.senac.bd.repository.FotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/foto")
public class FotoController {
	
	@Autowired
	private FotoRepository repository;
	
	@PostMapping
	public ResponseEntity<?> salvar(
			@RequestPart(name = "foto") Foto foto, 
			@RequestPart(name = "file") MultipartFile file) {
		
		foto.setNome(file.getName());
		foto.setTipo(file.getContentType());
		try {
			foto.setFoto(file.getBytes());
			foto = repository.save(foto);
			return ResponseEntity.ok(foto.getId());
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity(e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<?> getFoto(@PathVariable("id") Integer id) {
		Optional<Foto> foto = repository.findById(id);
		if (foto.isPresent()) {
			return ResponseEntity.ok()
				.contentType(MediaType.IMAGE_JPEG)
					.header(HttpHeaders.CONTENT_DISPOSITION, 
							"attachment: filename=" + foto.get().getNome()) 
					.body(new ByteArrayResource(foto.get().getFoto()));
					
		}
		return ResponseEntity.notFound().build();
	}
	
	
	

}
