package br.com.hiagolima.vocabulario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import br.com.hiagolima.vocabulario.entities.palavra.Palavra;

/* 
 * Esta é a interface JpaRepository, que fornece uma coleção de métodos prontos para facilitar as interações entre a aplicação e o banco de dados.
 * Ela é parte do Spring Data JPA e nos oferece operações de CRUD (Create, Read, Update, Delete) e outras consultas comuns sem a necessidade de escrever SQL ou implementar manualmente essas operações.
 * Além disso, podemos personalizar essa interface para escrever métodos como bem desejamos.
 */

public interface PalavraRepository extends JpaRepository<Palavra, Long> {

}


