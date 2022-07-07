package br.com.mvc.springmvc.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.mvc.springmvc.model.Pedido;
import br.com.mvc.springmvc.model.StatusPedido;
import br.com.mvc.springmvc.repository.PedidoRepository;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	 //para pedir uma instancia
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping
	public String home(Model model, Principal principal) {
		
		//ordena por data de entrega
		Sort sort = Sort.by("dataDeEntrega").descending();
		
		//limita o item por gagina  pagina
		PageRequest paginacao = PageRequest.of(0, 10, sort);
		
		List<Pedido> pedidos =  pedidoRepository.findByStatus(StatusPedido.ENTREGUE, paginacao);
		model.addAttribute("pedidos", pedidos);
		
		return "home";
	}
}
