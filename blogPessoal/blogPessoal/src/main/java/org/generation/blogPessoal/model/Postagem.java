package org.generation.blogPessoal.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


//model para postagem

@Entity //indica que a classe é uma entidade
@Table(name = "postagem") //indica que essa entidade vai virar uma tabela dentro do banco de dados ocm o nome de postagem
public class Postagem {
	
	@Id //define que esse atributo se trata de um id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //define como esse atributo id vai se comportar dentro do banco de dados, será uma primary key
	private long id;
	
	@NotNull //não aceitará valores vazios
	@Size(min = 5, max = 100) //define o tamanho minimo e maximo da quantidade de caracter para o atributo
	private String titulo;
	
	@NotNull //não aceitará valores vazios
	@Size(min = 10, max = 500) //define o tamanho minimo e maximo da quantidade de caracter para o atributo
	private String texto;
	
	
	@Temporal(TemporalType.TIMESTAMP) //indica que estamos trabalhando com tempo e o tipo de tempo
	//pega a data do sistema
	private Date date = new java.sql.Date(System.currentTimeMillis());

	public long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getTexto() {
		return texto;
	}

	public Date getDate() {
		return date;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	

}
