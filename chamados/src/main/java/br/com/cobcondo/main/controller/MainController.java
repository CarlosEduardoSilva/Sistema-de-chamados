package br.com.cobcondo.main.controller;
import java.util.List;			
import java.util.UUID;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.cobcondo.main.perguntas.PerguntasRepository;
import br.com.cobcondo.main.pin.PinEntity;
import br.com.cobcondo.main.pin.PinRepository;
import br.com.cobcondo.main.subcategoria.SubCategoriaEntity;
import br.com.cobcondo.main.usuarios.UsuariosEntity;
import br.com.cobcondo.main.categoria.CategoriaEntity;
import br.com.cobcondo.main.perguntas.PerguntasEntity;
import br.com.cobcondo.main.subcategoria.SubCategoriaRepository;
import br.com.cobcondo.main.categoria.CategoriaRepository;
import br.com.cobcondo.main.chamados.ChamadosEntity;
import br.com.cobcondo.main.chamados.ChamadosRepository;

@Controller
public class MainController {

	private final Logger LOGGER = Logger.getLogger(getClass());

	@Autowired
	private PerguntasRepository PerguntasRepository;
	@Autowired
	private CategoriaRepository CategoriaRepository;
	@Autowired
	private SubCategoriaRepository SubCategoriaRepository; 
	@Autowired
	private PinRepository PinRepository;
	@Autowired
	private ChamadosRepository ChamadosRepository;
	
	
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
			List<SubCategoriaEntity> subcateg = this.SubCategoriaRepository.findAll();
			session.setAttribute("subcateg", subcateg);
			this.LOGGER.info("Chamada da pagina chamados");
			return "chamados/chamados";
		}else {
			this.LOGGER.info("Chamada da pagina Login");
			return "login/login";
		}
	}
	
	@RequestMapping("/verificarchamado")
	public String paginaVerificarChamado(HttpSession session) {		
		UUID uid =(UUID) session.getAttribute("uid");
		if(uid != null) {
			this.LOGGER.info("Chamada da pagina de chamados");
			return "chamados/verificarchamado";
		}else {
			this.LOGGER.info("Chamada da pagina Login");
			return "login/login";
		}
		
	}
	
	@RequestMapping("/meuschamados")
	public String paginaMeusChamados (HttpSession session) {
		UUID uid =(UUID) session.getAttribute("uid");
		if(uid != null) {
			UsuariosEntity usu =(UsuariosEntity) session.getAttribute("u");
			ChamadosEntity cha = (ChamadosEntity) session.getAttribute("c");
			PinEntity pin = this.PinRepository.findByUsuId(usu.getId());
			if(pin.getPinPerm().equals("adm")) {
				List<CategoriaEntity> categ = this.CategoriaRepository.findAll();
				session.setAttribute("categ", categ);
				List<SubCategoriaEntity> subcateg = this.SubCategoriaRepository.findAll();
				session.setAttribute("subcateg", subcateg);
				//List<ChamadosEntity> chamados = this.ChamadosRepository.findByUsuId(cha.getUsu_id());
				List<ChamadosEntity> chamados = this.ChamadosRepository.findAll();			
				session.setAttribute("chamados", chamados);
				this.LOGGER.info("Chamada da pagina Meus chamados adm");
				return "chamados/meuschamadosadm";
			}else {
				List<CategoriaEntity> categ = this.CategoriaRepository.findAll();
				session.setAttribute("categ", categ);
				List<SubCategoriaEntity> subcateg = this.SubCategoriaRepository.findAll();
				session.setAttribute("subcateg", subcateg);				
				List<ChamadosEntity> chamados = this.ChamadosRepository.findByUsuId(usu.getId());			
				session.setAttribute("chamados", chamados);
				
				this.LOGGER.info("Chamada da pagina Meus chamados");
				return "chamados/meuschamados";
				
			}
				
			
		}else {
			this.LOGGER.info("Chamada da pagina Login");
			return "login/login";
		}
	}
	
	
	
}
