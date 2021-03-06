package br.com.alura.spring.data;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.spring.data.service.CrudCargoService;
import br.com.alura.spring.data.service.CrudFuncionarioService;
import br.com.alura.spring.data.service.CrudUnidadeTrabalhoService;
import br.com.alura.spring.data.service.RelatorioFuncionarioDinamico;
import br.com.alura.spring.data.service.RelatoriosService;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private Boolean system = true;

	private final CrudCargoService cargoService;

	private final CrudFuncionarioService funcionarioService;

	private final CrudUnidadeTrabalhoService unidadeTrabalhoService;
	
	private final RelatoriosService relatorioService;
	
	private final RelatorioFuncionarioDinamico relatorioFuncionarioDinamico;

	// construtor
	public SpringDataApplication(CrudCargoService cargoService,
			CrudFuncionarioService funcionarioService, 
			CrudUnidadeTrabalhoService unidadeTrabalhoService, RelatoriosService relatorioService, RelatorioFuncionarioDinamico relatorioFuncionarioDinamico) {
		this.cargoService = cargoService;
		this.funcionarioService = funcionarioService;
		this.unidadeTrabalhoService = unidadeTrabalhoService;
		this.relatorioService = relatorioService;
		this.relatorioFuncionarioDinamico = relatorioFuncionarioDinamico;
	}

	// inicia o spring
	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// pegar as informações do cliente pelo console
		Scanner scanner = new Scanner(System.in);

		while (system) {
			System.out.println("Qual ação você quer executar ?");
			System.out.println("0 - sair");
			System.out.println("1 - Funcionario");
			System.out.println("2 - Cargo");
			System.out.println("3 - Unidade");
			System.out.println("4 - Relatório");
			System.out.println("5 - Relatório dinâmico");

			Integer function = scanner.nextInt();

			switch (function) {
			case 1:
				funcionarioService.inicial(scanner);
				break;
			case 2:
				cargoService.inicial(scanner);
				break;
			case 3:
				unidadeTrabalhoService.inicial(scanner);
				break;
			case 4:
				relatorioService.inicial(scanner);
				break;
			case 5:
				relatorioFuncionarioDinamico.inicial(scanner);
				break;
			default:
				System.out.println("Finalizando");
				system = false;
				break;

			}

		}

	}
}
