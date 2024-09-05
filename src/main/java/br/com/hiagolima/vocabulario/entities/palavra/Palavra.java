package br.com.hiagolima.vocabulario.entities.palavra;

import java.util.ArrayList;
import java.util.List;

import br.com.hiagolima.vocabulario.entities.significado.Significado;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


/* Esta classe é uma Entity, usada para representar uma tabela no banco de dados. 
 * Cada instância dessa classe corresponde a uma linha na tabela. 
 * Através da Entity, podemos realizar operações de persistência (como salvar, atualizar, deletar, e consultar dados) 
 * de forma automática e orientada a objetos, utilizando frameworks como JPA/Hibernate.
 * 
 * Nesta Entity, utilizei anotações do Lombok para reduzir o código repetitivo, como a geração automática de 
 * getters, setters, construtores, facilitando a construção e manutenção da classe.
 */

@Table(name = "tb_palavra")
@Entity(name = "palavra")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Palavra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String palavra;
	private String fontePalavra;
	
	@OneToMany(mappedBy = "palavra", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Significado> significados;
	
//	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JoinTable(name = "tb_palavra_significado",
//	joinColumns = {
//		@JoinColumn(name = "palavra_id", referencedColumnName = "id")	
//	})
//	private List<Significado> significados;
	
	public Palavra() {}
	
	public Palavra(PalavraRequestDTO data) {
		this.palavra = data.getPalavra();
		this.fontePalavra = data.getFontePalavra();
	}
	
	
	public String getPalavra() {
		return palavra;
	}
	public String getFontePalavra() {
		return fontePalavra;
	}
	
	public long getId() {
		return id;
	}
	
	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}
	
	@Override
	public String toString(){
		return " id: " + id + "palavra: " + palavra + "Fonte Palavra: " + fontePalavra;
	}
}
