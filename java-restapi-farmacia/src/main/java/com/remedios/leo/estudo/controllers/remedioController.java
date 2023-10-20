package com.remedios.leo.estudo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.remedios.leo.estudo.remedio.DadosAtualizacaoRemedio;
import com.remedios.leo.estudo.remedio.DadosCadastroRemedio;
import com.remedios.leo.estudo.remedio.DadosDetalhamentoRemedio;
import com.remedios.leo.estudo.remedio.DadosListagemRemedios;
import com.remedios.leo.estudo.remedio.Remedio;
import com.remedios.leo.estudo.remedio.RemedioRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/remedios")
public class remedioController {

	@Autowired
	private RemedioRepository Repository;

	@PostMapping
	@Transactional // rollback dos dados caso, algum deles esteja invalido
	public ResponseEntity<DadosDetalhamentoRemedio> cadastrar(@RequestBody @Valid DadosCadastroRemedio dados,
			UriComponentsBuilder UriBuilder) {
		var remedio = new Remedio(dados);
		Repository.save(remedio);
		var uri = UriBuilder.path("/remedios/{id}").buildAndExpand(remedio.getId()).toUri();
		return ResponseEntity.created(uri).body(new DadosDetalhamentoRemedio(remedio));
	}

	@GetMapping
	public ResponseEntity<List<DadosListagemRemedios>> listarRemedios() {
		var lista = Repository.findAllByAtivoTrue().stream().map(DadosListagemRemedios::new).toList();
		return ResponseEntity.ok(lista);
	}

	@PutMapping
	@Transactional
	public ResponseEntity<DadosDetalhamentoRemedio> AtualizarRemedio(
			@RequestBody @Valid DadosAtualizacaoRemedio dados) {
		var remedio = Repository.getReferenceById(dados.id());
		remedio.atualizarInformacoes(dados);
		return ResponseEntity.ok(new DadosDetalhamentoRemedio(remedio));
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<Void> deletarRemedio(@PathVariable Long id) {
		Repository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DadosDetalhamentoRemedio>EncontrarPorId(@PathVariable Long id){
	var remedio = 	Repository.getReferenceById(id);
		return ResponseEntity.ok(new DadosDetalhamentoRemedio(remedio));
	}

	@DeleteMapping("/inativar/{id}")
	@Transactional
	public ResponseEntity<Void> deletarInativarRemedio(@PathVariable Long id) {
		var remedio = Repository.getReferenceById(id);
		remedio.inativar();
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/reativar/{id}")
	@Transactional
	public ResponseEntity<Void> ReativarRemedio(@PathVariable Long id) {
		var remedio = Repository.getReferenceById(id);
		remedio.reativar();
		return ResponseEntity.noContent().build();
	}
}
