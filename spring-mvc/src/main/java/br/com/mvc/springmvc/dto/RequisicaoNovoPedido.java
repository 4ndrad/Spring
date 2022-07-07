package br.com.mvc.springmvc.dto;

import javax.validation.constraints.NotBlank;

import br.com.mvc.springmvc.model.Pedido;
import br.com.mvc.springmvc.model.StatusPedido;

public class RequisicaoNovoPedido {
	
	@NotBlank
	private String nomeProduto;
	
	@NotBlank
	private String urlDoProdoto;
	
	@NotBlank
	private String urlDaImagem;
	private String descricao;
	
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
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
	
	public Pedido toPedido() {
		Pedido pedido = new Pedido();
		pedido.setNomeProduto(nomeProduto);
		pedido.setUrlDoProdoto(urlDoProdoto);
		pedido.setUrlDaImagem(urlDaImagem);
		pedido.setDescricao(descricao);
		pedido.setStatus(StatusPedido.AGUARDANDO);
		
		return pedido;
	}
	
	
}
