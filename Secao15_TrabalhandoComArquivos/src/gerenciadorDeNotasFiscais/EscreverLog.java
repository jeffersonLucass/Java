package gerenciadorDeNotasFiscais;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EscreverLog {
	
	public static void Escrever(String logFilePath,String fileName) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(logFilePath))){
			
			LocalDateTime now = LocalDateTime.now();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			String timestamp = now.format(dtf);
			
			bw.write("Execução em: " + timestamp);
            bw.write("Arquivo processado: " + fileName);
            
            bw.write("------------------------------");
           
			
            System.out.println("Log atualizado em " + logFilePath);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
	}
	
	
	
}
