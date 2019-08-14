package com.company;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String[] nome = new String[20];
        String[] telefone = new String[20];

        for (int i = 0; i < nome.length; i++) {
            nome[i] = "";
            telefone[i] = "";

        }

        int opcao = 0, listarPor = 0, posicao = 0;
        String continuar = "", nomeExcluir = "", nomePesquisa = "";

        Scanner entrada = new Scanner(System.in);

        while (opcao != 4) {

            System.out
                    .println("Escolha a opção: 1-Incluir  2-Listar  3-Excluir  4-Sair");
            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                case 1:
                    // Código para Incluir

                    if (posicao < nome.length) {
                        while (continuar.equals("1")) {

                            System.out.print("Digite o nome: ");
                            nome[posicao] = entrada.nextLine();

                            System.out.print("Digite o telefone: ");
                            telefone[posicao] = entrada.nextLine();

                            System.out.print("Deseja continuar o cadastramento? 1-Sim  2-Não ");
                            continuar = entrada.nextLine();

                            posicao++;

                        }

                    } else {

                        System.out.println("Sua agenda está cheia.");

                    }


                    break;

                case 2:
                    System.out.println("Como deseja pesquisar? 1-Nome  2-Todos");
                    listarPor = entrada.nextInt();
                    entrada.nextLine();

                    switch (listarPor) {
                        case 1:
                            System.out.println("Digite o nome para pesquisa: ");
                            nomePesquisa = entrada.nextLine();

                            for (int i = 0; i < telefone.length; i++) {

                                if (nome[i].equalsIgnoreCase(nomePesquisa)) {

                                    System.out.println("Nome: " + nome[i] +
                                            "Telefone: " + telefone[i]);
                                }

                            }

                            break;

                        case 2:
                            // Código que lista todos os dados.
                            for (int i = 0; i < nome.length; i++) {

                                if (!nome[i].equals("")) {

                                    System.out.println("Nome: " + nome[i] + " Telefone: "
                                            + telefone[i]);

                                }

                            }

                            break;

                        default:
                            System.out.println("Opção inválida! Escolha números de 1 ou 2");

                            break;
                    }

                case 3:
                    // Código para Excluir
                    System.out.println("Quem deseja excluir? ");
                    nomeExcluir = entrada.nextLine();

                    for (int i = 0; i < nome.length; i++) {
                        if (nome[i].equals(nomeExcluir)) {

                            nome[i] = "";
                            telefone[i] = "";
                        }

                    }

                    break;
                case 4:
                    // Código para Sair
                    System.out.println("Programa Finalizado.");
                    return;

                default:
                    // Opção Invalida!
                    System.out.println("Opção Inválida! Tente novamente.");
                    break;
            }

        }
    }

    public static long read(String arquivo)  throws IOException {
        long x = System.currentTimeMillis();
        FileReader in = null;
        FileWriter out = null;

        try {
            in = new FileReader(arquivo);
            out = new FileWriter("outfile"+arquivo);
            int c;

            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
        long y = System.currentTimeMillis();
        return (y-x);
    }

}
