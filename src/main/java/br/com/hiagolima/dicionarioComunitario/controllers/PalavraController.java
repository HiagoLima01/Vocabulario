package br.com.hiagolima.dicionarioComunitario.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hiagolima.dicionarioComunitario.entities.Palavra;
import br.com.hiagolima.dicionarioComunitario.entities.PalavraRequestDTO;
import br.com.hiagolima.dicionarioComunitario.entities.PalavraResponseDTO;
import br.com.hiagolima.dicionarioComunitario.repositories.PalavraRepository;

/* Esta classe é um Controller, responsável por gerenciar as requisições HTTP e direcioná-las para os serviços apropriados. 
 * Ela faz a ponte entre a REST API e a lógica de negócios, facilitando a comunicação entre a aplicação e o banco de dados.
 * Nesta classe, implementamos métodos para lidar com operações HTTP, como POST (para criar novos recursos) e GET (para recuperar recursos existentes),
 * permitindo que a aplicação manipule dados de forma segura e eficiente.
 */

@RestController
@RequestMapping("palavras")
public class PalavraController {

	@Autowired
	private PalavraRepository repository;
	
	@PostMapping
	public void savePalavra(@RequestBody PalavraRequestDTO data) {
		Palavra palavraData = new Palavra(data);
		repository.save(palavraData);
	}
	
	@GetMapping
	public List<PalavraResponseDTO> findAll(){
		List<PalavraResponseDTO> listaPalavras =  repository.findAll().stream().map(PalavraResponseDTO::new).toList();;
		return listaPalavras; 					  
	}
	
}
