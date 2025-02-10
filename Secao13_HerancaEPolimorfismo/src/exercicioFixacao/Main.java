package exercicioFixacao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Product> list = new ArrayList<Product>();
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		
		for (int i = 0; i < n; i++) {
			System.out.println("Product #"+(i+1)+" data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char ch = sc.next().charAt(0);
			System.out.print("Name:");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price:");
			double price = sc.nextDouble();
			
			if (ch == 'i') {
				System.out.print("Customs fee:");
				double customsFee = sc.nextDouble();
				list.add(new ImportedProduct(name, price, customsFee));
			}
			else if(ch == 'u') {
				System.out.print(" Manufacture date (DD/MM/YYYY): ");
				LocalDate date = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				list.add(new UsedProduct(name, price,date));
			}
			else {
				list.add(new Product(name, price));
			}	
		}
		
		System.out.println();
		System.out.println("ETIQUETAS DE PRECO:");
		for (Product prod : list) {
			System.out.println(prod.priceTag());
		}
		
		
		
		sc.close();
	}

}
