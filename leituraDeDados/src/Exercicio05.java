import java.util.Scanner;

public class Exercicio05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				
        int numeroPecas1 = sc.nextInt();
        double valorUnitarioPeca1 = sc.nextDouble();
		
        int numeroPecas2 = sc.nextInt();
        double valorUnitarioPeca2 = sc.nextDouble();
		
        double valorTotal = (numeroPecas1 * valorUnitarioPeca1) + (numeroPecas2 * valorUnitarioPeca2);
        
        System.out.printf("VALOR A PAGAR : R$%.2f\n",valorTotal);
        
		
		sc.close();

	}

}
