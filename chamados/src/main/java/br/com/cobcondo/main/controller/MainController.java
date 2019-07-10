package br.com.cobcondo.main.controller;
import java.util.List;	
import java.util.UUID;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.cobcondo.main.perguntas.PerguntasRepository;
import br.com.cobcondo.main.pin.PinRepository;
import br.com.cobcondo.main.usuarios.UsuariosEntity;
import br.com.cobcondo.main.categoria.CategoriaEntity;
import br.com.cobcondo.main.perguntas.PerguntasEntity;

@Controller
public class MainController {

	private final Logger LOGGER = Logger.getLogger(getClass());

	@Autowired
	private PerguntasRepository PerguntasRepository;
	@Autowired
	private br.com.cobcondo.main.categoria.CategoriaRepository CategoriaRepository;
	
	@RequestMapping("/login")
	public String paginaLogin (HttpSession session) {
		session.invalidate();
		this.LOGGER.info("Chamada da pagina Login");
		return "login/login";
	}
	
	@RequestMapping("/registrar")
	public String paginaRegistrar (HttpSession session) {
		//session.invalidate();
		List<PerguntasEntity> perg = this.PerguntasRepository.findAll();
		session.setAttribute("perg", perg);		
		this.LOGGER.info("Chamada da pagina Registrar");
		return "registrar/registrar";
	}
	
	@RequestMapping("/dashboard")
	public String paginaDashboard (HttpSession session) {
		UUID uid =(UUID) session.getAttribute("uid");
		if(uid != null) {
			this.LOGGER.info("Chamada da pagina dashboard");
			return "dashboard/dashboard";
		}else {
			this.LOGGER.info("Chamada da pagina Login");
			return "login/login";
		}
	}
	
	@RequestMapping("/chamados")
	public String paginaChamados (HttpSession session) {
		UUID uid =(UUID) session.getAttribute("uid");
		if(uid != null) {
			List<CategoriaEntity> categ = this.CategoriaRepository.findAll();
			session.setAttribute("categ", categ);
			
			this.LOGGER.info("Chamada da pagina chamados");
			return "chamados/chamados";
		}else {
			this.LOGGER.info("Chamada da pagina Login");
			return "login/login";
		}
	}
	
	
}
