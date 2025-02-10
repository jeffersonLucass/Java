package gerenciadorDeNotasFiscais;

public class ClientInfo {

	private int id;
	private double total;

	public ClientInfo(int id, double total) {
		super();
		this.id = id;
		this.total = total;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public void adicionarValor(double valor) {
		this.total += valor;
	}

}
