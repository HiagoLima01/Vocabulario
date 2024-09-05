package br.com.hiagolima.vocabulario.entities.significado;

public class SignificadoRequestDTO {

	private Long id_palavra;
	private String descricao;
	
	public Long getId_palavra() {
		return id_palavra;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setId_palavra(Long id_palavra) {
		this.id_palavra = id_palavra;
	}

	public void setSignificado(String significado) {
		this.descricao = significado;
	}

	public String toString(){
		return " id: " + id_palavra + "Descricao: " + descricao;
	}

}
