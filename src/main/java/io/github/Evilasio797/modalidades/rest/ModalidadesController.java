package io.github.Evilasio797.modalidades.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.github.Evilasio797.modalidades.model.Modalidades;
import io.github.Evilasio797.modalidades.repository.ModalidadesRepository;

@RestController
@RequestMapping("/api/modalidades")//a url no postman
@CrossOrigin("http://localhost:4200")

public class ModalidadesController {
	
	@Autowired
	private ModalidadesRepository repository;//fazer as operações em bd
	
	@PostMapping
	public Modalidades save( @RequestBody Modalidades modalidades) {
		return repository.save(modalidades);
	}
	
	@GetMapping
	public List<Modalidades> getAll(){//para gravar e listar os adicionados
		return repository.findAll();
	}
	//url/api/modalidades/1 - retorna a modalidades cujo id eh 1
	
	@GetMapping("{id}")
	public Modalidades getById(@PathVariable Long id)
	{
		return repository
				.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));//ERRO 404 NOT FOUND
	}
	
	/*
	 * @DeleteMapping("{id}")
	 * public void delete (@PathVariable Long id) {
	 * 	repository.deleteById(id);
	 * }
	 * */
}
