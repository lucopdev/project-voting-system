package com.betrybe.sistemadevotacao;

import java.util.Scanner;

/**
 * The type Principal.
 */
public class Principal {

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    GerenciamentoVotacao votacao = new GerenciamentoVotacao();

    Scanner scanner = new Scanner(System.in);

    int opcao = 0;

    while (opcao != 2) {
      System.out.println("Cadastrar pessoa candidata?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.print("Entre com o número correspondente à opção desejada: ");
      opcao = scanner.nextInt();

      if (opcao == 1) {
        System.out.print("Entre com o nome da pessoa candidata: ");
        String nomeCandidato = scanner.next();

        System.out.print("Entre com o número da pessoa candidata: ");
        int numeroCandidato = scanner.nextInt();

        votacao.cadastrarPessoaCandidata(nomeCandidato, numeroCandidato);
      }
    }

    opcao = 0;

    while (opcao != 2) {
      System.out.println("Cadastrar pessoa eleitora?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.print("Entre com o número correspondente à opção desejada: ");
      opcao = scanner.nextInt();

      if (opcao == 1) {
        System.out.print("Entre com o nome da pessoa eleitora: ");
        String nomeEleitor = scanner.next();
        System.out.print("Entre com o cpf da pessoa candidata: ");
        String cpfEleitor = scanner.next();

        votacao.cadastrarPessoaEleitora(nomeEleitor, cpfEleitor);
      }
    }

    opcao = 0;

    while (opcao != 3) {
      System.out.println("Entre com o número correspondente à opção desejada:");
      System.out.println("1 - Votar");
      System.out.println("2 - Resultado Parcial");
      System.out.println("3 - Finalizar Votação");
      opcao = scanner.nextInt();

      if (opcao == 1) {
        System.out.print("Entre com o cpf da pessoa eleitora: ");
        String cpfEleitorVotacao = scanner.next();
        System.out.print("Entre com o numero da pessoa candidata: ");
        int numeroCandidatoVotacao = scanner.nextInt();

        votacao.votar(cpfEleitorVotacao, numeroCandidatoVotacao);
      }

      if (opcao == 2) {
        votacao.mostrarResultado();
      }
    }
    votacao.mostrarResultado();
    scanner.close();
  }
}
