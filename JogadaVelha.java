 import java.util.Scanner;

public class JogoDaVelha {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char[][] tabuleiro = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };

        int linha, coluna;
        char jogador = 'X';

        for (int i = 0; i < 9; i++) {

            System.out.println("Jogador " + jogador);
            System.out.print("Linha (0-2): ");
            linha = sc.nextInt();
            System.out.print("Coluna (0-2): ");
            coluna = sc.nextInt();

            if(tabuleiro[linha][coluna] == ' ') {
                tabuleiro[linha][coluna] = jogador;

                jogador = (jogador == 'X') ? 'O' : 'X';
            } else {
                System.out.println("Posição ocupada!");
                i--;
            }

            for(int l = 0; l < 3; l++) {
                for(int c = 0; c < 3; c++) {
                    System.out.print(tabuleiro[l][c] + " ");
                }
                System.out.println();
            }
        }

        sc.close();
    }
}