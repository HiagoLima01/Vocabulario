package br.com.hiagolima.vocabulario.controllers.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hiagolima.vocabulario.entities.palavra.Palavra;
import br.com.hiagolima.vocabulario.entities.palavra.PalavraRequestDTO;
import br.com.hiagolima.vocabulario.entities.palavra.PalavraResponseDTO;
import br.com.hiagolima.vocabulario.entities.significado.Significado;
import br.com.hiagolima.vocabulario.repositories.PalavraRepository;

/* Esta classe é um RestController, responsável por gerenciar as requisições HTTP e direcioná-las para os serviços apropriados. 
 * Ela faz a ponte entre a REST API e a lógica de negócios, facilitando a comunicação entre a aplicação e o banco de dados.
 * Nesta classe, implementamos métodos para lidar com operações HTTP, como POST (para criar novos recursos) e GET (para recuperar recursos existentes),
 * permitindo que a aplicação manipule dados de forma segura e eficiente.
 */

@RestController
@RequestMapping("palavras")
public class PalavraRestController {

	
	@Autowired
	private PalavraRepository repository;
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/registerPalavra")
	public void savePalavra(@RequestBody PalavraRequestDTO data) {
		Palavra palavraData = new Palavra(data);
		repository.save(palavraData);
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping
	public List<PalavraResponseDTO> findAll(){
		List<PalavraResponseDTO> listaPalavras =  repository.findAll().stream().map(PalavraResponseDTO::new).toList();;
		return listaPalavras; 					  
	}
	
	
	
}
