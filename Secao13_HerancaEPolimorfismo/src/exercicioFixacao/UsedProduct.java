package exercicioFixacao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UsedProduct extends Product {
	
	//DATA DE FABRICAÇÃO
	private LocalDate manufactureLocalDate;
	
	public UsedProduct() {
		
	}

	public UsedProduct(String name, Double price, LocalDate manufactureLocalDate) {
		super(name, price);
		this.manufactureLocalDate = manufactureLocalDate;
	}

	public LocalDate getManufactureLocalDate() {
		return manufactureLocalDate;
	}

	public void setManufactureLocalDate(LocalDate manufactureLocalDate) {
		this.manufactureLocalDate = manufactureLocalDate;
	}
	
	@Override
	public String priceTag() {
		return getName() 
				+ " (used) $ " 
				+ String.format("%.2f", getPrice())
				+ " (Manufacture date: "
				+ manufactureLocalDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
				+ ")";
	}
	
	
	
	
}
