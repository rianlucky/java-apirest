package com.remedios.leo.estudo.infra;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.remedios.leo.estudo.usuarios.Usuario;

@Service
public class ServicoToken {

	public String gerarToken(Usuario usuario) {   //jwt
		try {
			var algoritmo = Algorithm.HMAC256("123456");
			return JWT.create().withIssuer("Remedios_api").withSubject(usuario.getLogin()).withExpiresAt(dataExpiracao()).sign(algoritmo);
		} catch (JWTCreationException exception) {
			throw new RuntimeException("Erro ao gerar token", exception);
		}
	}

	public String getSubject(String tokenJWT) {
		try {
			var algoritmo = Algorithm.HMAC256("123456");
		    return JWT.require(algoritmo)
		        .withIssuer("Remedios_api")
		        .build().verify(tokenJWT).getSubject();
		        
		} catch (JWTVerificationException exception){
			throw new RuntimeException("Token invalido ou expirado!");
		}
	}
	
	private Instant dataExpiracao() {
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
	}
}
