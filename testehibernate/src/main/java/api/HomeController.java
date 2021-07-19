package api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // para Spring encontrar a classe
//@RequestMapping("/")
public class HomeController {
	@GetMapping("/") // fazendo o spring buscar este metodo
    public String principal01() {
        return "index";
	} 
	@GetMapping("/index") // fazendo o spring buscar este metodo
	    public String index() {
	        return "index";
	 }
	@GetMapping("/home") // fazendo o spring buscar este metodo
    public String home() {
        return "index";
	}
	@GetMapping("/status") // fazendo o spring buscar este metodo
    public String status() {
        return "Online.";
	}
	/*@RequestMapping(value="cadastrar", method=RequestMethod.GET)
	public void form(HttpServletResponse httpResponse) throws IOException{
		//return "pessoa/cadastar";
		 httpResponse.sendRedirect("cadastrar.html");
		
	}*/
}
