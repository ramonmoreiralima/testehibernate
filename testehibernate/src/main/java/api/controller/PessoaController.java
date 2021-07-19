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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import api.repository.PessoaRepository;
import api.model.Pessoa;
// @RestController
@Controller
@RequestMapping("/")
public class PessoaController {
	
	@Autowired
	private PessoaRepository repository;
	
	/*@RequestMapping(value = "/index", method = RequestMethod.GET)
	public void index(HttpServletResponse httpResponse) throws IOException{
		 httpResponse.sendRedirect("/");
	}
	// Rota para pagina de teste de status do servico web
	@GetMapping("/status")
	public String check(){
		return "Online";
	}*/
	/* ================================ API ================================ */
	// Api para buscar pessoa por Id
	/*@GetMapping("/api/{codigo}")
	public ResponseEntity consultar(@PathVariable("codigo") Integer codigo){
		return (ResponseEntity) repository.findById(codigo)
				.map(record->ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
	// Api para cadastrar pessoa
	// @RequestMapping(value="/api/pessoa/salvar", method=RequestMethod.POST)
	@PostMapping(path="/api/salvar")
	public Pessoa salvar(@RequestBody Pessoa pessoa){
		return repository.save(pessoa);
	}*/
	
	/* ================================ METHOD ================================ */
	// ListAll
	@RequestMapping("/pessoa/listar")
	public ModelAndView listarPessoas(){
		ModelAndView mv = new ModelAndView("/pessoa/listar");
		Iterable<Pessoa> pessoas = repository.findAll();
		mv.addObject("pessoas",pessoas);
		return mv;
	}
	
	@RequestMapping(value="/pessoa/cadastrar", method=RequestMethod.GET)
	public String form(){
		return "/pessoa/cadastrar";
	}
	
	/* Methodo para cadastrat pessoa*/
	@RequestMapping(value="/pessoa/cadastrar", method=RequestMethod.POST)
	public String form(Pessoa pessoa){
		repository.save(pessoa);
		return "redirect:/pessoa/cadastrar";
	}
	
	
}
