package br.com.hiagolima.vocabulario.controllers.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hiagolima.vocabulario.entities.palavra.Palavra;
import br.com.hiagolima.vocabulario.entities.palavra.PalavraRequestDTO;
import br.com.hiagolima.vocabulario.entities.palavra.PalavraResponseDTO;
import br.com.hiagolima.vocabulario.entities.significado.SignificadoResponseDTO;
import br.com.hiagolima.vocabulario.repositories.SignificadoRepository;

@RestController
@RequestMapping("significados")
public class SignificadoRestController {
	
	@Autowired
	private SignificadoRepository repository;
	
	@GetMapping
	public List<SignificadoResponseDTO> findAll(){
		List<SignificadoResponseDTO> listaSignificado =  repository.findAll().stream().map(SignificadoResponseDTO::new).toList();;
		return listaSignificado; 					  
	}
	
	
}
