package br.com.mvc.springmvc.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nomeProduto;
	private Double valorNegociado;
	private LocalDate dataDeEntrega;
	private String urlDoProdoto;
	private String urlDaImagem;
	private String descricao;
	
	@Enumerated(EnumType.STRING)
	private StatusPedido status;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private User user;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Oferta> ofertas;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomePrdouto) {
		this.nomeProduto = nomePrdouto;
	}
	public StatusPedido getStatus() {
		return status;
	}
	public void setStatus(StatusPedido status) {
		this.status = status;
	}
	public Double getValorNegociado() {
		return valorNegociado;
	}
	public void setValorNegociado(Double valorNegociado) {
		this.valorNegociado = valorNegociado;
	}
	public LocalDate getDataDeEntrega() {
		return dataDeEntrega;
	}
	public void setDataDeEntrega(LocalDate dataDeEntrega) {
		this.dataDeEntrega = dataDeEntrega;
	}
	public String getUrlDoProdoto() {
		return urlDoProdoto;
	}
	public void setUrlDoProdoto(String urlDoProdoto) {
		this.urlDoProdoto = urlDoProdoto;
	}
	public String getUrlDaImagem() {
		return urlDaImagem;
	}
	public void setUrlDaImagem(String urlDaImagem) {
		this.urlDaImagem = urlDaImagem;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public List<Oferta> getOfertas() {
		return ofertas;
	}
	public void setOfertas(List<Oferta> ofertas) {
		this.ofertas = ofertas;
	}
}
