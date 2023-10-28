package com.betrybe.sistemadevotacao;

import java.util.ArrayList;

/**
 * The type Gerenciamento votacao.
 */
public class GerenciamentoVotacao implements GerenciamentoVotacaoInterface {

  final private ArrayList<PessoaCandidata> pessoasCandidatas = new ArrayList<>();
  final private ArrayList<PessoaEleitora> pessoasEleitoras = new ArrayList<>();
  final private ArrayList<String> cpfsComputados = new ArrayList<>();

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

  public void mostrarResultado() {
    if (!cpfsComputados.isEmpty()) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado");
    }

    int totalVotos = 0;

    for (PessoaCandidata pessoaCandidata : pessoasCandidatas) {
      String nome = pessoaCandidata.getNome();
      int votos = pessoaCandidata.getVotos();
      totalVotos += votos;
      System.out.println(
          "Nome: " + nome + " - " + votos + " votos " + "( " + Math.round(
              (votos * 100) / totalVotos)
              + "% )");
    }
    System.out.println("Total de votos: " + totalVotos);
  }
}