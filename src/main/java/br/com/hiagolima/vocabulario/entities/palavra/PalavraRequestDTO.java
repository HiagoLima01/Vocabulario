package br.com.hiagolima.vocabulario.entities.palavra;

import java.util.List;

import br.com.hiagolima.vocabulario.entities.significado.Significado;
import br.com.hiagolima.vocabulario.entities.significado.SignificadoRequestDTO;

/*
 * Uma DTO (Data Transfer Object) é uma classe específica para transferir dados entre diferentes partes do sistema, 
 * como entre camadas de uma aplicação. Neste caso, usamos um record, que é uma classe imutável introduzida no Java 14,
 * que nos permite evitar a escrita manual de getters, setters, equals, hashCode, e toString, já que o Java gera esses métodos automaticamente.
 * 
 * As classes DTO geralmente são divididas em dois tipos: Request (para entrada de dados) e Response (para saída de dados).
 * 
 * O motivo de criarmos classes DTO é para não expormos as nossas classes Entities durante os usos de APIs, então as classes DTO
 * São formas seguras de transferencia de dados entre aplicação e serviços WEB
 * 
 * Neste exemplo temos uma DTO do tipo Request.
 */

public class PalavraRequestDTO {
	
    private String palavra;

    private String fontePalavra;
    
	public String getPalavra() {
		return palavra;
	}

	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}
	
	public String getFontePalavra() {
		return fontePalavra;
	}
	public void setFontePalavra(String fontePalavra) {
		this.fontePalavra = fontePalavra;
	}
	
	public String toString(){
		return "palavra: " + palavra + " Fonte Palavra: " + fontePalavra;
	}

}
