package com.company;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        ArrayList<String> agenda = new ArrayList();
        Scanner entrada = new Scanner(System.in);
        int opcao = 0;
        importar(agenda);

        while (opcao != 5) {

            System.out
                    .println("Escolha a opção: 1-Incluir  2-Listar  3-Excluir  4-Pesquisar 5-Sair");
            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                case 1:
                    incluir(agenda);
                    break;
                case 2:
                    listar(agenda);
                    break;
                case 3:
                    excluir(agenda);
                    break;
                case 4:
                    pesquisar(agenda);
                    break;
                case 5:
                    System.out.println("Programa encerrado!");
                    return;
                default:
                    System.out.println("Opção Inválida! Tente novamente.");
                    break;
            }
            System.out.printf("\n\n");
            exportar(agenda);
        }
    }


    public static void importar(ArrayList<String> agenda) {
        try {
            FileReader arq = new FileReader("agenda.txt");
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = lerArq.readLine();
            while (linha != null) {
                agenda.add(linha);
                linha = lerArq.readLine();
            }
            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.",
                    e.getMessage());
        }
    }

    public static void exportar(ArrayList<String> agenda)
            throws IOException {
        FileWriter arq = new FileWriter("agenda.txt");
        PrintWriter gravarArq = new PrintWriter(arq);
        int i, n = agenda.size();
        for (i=0; i<n; i++) {
            gravarArq.printf("%s%n", agenda.get(i));
        }
        gravarArq.close();
    }

    public static void incluir(ArrayList<String> agenda) {
        Scanner ler = new Scanner(System.in);
        String nome, nomeSemTrati, telefone;

        System.out.printf("\nInforme o nome do contato:\n");
        nomeSemTrati = ler.nextLine();
        nome = nomeSemTrati.substring(0, 1).toUpperCase() + nomeSemTrati.substring(1);

        System.out.printf("\nInforme o telefone do contato:\n");
        telefone = ler.nextLine();

        // grava os dados no final da "lista"
        agenda.add(nome + ";" + telefone);
        Collections.sort(agenda);
    }

    public static void excluir(ArrayList<String> agenda) {
        Scanner ler = new Scanner(System.in);
        int i;

        listar(agenda);

        System.out.printf("\nInforme a posicao a ser excluida:\n");
        i = ler.nextInt();

        try {
            agenda.remove(i);
        } catch (IndexOutOfBoundsException e) {
            System.out.printf("\nErro: posicao invalida (%s).\n\n",
                    e.getMessage());
        }
    }

    public static void listar(ArrayList<String> agenda) {
        System.out.printf("\nListadando os itens da Agenda:\n");
        int i, n = agenda.size();
        for (i=0; i<n; i++) {
            System.out.printf("posicao %d- %s\n", i, agenda.get(i));
        }
        System.out.printf("---------------------------------------");
    }

    public static void pesquisar(ArrayList<String> agenda) {
        Scanner ler = new Scanner(System.in);
        String s;

        System.out.printf("\nInforme o nome do contato:\n");
        s = ler.nextLine();

        int i, n = agenda.size();
        s = s.toUpperCase();
        String dados[];
        for (i=0; i<n; i++) {
            if (agenda.get(i).toUpperCase().indexOf(s) != -1) {
                dados = agenda.get(i).split(";");
                System.out.printf("\nNome....: %s", dados[0]);
                System.out.printf("\nTelefone: %s\n", dados[1]);
            }
        }
    }
}