package com.remedios.leo.estudo.remedio;

import java.time.LocalDate;
//dto get
public record DadosListagemRemedios(Long id, String nome, Via via, String lote, Laboratorio laboratorio, LocalDate validade) {

	public DadosListagemRemedios(Remedio remedio) {
		this(remedio.getId(),remedio.getNome(),remedio.getVia(), remedio.getLote(), remedio.getLaboratorio(), remedio.getValidade());
		
	}
	
}
