package br.com.jefferson.app;
import java.util.ArrayList;
import java.util.List;

import br.com.jefferson.model.Funcionario;
import br.com.jefferson.model.Gerente;
import br.com.jefferson.model.Vendedor;
import br.com.jefferson.service.FolhaPagamento;


public class Main {

	public static void main(String[] args) {
		Gerente gerente = new Gerente("Carlos",5000);
		Vendedor vendedor1 = new Vendedor("Ana", 2000, 500);
        Vendedor vendedor2 = new Vendedor("João", 1800, 300.20);
        Vendedor vendedor3 = new Vendedor("maria", 3000, 500);
     // Adicionando à lista de funcionários
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(gerente);
        funcionarios.add(vendedor1);
        funcionarios.add(vendedor2);
        funcionarios.add(vendedor3);
        
        System.out.println("Funcionarios Cadastrados:");
        for(Funcionario funcionario : funcionarios) {
        	System.out.println(funcionario);
        }
        
        
        FolhaPagamento folha = new FolhaPagamento();
        double totalSalarios = folha.calcularFolha(funcionarios);

        System.out.println("Total da folha de pagamento: R$ " + totalSalarios);
        
	}

}
