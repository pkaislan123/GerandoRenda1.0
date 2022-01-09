package br.com.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.form.ProdutosForm;

@Entity
public class Produtos {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String descricao;
	private String inf_complementar;
	private String preco;
	private int codigo_destaque;
	private String link_padrao_vendas;
	private String link_desc_minimo;
	private String link_desc_medio;
	private String link_desc_maximo;
	private String link_brind;
	private String link_checkout;
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDate data_auteracao;
	
	public Produtos() {}

	public Produtos(ProdutosForm form) {
		this.descricao = form.getDescricao();
		this.inf_complementar = form.getInf_complementar();
		this.preco = form.getPreco();
		this.codigo_destaque = form.getCodigo_destaque();
		this.link_padrao_vendas = form.getLink_padrao_vendas();
		this.link_desc_minimo = form.getLink_desc_minimo();
		this.link_desc_medio = form.getLink_desc_medio();
		this.link_desc_maximo = form.getLink_desc_maximo();
		this.link_brind = form.getLink_brind();
		this.link_checkout = form.getLink_checkout();
	}

	public int getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getInf_complementar() {
		return inf_complementar;
	}

	public void setInf_complementar(String inf_complementar) {
		this.inf_complementar = inf_complementar;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public int getCodigo_destaque() {
		return codigo_destaque;
	}

	public void setCodigo_destaque(int codigo_destaque) {
		this.codigo_destaque = codigo_destaque;
	}

	public String getLink_padrao_vendas() {
		return link_padrao_vendas;
	}

	public void setLink_padrao_vendas(String link_padrao_vendas) {
		this.link_padrao_vendas = link_padrao_vendas;
	}

	public String getLink_desc_minimo() {
		return link_desc_minimo;
	}

	public void setLink_desc_minimo(String link_desc_minimo) {
		this.link_desc_minimo = link_desc_minimo;
	}

	public String getLink_desc_medio() {
		return link_desc_medio;
	}

	public void setLink_desc_medio(String link_desc_medio) {
		this.link_desc_medio = link_desc_medio;
	}

	public String getLink_desc_maximo() {
		return link_desc_maximo;
	}

	public void setLink_desc_maximo(String link_desc_maximo) {
		this.link_desc_maximo = link_desc_maximo;
	}

	public String getLink_brind() {
		return link_brind;
	}

	public void setLink_brind(String link_brind) {
		this.link_brind = link_brind;
	}

	public String getLink_checkout() {
		return link_checkout;
	}

	public void setLink_checkout(String link_checkout) {
		this.link_checkout = link_checkout;
	}

	public LocalDate getData_auteracao() {
		return data_auteracao;
	}

	public void setData_auteracao(LocalDate data_auteracao) {
		this.data_auteracao = data_auteracao;
	}
	
	
}

