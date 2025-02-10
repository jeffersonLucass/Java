package gerenciadorDeNotasFiscais;

import java.io.*;
import java.util.*;

public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter file path: ");
        String path = sc.nextLine();

        File sourceFile = new File(path);
        String sourceFolderStr = sourceFile.getParent();

        String resumoFileStr = sourceFolderStr + "\\resumo.csv";
        String logFileStr = sourceFolderStr + "\\log.txt";
        //ESSA PARTE DE CIMA È RESPONSAVEL POR PEGAR O NOME DO ARQUIVO.
        
        
        
        // Map para armazenar os clientes pelo nome e associar ao ID e total acumulado
		Map<String, ClientInfo> clientesTotais = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(sourceFile))) {

            String line = br.readLine();

            while (line != null) {
                String[] fields = line.split(",");

                if (fields.length != 3) {
                    System.out.println("Erro ao tentar ler a linha: " + line);
                    line = br.readLine(); // Corrige o loop para continuar lendo
                    continue;
                }

                int id = Integer.parseInt(fields[0]);
                String client = fields[1];
                double value = Double.parseDouble(fields[2]);

                // Verifica se o cliente já existe no Map
                if (clientesTotais.containsKey(client)) {
                    clientesTotais.get(client).adicionarValor(value);
                } else {
                    clientesTotais.put(client, new ClientInfo(id, value));
                }

                line = br.readLine();
            }

            // Criando arquivo resumo.csv na mesma pasta do arquivo original
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(resumoFileStr))) {

                for (Map.Entry<String, ClientInfo> entry : clientesTotais.entrySet()) {
                    ClientInfo info = entry.getValue();
                    bw.write(info.getId() + "," + entry.getKey() + "," + String.format("%.2f", info.getTotal()));
                    bw.newLine();
                }

                System.out.println("Arquivo criado em: " + resumoFileStr);

                // Chamada para escrever no log usando a classe separada
                EscreverLog.Escrever(logFileStr, sourceFile.getName());

            } catch (Exception e) {
                System.out.println("Erro ao escrever no arquivo resumo: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        sc.close();
    }
}
