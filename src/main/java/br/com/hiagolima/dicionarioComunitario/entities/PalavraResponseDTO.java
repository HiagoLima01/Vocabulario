package br.com.hiagolima.dicionarioComunitario.entities;

import br.com.hiagolima.dicionarioComunitario.entities.Palavra;

/* Uma DTO (Data Transfer Object) é uma classe específica para transferir dados entre diferentes partes do sistema, 
 * como entre camadas de uma aplicação. Neste caso, usamos um record, que é uma classe imutável introduzida no Java 14,
 * que nos permite evitar a escrita manual de getters, setters, equals, hashCode, e toString, já que o Java gera esses métodos automaticamente.
 * 
 * As classes DTO geralmente são divididas em dois tipos: Request (para entrada de dados) e Response (para saída de dados).
 * 
 * O motivo de criarmos classes DTO é para não expormos as nossas classes Entities durante os usos de APIs, então as classes DTO
 * São formas seguras de transferencia de dados entre aplicação e serviços WEB
 * 
 * Neste exemplo temos uma DTO do tipo Response.
 */

public record PalavraResponseDTO(Long id, String palavra, String significado, String nome, String fontePalavra) {

	public PalavraResponseDTO(Palavra palavra) {
		this(palavra.getId(), palavra.getPalavra(), palavra.getSignificado(), palavra.getNome(), palavra.getFontePalavra());
	}
}
