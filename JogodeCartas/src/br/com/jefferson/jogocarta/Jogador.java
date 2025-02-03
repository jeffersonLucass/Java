package br.com.jefferson.jogocarta;
import java.util.ArrayList;
import java.util.List;


public class Jogador {
	private String nome;
    private List<Carta> mao;

    // Construtor
    public Jogador(String nome) {
        this.nome = nome;
        this.mao = new ArrayList<>();
    }

    // Adicionar carta à mão
    public void adicionarCarta(Carta carta) {
        mao.add(carta);
    }

    // Remover carta da mão
    public boolean removerCarta(Carta carta) {
        return mao.remove(carta);
    }

    // Retorna a quantidade de cartas na mão
    public int quantidadeCartas() {
        return mao.size();
    }

    // Retorna as cartas na mão
    public List<Carta> getMao() {
        return mao;
    }

    @Override
    public String toString() {
        return nome + " com " + mao.size() + " cartas.";
    }
}
