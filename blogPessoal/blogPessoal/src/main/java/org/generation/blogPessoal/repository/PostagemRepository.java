package org.generation.blogPessoal.repository;

import java.util.List;

import org.generation.blogPessoal.model.Postagem; // import do model Postagem
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Interface de repository - comunicação com o banco de dados

@Repository //indica para o Spring que essa classe é um repositório
//é passado o tipo de entidade que estamos trabalhado, "Postagem" é o nome do model que fizemos, "Long" é o tipo do Id no tipo primitivo
public interface PostagemRepository extends JpaRepository<Postagem, Long>{ 
	
	//consulta pelo titulo da postagem, "Titulo" é o nome do atributo da entidade, containing é semelhante ao like no MySql, IgnoreCase vai ignorar se as letras são maiúsculas ou minúsculas
	public List<Postagem> findAllByTituloContainingIgnoreCase (String titulo);
}
