package application;

import java.util.Locale;
import java.util.Scanner;

public class DiagonalPrincipal {

	public static void main(String[] args) {
	
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);
     
        
        char O = scanner.next().toUpperCase().charAt(0);
		double[][] M = new double[12][12];
        double soma = 0.0;
        
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                M[i][j] = scanner.nextDouble();
                
            }
        }
        
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                if(j > i && j > M.length-i-1) {
                	soma+=M[i][j];
                }
                
            }
        }
        
        if(O == 'M') soma/= 30;
        
        


        System.out.printf("%.1f%n", soma);
        scanner.close();

	}

}
