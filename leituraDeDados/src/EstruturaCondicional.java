import java.util.Scanner;

public class EstruturaCondicional {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int hora;
		System.out.printf("Quantas horas? ");
		hora = sc.nextInt();
		
		if (hora < 12) {
			System.out.println("Bom dia");
		}
		else if(hora >= 12 && hora < 18) {
				System.out.println("boa tarde");
		}
		else {
				System.out.println("Boa noite ");
		}
		
		
		

		
		sc.close();
	}

}
