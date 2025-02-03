package br.com.jefferson.model;

public class Vendedor extends Funcionario{
	private double comissao;
	public Vendedor(String nome, double salarioBase,double comissao) {
		super(nome, salarioBase);
		this.comissao = comissao;
	}
	
	public double getComissao() {
		return comissao;
	}

	public void setComissao(double comissao) {
		this.comissao = comissao;
	}

	@Override
	public double calcularSalario() {
		
		return getSalarioBase() + getComissao();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + ", Comissão : R$ "+comissao+" (Vendedor)";
	}

	
	
	
}
