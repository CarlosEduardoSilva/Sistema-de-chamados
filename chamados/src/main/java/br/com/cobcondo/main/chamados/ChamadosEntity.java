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
	
	
	public ChamadosEntity(Long usuId, Long empId, Long catId, Long subId, String chaTitulo, String chaDescricao) {
		super();
		this.usuId = usuId;
		this.empId = empId;
		this.catId = catId;
		this.subId = subId;
		this.chaTitulo = chaTitulo;
		this.chaDescricao = chaDescricao;
	}
	public ChamadosEntity() {
		
		super();		
	}

	
	private static final long serialVersionUID =1L;
	
	@Column(name="usu_id", nullable = false )
	private Long usuId;	
	@Column(name="emp_id", nullable = false )
	private Long empId;
	@Column(name="cat_id", nullable = false )
	private Long catId;
	@Column(name="sub_id", nullable = false )
	private Long subId;
	@Column(name="cha_titulo", length=45, nullable = false)
	private String chaTitulo;
	@Column(name="cha_descricao", length=200, nullable = false)
	private String chaDescricao;
	public Long getUsuId() {
		return usuId;
	}
	public void setUsuId(Long usuId) {
		this.usuId = usuId;
	}
	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	public Long getCatId() {
		return catId;
	}
	public void setCatId(Long catId) {
		this.catId = catId;
	}
	public Long getSubId() {
		return subId;
	}
	public void setSubId(Long subId) {
		this.subId = subId;
	}
	public String getChaTitulo() {
		return chaTitulo;
	}
	public void setChaTitulo(String chaTitulo) {
		this.chaTitulo = chaTitulo;
	}
	public String getChaDescricao() {
		return chaDescricao;
	}
	public void setChaDescricao(String chaDescricao) {
		this.chaDescricao = chaDescricao;
	}
	
	
	
	
}


