package main;

import implementation.Supermarket;
import implementation.SupermarketArray;

import java.util.Scanner;

public class Main {
    private static final int SIZE = 3;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Supermarket supermarket = new SupermarketArray(SIZE);

        int option;

        do{
            System.out.println("\nLista de compras:");
            System.out.println("1 - Inserir");
            System.out.println("2 - Listar");
            System.out.println("3 - Remover");
            System.out.println("4 - Sair");

            System.out.println("Escolha uma opção: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Digite o item a ser inserido: ");
                    String item = sc.next();
                    supermarket.add(item);
                    break;
                case 2:
                    supermarket.print();
                    break;
                case 3:
                    System.out.println("Digite o item a ser removido: ");
                    int index = sc.nextInt();
                    supermarket.remove(index);
                    break;
                case 4:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }

        }while (option!=4);

        sc.close();
    }
}
