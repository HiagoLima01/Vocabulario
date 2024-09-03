package br.com.hiagolima.dicionarioComunitario.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Entity(name = "palabra")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Palavra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String palavra;
	private String significado;
	private String nome;
	private String fontePalavra;
	
	public Palavra() {}
	
	public Palavra(PalavraRequestDTO data) {
		this.palavra = data.palavra();
		this.significado = data.significado();
		this.nome = data.nome();
		this.fontePalavra = data.fontePalavra();
	}
	
	
	public String getPalavra() {
		return palavra;
	}
	public String getSignificado() {
		return significado;
	}
	public String getNome() {
		return nome;
	}
	public String getFontePalavra() {
		return fontePalavra;
	}
	
	public long getId() {
		return id;
	}
}
