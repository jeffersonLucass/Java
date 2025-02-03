package br.com.jefferson.jogocarta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class JogoCartas {
    private List<Carta> deck;
    private List<Jogador> jogadores;
    private Stack<Carta> pilhaDescarte;
    private int jogadorAtual;
    private boolean sentidoHorario;

    // Construtor
    public JogoCartas(List<Jogador> jogadores) {
        this.deck = new ArrayList<>();
        this.jogadores = jogadores;
        this.pilhaDescarte = new Stack<>();
        this.jogadorAtual = 0;
        this.sentidoHorario = true;
        inicializarBaralho();
        embaralharBaralho();
        distribuirCartas(7); // Distribui 7 cartas para cada jogador
        pilhaDescarte.push(deck.remove(0)); // Define a carta inicial
    }

    // Inicializa o baralho
    private void inicializarBaralho() {
        String[] cores = {"vermelho", "azul", "verde", "amarelo"};
        String[] valores = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "pular", "reverter", "comprar 2"};

        for (String cor : cores) {
            for (String valor : valores) {
                deck.add(new Carta(cor, valor));
                if (!valor.equals("0")) {
                    deck.add(new Carta(cor, valor)); // Cartas não "0" aparecem duas vezes
                }
            }
        }

        // Adiciona curingas
        for (int i = 0; i < 4; i++) {
            deck.add(new Carta("curinga", "escolher cor"));
            deck.add(new Carta("curinga", "comprar 4"));
        }
    }

    // Embaralha o baralho
    private void embaralharBaralho() {
        Collections.shuffle(deck);
    }

    // Distribui cartas aos jogadores
    private void distribuirCartas(int numCartas) {
        for (Jogador jogador : jogadores) {
            for (int i = 0; i < numCartas; i++) {
                jogador.adicionarCarta(deck.remove(0));
            }
        }
    }

    // Controla o próximo jogador
    private void proximoJogador() {
        if (sentidoHorario) {
            jogadorAtual = (jogadorAtual + 1) % jogadores.size();
        } else {
            jogadorAtual = (jogadorAtual - 1 + jogadores.size()) % jogadores.size();
        }
    }

    // Realiza uma jogada
    public void fazerJogada(Jogador jogador, Carta carta) {
        Carta cartaAtual = pilhaDescarte.peek();
        if (carta.getCor().equals(cartaAtual.getCor()) || carta.getValor().equals(cartaAtual.getValor()) || carta.getCor().equals("curinga")) {
            jogador.removerCarta(carta);
            pilhaDescarte.push(carta);

            // Aplica efeitos de cartas especiais
            if (carta.getValor().equals("pular")) {
                proximoJogador(); // Pula o próximo jogador
            } else if (carta.getValor().equals("reverter")) {
                sentidoHorario = !sentidoHorario; // Inverte o sentido
            } else if (carta.getValor().equals("comprar 2")) {
                proximoJogador();
                jogadores.get(jogadorAtual).adicionarCarta(deck.remove(0));
                jogadores.get(jogadorAtual).adicionarCarta(deck.remove(0));
            } else if (carta.getValor().equals("comprar 4")) {
                proximoJogador();
                for (int i = 0; i < 4; i++) {
                    jogadores.get(jogadorAtual).adicionarCarta(deck.remove(0));
                }
            }

            proximoJogador(); // Avança para o próximo jogador
        } else {
            System.out.println("Jogada inválida! Escolha outra carta.");
        }
    }

    // Checa se alguém venceu
    public boolean checarVitoria() {
        for (Jogador jogador : jogadores) {
            if (jogador.quantidadeCartas() == 0) {
                System.out.println(jogador + " venceu o jogo!");
                return true;
            }
        }
        return false;
    }

    // Inicia o jogo
    public void iniciarJogo() {
        while (!checarVitoria()) {
            Jogador jogador = jogadores.get(jogadorAtual);
            System.out.println("Turno de " + jogador);
            // Aqui você pode implementar lógica para escolher carta automaticamente ou entrada do jogador
            proximoJogador();
        }
    }
}
