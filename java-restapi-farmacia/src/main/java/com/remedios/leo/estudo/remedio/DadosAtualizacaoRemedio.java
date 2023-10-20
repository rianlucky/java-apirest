package com.remedios.leo.estudo.remedio;

import jakarta.validation.constraints.NotNull;

//dto put
public record DadosAtualizacaoRemedio(@NotNull Long id, String nome, Via via, Laboratorio laboratorio) {

}
