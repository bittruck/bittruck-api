package br.com.indepdevbr.sec;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.com.indepdevbr.models.Transportadora;
import br.com.indepdevbr.models.Usuario;
import br.com.indepdevbr.models.exception.BittruckException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;

@Component
public class GerenciadorTokenJWT {
	
	@Value("${br.com.indepdevbr.bittruck.app.jwtSecret}")
	private String chaveSecretaJWT;
	
	@Value("${br.com.indepdevbr.bittruck.app.duracaoTokenAutenticacao}")
	private long duracaoTokenAutenticacao;
	
	@Value("${br.com.indepdevbr.bittruck.app.duracaoTokenAtivacaoTransportadora}")
	private long duracaoTokenAtivacaoTransportadora;
	
	private static final String ROLE = "role";
	
	public String gerarTokenAutenticacao(Usuario usuario) {
		Date datAtual = new Date();
		Date datExpiracaoToken = new Date(datAtual.getTime() + duracaoTokenAutenticacao);
		return Jwts.builder()
				.setSubject(usuario.getCodLogin())
				.setIssuedAt(datAtual)
				.setExpiration(datExpiracaoToken)
				.claim(ROLE, usuario.getTpoPermissao())
				.signWith(SignatureAlgorithm.HS256, chaveSecretaJWT)
				.compact();
	}
	
	public String gerarTokenAtivacaoTransportadora(Transportadora transportadora) {
		Date datAtual = new Date();
		Date datExpiracaoToken = new Date(datAtual.getTime() + duracaoTokenAtivacaoTransportadora);
		final String TRANSPORTADORA_ID = "transportadora_id";
		return Jwts.builder()
				.setSubject(transportadora.getCodCnpj())
				.setIssuedAt(datAtual)
				.setExpiration(datExpiracaoToken)
				.claim(TRANSPORTADORA_ID, transportadora.getId())
				.signWith(SignatureAlgorithm.HS256, chaveSecretaJWT)
				.compact();
	}
	
	public String capturarCodLoginTokenJWTAutenticacao(String tokenJWT) {
		return Jwts.parser()
				.setSigningKey(chaveSecretaJWT)
				.parseClaimsJws(tokenJWT)
				.getBody()
				.getSubject();
	}
	
	public boolean validarTokenJWT(String tokenJWT) {
		try {
			Jwts.parser()
			.setSigningKey(chaveSecretaJWT)
			.parseClaimsJws(tokenJWT);
			return Boolean.TRUE;
		} catch (SignatureException e) {
			throw new BittruckException("Assinatura do token é inválida");
		} catch (MalformedJwtException e) {
			throw new BittruckException("O token está corrompido");
		} catch (ExpiredJwtException e) {
			throw new BittruckException("Token expirado");
		} catch (IllegalArgumentException e) {
			throw new BittruckException("Parâmetros do token invalidos");
		}
	}

}
