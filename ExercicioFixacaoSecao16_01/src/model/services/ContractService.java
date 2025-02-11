package model.services;

import java.time.LocalDate;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {

	private OnlinePaymentService onlinePaymentService;

	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}
	
	
	public void processContract(Contract contract, int months) {
		//BASICQUOTA É A PARCELA BASICA DO VALOR TOTAL SEM OS JUROS APLICADOS .
		
		double basicQuota = contract.getTotalValue() / months;
		
		for (int i = 1; i <= months; i++) {
			LocalDate dueDate = contract.getDate().plusMonths(i);
			
			double interest = onlinePaymentService.interestRates(basicQuota, i); //taxa de juros
			double fee = onlinePaymentService.paymentFee(basicQuota + interest); //taxa de pagamento
			double quota = basicQuota + interest + fee;
			
			contract.getInstallments().add(new Installment(dueDate, quota));
			
			
			
			
		}
		
	}
	
	
	
	
	
	
}
