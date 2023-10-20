package com.remedios.leo.estudo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.remedios.leo.estudo.infra.ServicoToken;
import com.remedios.leo.estudo.usuarios.DadosAutenticacao;
import com.remedios.leo.estudo.usuarios.Usuario;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

	@Autowired
	private AuthenticationManager manager;  //Esta classe é utilizada para autenticar usuarios por baixo dos panos, chamando o metodo loadUserByUsername que está na classe service
	
	@Autowired
	private ServicoToken servicoToken;
	
	@PostMapping
	public ResponseEntity<?> efetuarLogin(@RequestBody @Valid DadosAutenticacao dados){
		var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
		var autenticacao = manager.authenticate(token);
		
		return ResponseEntity.ok(servicoToken.gerarToken((Usuario)autenticacao.getPrincipal()));
	}
}
