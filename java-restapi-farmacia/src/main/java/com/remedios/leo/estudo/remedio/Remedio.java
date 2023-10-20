package com.remedios.leo.estudo.remedio;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;

@Table(name = "Remedio")
@Entity(name = "remedios")
public class Remedio {
	public Remedio() {
	}

	public Remedio(DadosCadastroRemedio dados) {
		this.ativo = true;
		this.nome = dados.nome();
		this.via = dados.via();
		this.lote = dados.lote();
		this.quantidade = dados.quantidade();
		this.validade = dados.validade();
		this.laboratorio = dados.laboratorio();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	@Enumerated(EnumType.STRING)
	private Via via;
	private String lote;
	private int quantidade;
	private LocalDate validade;
	@Enumerated(EnumType.STRING)
	private Laboratorio laboratorio;
	private boolean ativo;

	

	public Remedio(Long id, String nome, Via via, String lote, int quantidade, LocalDate validade,
			Laboratorio laboratorio, boolean ativo) {
		super();
		this.id = id;
		this.nome = nome;
		this.via = via;
		this.lote = lote;
		this.quantidade = quantidade;
		this.validade = validade;
		this.laboratorio = laboratorio;
		this.ativo = ativo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Via getVia() {
		return via;
	}

	public void setVia(Via via) {
		this.via = via;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public LocalDate getValidade() {
		return validade;
	}

	public void setValidade(LocalDate validade) {
		this.validade = validade;
	}

	public Laboratorio getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(Laboratorio laboratorio) {
		this.laboratorio = laboratorio;
	}

	public void atualizarInformacoes(@Valid DadosAtualizacaoRemedio dados) {
		if (dados.nome() != null) {
			this.nome = dados.nome();
		}
		if (dados.via() != null) {
			this.via = dados.via();
		}
		if (dados.laboratorio() != null) {
			this.laboratorio = dados.laboratorio();
		}

	}

	public boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public void inativar() {
		this.ativo = false;
	}

	public void reativar() {
		this.ativo = true;

	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Remedio other = (Remedio) obj;
		return Objects.equals(id, other.id);
	}

}
