import java.util.Scanner;
import java.util.Random;

public class JogoDaVelha {
    private char[][] tabuleiro = new char[3][3];
    private char jogadorAtual = 'X';
    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();

    public JogoDaVelha() {
        inicializarTabuleiro();
    }

    private void inicializarTabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = ' ';
            }
        }
    }

    private void imprimirTabuleiro() {
        System.out.println("   |   |   ");
        System.out.println(" " + tabuleiro[0][0] + " | " + tabuleiro[0][1] + " | " + tabuleiro[0][2] + " ");
        System.out.println("___|___|___");
        System.out.println("   |   |   ");
        System.out.println(" " + tabuleiro[1][0] + " | " + tabuleiro[1][1] + " | " + tabuleiro[1][2] + " ");
        System.out.println("___|___|___");
        System.out.println("   |   |   ");
        System.out.println(" " + tabuleiro[2][0] + " | " + tabuleiro[2][1] + " | " + tabuleiro[2][2] + " ");
        System.out.println("   |   |   ");
    }

    private boolean fazerJogada(int linha, int coluna) {
        if (linha >= 0 && linha < 3 && coluna >= 0 && coluna < 3 && tabuleiro[linha][coluna] == ' ') {
            tabuleiro[linha][coluna] = jogadorAtual;
            return true;
        }
        return false;
    }

    private boolean verificarVitoria(char jogador) {
        // Linhas e colunas
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0] == jogador && tabuleiro[i][1] == jogador && tabuleiro[i][2] == jogador) return true;
            if (tabuleiro[0][i] == jogador && tabuleiro[1][i] == jogador && tabuleiro[2][i] == jogador) return true;
        }
        // Diagonais
        if (tabuleiro[0][0] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][2] == jogador) return true;
        if (tabuleiro[0][2] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][0] == jogador) return true;
        return false;
    }

    private boolean tabuleiroCheio() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] == ' ') return false;
            }
        }
        return true;
    }

    private void trocarJogador() {
        jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
    }

    public void jogar() {
        boolean jogarNovamente;
        do {
            inicializarTabuleiro();
            System.out.println("Jogo da Velha - Jogador X começa!");
            imprimirTabuleiro();

            while (true) {
                System.out.print("Jogador " + jogadorAtual + ", digite linha (0-2) e coluna (0-2): ");
                int linha = scanner.nextInt();
                int coluna = scanner.nextInt();

                if (fazerJogada(linha, coluna)) {
                    imprimirTabuleiro();
                    if (verificarVitoria(jogadorAtual)) {
                        System.out.println("Jogador " + jogadorAtual + " venceu!");
                        break;
                    }
                    if (tabuleiroCheio()) {
                        System.out.println("Empate!");
                        break;
                    }
                    trocarJogador();
                } else {
                    System.out.println("Jogada inválida! Tente novamente.");
                }
            }

            System.out.print("Jogar novamente? (s/n): ");
            jogarNovamente = scanner.next().toLowerCase().charAt(0) == 's';
        } while (jogarNovamente);
        scanner.close();
    }

    public static void main(String[] args) {
        new JogoDaVelha().jogar();
    }
}