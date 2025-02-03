package br.com.jefferson.model;

public class Gerente extends Funcionario{

	public Gerente(String nome, double salarioBase) {
		super(nome, salarioBase);
		
	}

	@Override
	public double calcularSalario() {
		// TODO Auto-generated method stub
		return getSalarioBase() * 1.2;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + " (Gerente)";
	}
	
	
	
}
