package api.controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import api.repository.PessoaRepository;
import api.model.Pessoa;

//@Controller
@RestController
@RequestMapping("/")
public class PessoaApi {
	
	@Autowired
	private PessoaRepository repository;
	
	
	// Api para buscar pessoa por Id
	@GetMapping("/pessoa/consultar/{codigo}")
	public ResponseEntity consultar(@PathVariable("codigo") Integer codigo){
		return (ResponseEntity) repository.findById(codigo)
				.map(record->ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping(path="/pessoa/listAll")
	public List<Pessoa> findAll(){
	   Iterable<Pessoa> pessoas = repository.findAll();
		return (List<Pessoa>) pessoas;
	}
	
	// Api para cadastrar pessoa
	// @RequestMapping(value="/api/pessoa/salvar", method=RequestMethod.POST)
	@PostMapping(path="/pessoa/salvar")
	public Pessoa salvar(@RequestBody Pessoa pessoa){
		return repository.save(pessoa);
	}
	
	// Update
	@PutMapping(value="/pessoa/update/{id}")
	public ResponseEntity update(@PathVariable("id") long id,
	                                      @RequestBody Pessoa pessoa) {
	   return repository.findById((int) id)
	           .map(record -> {
	               record.setNome(pessoa.getNome());
	               record.setEmail(pessoa.getEmail());
	               Pessoa updated = repository.save(record);
	               return ResponseEntity.ok().body(updated);
	           }).orElse(ResponseEntity.notFound().build());
	}
	
	// Delerte
	@DeleteMapping(path ={"/pessoa/delete/{id}"})
	public ResponseEntity <?> delete(@PathVariable long id) {
	   return repository.findById((int) id)
	           .map(record -> {
	               repository.deleteById((int) id);
	               return ResponseEntity.ok().build();
	           }).orElse(ResponseEntity.notFound().build());
	}

	
}
