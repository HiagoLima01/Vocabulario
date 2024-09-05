package br.com.hiagolima.vocabulario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hiagolima.vocabulario.entities.significado.Significado;

public interface SignificadoRepository extends JpaRepository<Significado, Long> {

}
