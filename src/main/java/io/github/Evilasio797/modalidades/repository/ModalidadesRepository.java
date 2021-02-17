package io.github.Evilasio797.modalidades.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.Evilasio797.modalidades.model.Modalidades;

public interface ModalidadesRepository extends JpaRepository<Modalidades, Long>{ /*como tem na classe Modalid.*/
	//essa interface eh um repositorio da aplicacao
}