package br.com.jefferson.jogocarta;
import java.util.Arrays;
public class Main {

	public static void main(String[] args) {
		Jogador jogador1 = new Jogador("João");
        Jogador jogador2 = new Jogador("Maria");
        Jogador jogador3 = new Jogador("Carlos");

        JogoCartas jogo = new JogoCartas(Arrays.asList(jogador1, jogador2, jogador3));
        jogo.iniciarJogo();

	}

}
