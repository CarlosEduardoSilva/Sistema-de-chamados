package br.com.cobcondo.main.chamados;
import java.util.List;	
import java.util.UUID;	
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.tagext.TryCatchFinally;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cobcondo.main.categoria.CategoriaEntity;
import br.com.cobcondo.main.chamados.ChamadosEntity;
import br.com.cobcondo.main.chamados.ChamadosRepository;
import br.com.cobcondo.main.pin.PinEntity;
import br.com.cobcondo.main.usuarios.UsuariosEntity;
import br.com.cobcondo.main.usuarios.UsuariosRepository;
import br.com.cobcondo.main.pin.PinRepository;
import br.com.cobcondo.main.subcategoria.SubCategoriaEntity;
import br.com.cobcondo.main.subcategoria.SubCategoriaRepository;
import br.com.cobcondo.main.categoria.CategoriaRepository;


@RestController
public class ChamadosService {
	
	
	private final Logger LOGGER = Logger.getLogger(getClass());
	
	@Autowired
	private ChamadosRepository ChamadosRepository;
	@Autowired
	private UsuariosRepository UsuariosRepository;
	@Autowired
	private PinRepository PinRepository;
	@Autowired
	private SubCategoriaRepository SubCategoriaRepository; 
	@Autowired
	private CategoriaRepository CategoriaRepository;
	
	//data:{usuNome:usuNome, empresa:empresa, cat:cat, subcat:subcat, titulo:titulo, descricao:descricao},
	@RequestMapping(value="/crchamados", method=RequestMethod.POST, 
			params={"cat", "subcat", "titulo","descricao"})	
	public String crchamados(@RequestParam("cat") Long cat, 
			@RequestParam("subcat") Long subcat, 
			@RequestParam("titulo") String titulo,			
			@RequestParam("descricao") String descricao,
			HttpSession session) {
		this.LOGGER.info("Incluindo chamado:");
		String ret = "OK";
		try {				
			
			UsuariosEntity usu = (UsuariosEntity) session.getAttribute("u");
			
			
					ChamadosEntity chamado = new ChamadosEntity(usu.getId(), usu.getEmpId(), cat, subcat, titulo, descricao);
					this.ChamadosRepository.saveAndFlush(chamado);
					
					ret = "/meuschamados"; 
					this.LOGGER.info("chamado cadastrado");
		} catch (Exception e) {
		e.printStackTrace();
		ret = "error";
		}
	
		return ret;
		
	}
	
	
	@RequestMapping(value="/ecsubcat", method=RequestMethod.POST,
			params= {"cat"})
	public String valor(@RequestParam("cat") Long catId, 
			HttpSession session) {
		this.LOGGER.info("Incluindo teste:");
		String ret = "";
		try {
			
			
			List<SubCategoriaEntity> subcat = this.SubCategoriaRepository.findByCatId(catId);
			ret  = "<select class='form-group' id='subcat'>";
			for (SubCategoriaEntity s : subcat) {
				ret+="<option value='"+s.getId()+"'>"+s.getSubCategoria()
				+"</option>";
			}
			
			ret +="</select>";
			
			
			
		} catch (Exception e) {
		e.printStackTrace();
		ret  = "<select class='form-group' id='subcat'>";
		ret +="</select>";
		}
	
		return ret;
		
	}
	@RequestMapping(value="/verificarchamado", method=RequestMethod.POST ,  params={"chaId"})
	public String paginaVerificarChamado (@RequestParam("chaId") Long chaId, HttpSession session) {
		this.LOGGER.info("Estamos aqui companheiro");
		try {
			ChamadosEntity chamado = this.ChamadosRepository.findOne(chaId);
			session.setAttribute("chamado", chamado);
			CategoriaEntity cat = this.CategoriaRepository.findOne(chamado.getCatId());
			session.setAttribute("cat", cat);
			SubCategoriaEntity subcat = this.SubCategoriaRepository.findOne(chamado.getSubId());
			session.setAttribute("subcat", subcat);
			this.LOGGER.info("Chamada da pagina verificar chamados");
			return "/verificarchamado";
		} catch (Exception e) {
			this.LOGGER.info("Chamada da pagina Login");
			return "/login";// TODO: handle exception
		}
	
	}
	
}
