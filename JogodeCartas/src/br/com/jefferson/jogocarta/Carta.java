package br.com.jefferson.jogocarta;

public class Carta {

	private String cor;    // Ex.: "vermelho", "azul", "verde", "amarelo", "curinga"
    private String valor;  // Ex.: "1", "2", "pular", "reverter", "comprar 2"
	
	public Carta(String cor, String valor) {
		super();
		this.cor = cor;
		this.valor = valor;
	}
	
	// Getters
    public String getCor() {
        return cor;
    }

    public String getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return cor + " " + valor;
    }
	
	
	
	
}
