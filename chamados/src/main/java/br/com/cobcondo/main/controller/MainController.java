package br.com.cobcondo.main.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	private final Logger LOGGER = Logger.getLogger(getClass());
	
	
	@RequestMapping("/login")
	public String paginaLogin (HttpSession session) {
		
		session.invalidate();
		this.LOGGER.info("Chamada da pagina Login");
		return "login/login";
	}
	
}
