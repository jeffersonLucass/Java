package br.com.jefferson.service;
import java.util.List;

import br.com.jefferson.model.Funcionario;

public class FolhaPagamento {
	
	public double calcularFolha(List<Funcionario> funcionarios) {
		double total = 0;
		
		for(Funcionario f: funcionarios) {
			total += f.calcularSalario();
		}
		return total;
	}
	
	
}
