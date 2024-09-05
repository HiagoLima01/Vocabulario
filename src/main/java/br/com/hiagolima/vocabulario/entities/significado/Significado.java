package br.com.hiagolima.vocabulario.entities.significado;


import br.com.hiagolima.vocabulario.entities.palavra.Palavra;
import br.com.hiagolima.vocabulario.entities.palavra.PalavraRequestDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "tb_significado")
@Entity(name = "significado")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Significado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
    @JoinColumn(name = "palavra_id")
    private Palavra palavra;
	
	private String descricao;
	
	public Significado(SignificadoRequestDTO data) {
		this.descricao = data.getDescricao();
	}
	
	public long getId() {
		return id;
	}
	public Palavra getPalavra() {
		return palavra;
	}
	public void setPalavra(Palavra palavra) {
		this.palavra = palavra;
	}
	public String getDescricao() {
		return descricao;
	}
	
	
	

}
