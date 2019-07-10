package br.com.cobcondo.main.chamados;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.cobcondo.main.utils.BaseEntity;

@Entity
@Table(name="chamados")
@AttributeOverride(name="id", column=@Column(name="cha_id"))
public class ChamadosEntity extends BaseEntity<Long>{
	
	
	

	public ChamadosEntity(String usu_nome, Long emp_id, Long cat_id, Long sub_id, String cha_titulo,
			String cha_descricao) {
		super();
		this.usu_nome = usu_nome;
		this.emp_id = emp_id;
		this.cat_id = cat_id;
		this.sub_id = sub_id;
		this.cha_titulo = cha_titulo;
		this.cha_descricao = cha_descricao;
	}
	private static final long serialVersionUID =1L;
	
	@Column(name="usu_nome", nullable = false )
	private String usu_nome;	
	@Column(name="emp_id", nullable = false )
	private Long emp_id;
	@Column(name="cat_id", nullable = false )
	private Long cat_id;
	@Column(name="sub_id", nullable = false )
	private Long sub_id;
	@Column(name="cha_titulo", length=45, nullable = false)
	private String cha_titulo;
	@Column(name="cha_descricao", length=200, nullable = false)
	private String cha_descricao;
	
	public String getUsu_nome() {
		return usu_nome;
	}
	public void setUsu_nome(String usu_nome) {
		this.usu_nome = usu_nome;
	}
	public Long getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(Long emp_id) {
		this.emp_id = emp_id;
	}
	public Long getCat_id() {
		return cat_id;
	}
	public void setCat_id(Long cat_id) {
		this.cat_id = cat_id;
	}
	public Long getSub_id() {
		return sub_id;
	}
	public void setSub_id(Long sub_id) {
		this.sub_id = sub_id;
	}
	public String getCha_titulo() {
		return cha_titulo;
	}
	public void setCha_titulo(String cha_titulo) {
		this.cha_titulo = cha_titulo;
	}
	public String getCha_descricao() {
		return cha_descricao;
	}
	public void setCha_descricao(String cha_descricao) {
		this.cha_descricao = cha_descricao;
	}
	

	
	
}


