package br.com.jefferson.model;

public class Funcionario {
	private String nome;
	private double salarioBase;
	
	public Funcionario(String nome, double salarioBase) {
		super();
		this.nome = nome;
		this.salarioBase = salarioBase;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(double salarioBase) {
		if(salarioBase >= 0) {
			this.salarioBase = salarioBase;
		}else {
			System.out.println("ERROR!! Salario base não pode ser menor que 0");
		}
	}
	
	
	public double calcularSalario() {
		return getSalarioBase();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Nome: "+ nome +", Salario Base: R$ " + salarioBase;
	}
	
	
	
	
}
