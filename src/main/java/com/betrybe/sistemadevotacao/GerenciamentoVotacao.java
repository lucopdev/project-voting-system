package com.betrybe.sistemadevotacao;

import java.util.ArrayList;

/**
 * The type Gerenciamento votacao.
 */
public class GerenciamentoVotacao implements GerenciamentoVotacaoInterface {

  private final ArrayList<PessoaCandidata> pessoasCandidatas = new ArrayList<>();
  private final ArrayList<PessoaEleitora> pessoasEleitoras = new ArrayList<>();
  private final ArrayList<String> cpfsComputados = new ArrayList<>();

  /**
   * Método para cadastrar candidatos. *
   *
   * @param nome   nome do candidato
   * @param numero numero do candidato
   */
  public void cadastrarPessoaCandidata(String nome, int numero) {
    for (PessoaCandidata pessoasCandidata : this.pessoasCandidatas) {
      boolean numeroEncontrado = pessoasCandidata.numero == numero;

      if (numeroEncontrado) {
        System.out.println("Número da pessoa candidata já utilizado!");
        return;
      }
    }
    PessoaCandidata pessoaCandidata = new PessoaCandidata(nome, numero);
    this.pessoasCandidatas.add(pessoaCandidata);
  }

  /**
   * Método para cadastro de pessoas eleitoras. *
   *
   * @param nome nome da pessoa eleitora
   * @param cpf  cpf da pessoa eleitora
   */
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    for (PessoaEleitora pessoasEleitora : this.pessoasEleitoras) {
      boolean cpfEncontrado = pessoasEleitora.getCpf().equals(cpf);

      if (cpfEncontrado) {
        System.out.println("Pessoa eleitora já cadastrada!");
        return;
      }
    }
    PessoaEleitora pessoaEleitora = new PessoaEleitora(nome, cpf);
    this.pessoasEleitoras.add(pessoaEleitora);
  }

  /**
   * Método para exercer o voto. *
   *
   * @param cpfPessoaEleitora     cpf da pessoa eleitora
   * @param numeroPessoaCandidata numero da pessoa candidata
   */
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    for (String cpfsComputado : cpfsComputados) {
      boolean cpfEncontrado = cpfsComputado.equals(cpfPessoaEleitora);

      if (cpfEncontrado) {
        System.out.println("Pessoa eleitora já votou!");
        return;
      }
    }
    for (PessoaCandidata pessoaCandidata : pessoasCandidatas) {
      boolean numeroEncontrado = pessoaCandidata.numero == numeroPessoaCandidata;

      if (numeroEncontrado) {
        cpfsComputados.add(cpfPessoaEleitora);
        pessoaCandidata.receberVoto();
      }
    }
  }

  /**
   * Método para mostrar o resultado da eleição. *
   */
  public void mostrarResultado() {
    int totalVotos = 0;

    if (!cpfsComputados.isEmpty()) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado");
    }

    for (PessoaCandidata pessoaCandidata : pessoasCandidatas) {
      int votos = pessoaCandidata.getVotos();
      totalVotos += votos;
    }
    
    for (PessoaCandidata pessoaCandidata : pessoasCandidatas) {
      String nome = pessoaCandidata.getNome();
      int votos = pessoaCandidata.getVotos();

      System.out.println(
          "Nome: " + nome + " - " + votos + " votos " + "( " + Math.round(
              (votos * 100) / totalVotos)
              + "% )");
    }

    System.out.println("Total de votos: " + totalVotos);
  }
}