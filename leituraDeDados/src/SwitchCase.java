import java.util.Scanner;
public class SwitchCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		
		switch (x) {
		case 1:
			System.out.println("Dia da semana : DOMINGO");
			break;
		case 2:
			System.out.println("Dia da semana : SEGUNDA");
			break;
		case 3:
			System.out.println("Dia da semana : TERCA-FEIRA");
			break;	
		case 4:
			System.out.println("Dia da semana : QUARTA-FEIRA");
			
			break;
		case 5:
			System.out.println("Dia da semana : QUINTA-FEIRA");
			break;
			
		case 6:
			System.out.println("Dia da semana : SEXTA-FEIRA");
			break;
			
			
		case 7:
			
			System.out.println("Dia da semana : SÁBADO");
			
			break;
		default:
			System.out.println("Valor invalido");
			break;
		}
		
		
		
		
		sc.close();
		

	}

}
