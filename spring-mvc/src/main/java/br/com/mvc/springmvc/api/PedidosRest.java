package br.com.mvc.springmvc.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mvc.springmvc.model.Pedido;
import br.com.mvc.springmvc.model.StatusPedido;
import br.com.mvc.springmvc.repository.PedidoRepository;

@RestController
@RequestMapping("/api/pedidos")
public class PedidosRest {

	@Autowired
	private PedidoRepository pedidoRepository;

	@GetMapping("aguardando")
	public List<Pedido> getPedidosOfertas() {
		// ordena por data de entrega
		Sort sort = Sort.by("id").descending();

		// limita o item por gagina pagina
		PageRequest paginacao = PageRequest.of(0, 10, sort);

		return pedidoRepository.findByStatus(StatusPedido.AGUARDANDO, paginacao);
	}

}
