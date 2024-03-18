package Programas;

import Entidades.Vaca;
import java.util.Scanner;

/**
 *
 * @author vitor
 */
public class VitorEliasADO1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("PROGRAMA VACAS\n\n");

        Vaca vaca = CriarVaca();
        int N = 0;

        do {
 
            System.out.println("\n\nDigite 1 para andar.");
            System.out.println("Digite 2 para parar.");
            System.out.println("Digite 3 para se alimentar.");
            System.out.println("Digite 4 para produzir leite.");
            System.out.println("Digite 5 para ver as informações da vaca.");
            System.out.println("Digite 6 para modificar informações da vaca.");
            System.out.println("Digite 7 para sair.");
            N = input.nextInt();

            switch (N) {
                case 1:
                    vaca.Andar();
                    N = ContinuarPrograma();
                    break;

                case 2:
                    vaca.Parar();
                    N = ContinuarPrograma();
                    break;

                case 3:
                    vaca.Alimentar();
                    N = ContinuarPrograma();
                    break;

                case 4:
                    vaca.ProduzirLeite();
                    N = ContinuarPrograma();
                    break;

                case 5:

                    System.out.println("Nome -- " + vaca.getNome());
                    System.out.println("Idade -- " + vaca.getIdade());
                    System.out.println("Porte -- " + vaca.getPorte());
                    System.out.println("Pelagem -- " + vaca.getPelagem());
                    N = ContinuarPrograma();
                    System.out.println("\n\n");
                    break;

                case 6:
                    vaca = CriarVaca();
                    break;

                case 7:
                    break;

                default:
                    System.out.println("ERRO INFORMAÇÂO INVALIDA!!!");
                    break;

            }

        } while (N != 7);

        System.out.println("SAINDO DO PROGRAMA!!!");
    }

    public static int ContinuarPrograma() {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\nContinuar no programa?");
            String cont = input.nextLine().toLowerCase();

            if (cont.equals("sim")) {
                return 1;
            } else if (cont.equals("nao") || cont.equals("não")) {

                return 7;
            } else {
                System.out.println("Opção errada!:\n");
            }

        }

    }

    public static Vaca CriarVaca() {
        Scanner input = new Scanner(System.in);

        System.out.println("Nome Da vaca:");
        String nome = input.nextLine();

        System.out.println("Idade dela:");
        int idade = input.nextInt();
        input.nextLine();

        System.out.println("Digite seu porte:");
        String porte = input.nextLine();

        System.out.println("Tamanho da pelagem:");
        String pelagem = input.nextLine();

        Vaca vaca = new Vaca(nome, idade, porte, pelagem);
        return vaca;

    }
}
