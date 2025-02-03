package application;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int negativeNumbers = 0;
		int[][] matriz = new int[n][n];

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = sc.nextInt();
			}
		}

		System.out.println("Main diagonal:");
		for (int i = 0; i < n; i++) {
			System.out.print(matriz[i][i] + " ");
		}
		System.out.println("");
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (matriz[i][j] < 0) {
					negativeNumbers++;
				}
			}
		}
		System.out.println("Negative number: " + negativeNumbers);

		sc.close();

	}

}
