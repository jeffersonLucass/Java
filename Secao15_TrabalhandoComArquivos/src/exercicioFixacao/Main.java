package exercicioFixacao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Product> list = new ArrayList<>();

        System.out.println("Enter file path: ");
        String sourceFileStr = sc.nextLine();

        File sourceFile = new File(sourceFileStr);
        String sourceFolderStr = sourceFile.getParent(); // Obtém a pasta pai do arquivo
        @SuppressWarnings("unused")
		boolean success = new File(sourceFolderStr + "\\out").mkdir(); // Cria a pasta "out" dentro do diretório

        String targetFileStr = sourceFolderStr + "\\out\\summary.csv"; // Define o caminho do arquivo de saída
        String logFilePath = sourceFolderStr + "\\out\\log.txt"; // Define o caminho do arquivo de log

        try (BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))) {

            String itemCsv = br.readLine();
            while (itemCsv != null) {
                String[] fields = itemCsv.split(","); // Separa os itens utilizando a vírgula como delimitador
                String name = fields[0];
                double price = Double.parseDouble(fields[1]);
                int quantity = Integer.parseInt(fields[2]);

                list.add(new Product(name, price, quantity));

                itemCsv = br.readLine();
            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))) {

                for (Product item : list) {
                    bw.write(item.getName() + "," + String.format("%.2f", item.total()));
                    bw.newLine();
                }

                System.out.println(targetFileStr + " CREATED!");

                // Após a criação do summary.csv, registra no log
                escreverLog(logFilePath, sourceFile.getName());

            } catch (IOException e) {
                System.out.println("Error writing file: " + e.getMessage());
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        sc.close();
    }

    public static void escreverLog(String logFilePath, String fileName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(logFilePath, true))) { // "true" para modo append

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            String timestamp = now.format(formatter);

            bw.write("Execução em: " + timestamp);
            bw.newLine();
            bw.write("Arquivo processado: " + fileName);
            bw.newLine();
            bw.write("------------------------------");
            bw.newLine();

            System.out.println("Log atualizado em " + logFilePath);

        } catch (IOException e) {
            System.out.println("Erro ao tentar adicionar o log: " + e.getMessage());
        }
    }
}
