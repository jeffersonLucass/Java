package br.com.jefferson.application;

import java.util.Locale;
import java.util.Scanner;

import br.com.jefferson.entities.Employee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Employee func = new Employee();
		
		System.out.print("Name: ");
		func.Name = sc.nextLine();
		System.out.print("Gross Salary: ");
		func.GrossSalary = sc.nextDouble();
		System.out.print("Tax: ");
		func.Tax = sc.nextDouble();
		
		
		System.out.println();
		System.out.println(func);
		System.out.println();
		System.out.print("Which percentage to increase salary? ");
		double percentage = sc.nextDouble(); 
		func.IncreaseSalary(percentage);
		
		System.out.println();
		System.out.println("Update data: "+func);
		
		sc.close();
		
	}

}
