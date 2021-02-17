package io.github.Evilasio797.modalidades.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import org.springframework.boot.SpringApplication;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.github.Evilasio797.modalidades.ModalidadesApplication;
import lombok.Getter;
import lombok.Setter;

@Entity //representa uma entidade, tabela do Banco de Dados
//logo, serve como uma tabela comum

@Getter
@Setter

public class Modalidades {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)// O banco que gerencia o ID
	private Long id;//chave primaria
	
	@Column
	//private String description;
	private String cliente;
	
	@Column
	private Boolean done;//se a tarefa foi feita ou nao
	
	@Column
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime createdDate;//quando foi criada
	
	@Column
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime doneDate; //quando foi feita

	@PrePersist
	private void beforeSave() {
		setCreatedDate(LocalDateTime.now());//antes de salvar, vai setar a data
	}
	
	
	
	/*
	 * No teste
	 * @Column
		private String nome;
		@Column
		@JsonFormat(pattern = "xxx.xxx.xxx-xx")
		private String cpf;
		@Column
		private Int idade;
		@Column
		private String ufc;
		@Column
		private Int salario;
	
	
	
	 * 
	 * */

}
