package br.com.hiagolima.vocabulario.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.hiagolima.vocabulario.entities.palavra.Palavra;
import br.com.hiagolima.vocabulario.entities.palavra.PalavraRequestDTO;
import br.com.hiagolima.vocabulario.entities.significado.Significado;
import br.com.hiagolima.vocabulario.entities.significado.SignificadoRequestDTO;
import br.com.hiagolima.vocabulario.repositories.PalavraRepository;
import br.com.hiagolima.vocabulario.repositories.SignificadoRepository;

/*
 * Esta classe é um Controller, responsável por gerenciar as requisições HTTP e direcioná-las para os serviços apropriados. 
 * Ela faz a ponte entre o HTML e a lógica de negócios, facilitando a comunicação entre a aplicação e o banco de dados.
 * Nesta classe, implementamos métodos para lidar com operações HTTP, como POST (para criar novos recursos) e GET (para recuperar recursos existentes),
 * permitindo que a aplicação receba dados de um formulário HTML e envie dados para uma página HTML.
 * 
 * Além disso, o Controller segue o princípio da separação de responsabilidades, delegando a lógica de negócios para serviços e acessando dados através de repositórios.
 */


@Controller
public class SalvarPalavraController {
	
	//Repositorios para a interação entre aplicação e banco de dados
	@Autowired
	private PalavraRepository repositoryPalavra;
	@Autowired
	private SignificadoRepository repositorySignificado;
	
	//Salvar objeto palavra para utilizar o ID ao salvar significado
	private Palavra palavraSalvar;
	
	//@PostMapping("/registerPalavra") define o endpoint que mapeia as requisições HTTP POST para o método "registrarPalavra". 
	//Esse endpoint será acionado quando uma requisição POST for enviada para a URL "/registerPalavra".
	@PostMapping("/registerPalavra")
	public String registrarPalavra(@ModelAttribute PalavraRequestDTO palavraDto) {
		/**
		 * Este método é responsável por registrar uma nova palavra no banco de dados.
		 * Ele recebe os dados de uma palavra através de um formulário HTML, mapeados para um DTO, 
		 * converte esses dados para uma objeto entidade Palavra e a persiste utilizando o repositório.
		 * Após o salvamento da palavra, o usuário é redirecionado para a página de registro de significados
		 * para poder registrar o significado da palavra salva.
		 * 
		 * @param palavraDto Data Transfer Object (DTO) que contém os atributos para armazenar as informações
		 * 					 da palavra enviada pelo formulário HTML.
		 * 
		 * @return Página "significado", para onde o usuário será redirecionado e poderá registrar significados 
		 *         para a palavra recém-criada.
		 */
		palavraSalvar = new Palavra(palavraDto);			
		repositoryPalavra.save(palavraSalvar);
		return "significado";
	}
	
	@PostMapping("/registerSignificado")
	public String registrarSignificado(@ModelAttribute SignificadoRequestDTO significadoDto) {
		/**
		 * Este método é responsável por registrar um novo significado no banco de dados.
		 * Ele recebe os dados de uma palavra através de um formulário HTML, mapeados para um DTO, 
		 * converte esses dados para uma objeto entidade Significado e a persiste utilizando o repositório.
		 * Após o salvamento do significado, o usuário é redirecionado para a página de registro de significados
		 * para poder registrar o significado da palavra salva.
		 * 
		 * @param significadoDto Data Transfer Object (DTO) que contém os atributos para armazenar as informações
		 * 					 da palavra enviada pelo formulário HTML.
		 * 
		 * @return Página "index", para onde o usuário será redirecionado e poderá registrar novas palavras.
		 */
		Significado significadoData = new Significado(significadoDto);
		significadoData.setPalavra(palavraSalvar);
		repositorySignificado.save(significadoData);
		
		return "index";
	}
}
