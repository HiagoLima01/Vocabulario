package br.com.hiagolima.vocabulario.entities.significado;

import br.com.hiagolima.vocabulario.entities.palavra.Palavra;

public record SignificadoResponseDTO(Long id, Palavra palavra, String significado) {
	
	public SignificadoResponseDTO(Significado significado) {
		this(significado.getId(), significado.getPalavra(), significado.getDescricao());
	}
}
