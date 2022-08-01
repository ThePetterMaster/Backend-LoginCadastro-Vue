package com.example.cadastro.controllers;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.example.cadastro.modelo.Usuario;
import com.example.cadastro.repository.UsuarioRepository;
import com.example.cadastro.controllers.dto.UsuarioDto;

@CrossOrigin
@RestController
@RequestMapping("/cadastro")
public class CadastroController {
    @Autowired
	private UsuarioRepository cadastroRepository;
    
    @PostMapping
	@Transactional
	public ResponseEntity<UsuarioDto> cadastrar(@RequestBody Usuario form, UriComponentsBuilder uriBuilder) {

		cadastroRepository.save(form);

		//Responde no header o caminho do topico cadastrado com o id respectivo
		URI uri = uriBuilder.path("/cadastro/{id}").buildAndExpand(form.getId()).toUri();
		return ResponseEntity.created(uri).body(new UsuarioDto(form));
	}
	@GetMapping
	public List<Usuario> lista() {
		//Caso o query param não tenha sido passado
	
			List<Usuario> usuario = cadastroRepository.findAll();
			return usuario;

	}
}
