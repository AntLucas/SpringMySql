package org.generation.blogPessoal.controller;

import org.generation.blogPessoal.repository.PostagemRepository; //importando a interface
import org.generation.blogPessoal.model.Postagem; //importando a model

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //indica que a classe é um controlador, um controller - se comunica com o cliente
@RequestMapping("/postagens") //indica por on de a classe vai ser acessada
@CrossOrigin("*")//indica que a api aceita requisições de qualquer origem
public class PostagemController {

	//injetando a classe de repositório dentro do controller
	@Autowired // garante que todos os serviços da interface PostagemRepository seja acessado a partir do controller
	private PostagemRepository repository;
	
	//metodo GetAll, recebe uma lista do tipo Postagem
	@GetMapping //Sempre que houver uma requisição externa com o método GET através da url "/postagens" o metodo GetAll será executado
	public ResponseEntity<List<Postagem>> GetAll(){
	return ResponseEntity.ok(repository.findAll()); //retornar ok, com a requisição de todas as postagens
	}
	
	@GetMapping("/{id}") //metodo para retornar valores através do id, o método recebe um parâmetro long id
	//notação PathVariable para conseguir usar como parâmetro um valor vindo da url
	public ResponseEntity<Postagem> GetById(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
		//assim que for feita uma reposição do tipo get em "/postagens/" e for passado um valor no caso o "id"
		//esse método será executado que capturará a variável que está sendo passada e vai retornar
		//a interface que foi injetada e executará o método findById que pode retornar um método do tipo postagem com ok
		//quanto um notFound caso o objeto não exista ou tenha algum erro na requisição
	}
	
	@GetMapping("/titulo/{titulo}") //metodo para retornar valores através do titulo
	public ResponseEntity<List<Postagem>> GetByTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
		//metodo que sera executado quando acessarem a url "/titulo/" passando algum parâmetro
		//dentro do metodo é executado o metodo que fizemos dentro da interface repositorio findAllByTituloContainingIgnoreCase
	}
}
