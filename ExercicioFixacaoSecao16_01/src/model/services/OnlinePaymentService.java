package model.services;

public interface OnlinePaymentService {
	
	public double paymentFee(double amount);//taxa de pagamento
	public double interestRates(double amount,Integer months);	//essa funcao recebe uma quantia e quantidade de meses
	//taxa de juros
}
