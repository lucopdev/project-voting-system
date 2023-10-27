package com.betrybe.sistemadevotacao;

import java.util.ArrayList;

/**
 * The type Gerenciamento votacao.
 */
public abstract class GerenciamentoVotacao implements GerenciamentoVotacaoInterface {

  private ArrayList pessoasCandidatas = new ArrayList<PessoaCandidata>();
  private ArrayList pessoasEleitoras = new ArrayList<PessoaEleitora>();
  private ArrayList cpfsComputados = new ArrayList<String>();

  /**
   * Instantiates a new Gerenciamento votacao.
   *
   * @param pessoaCandidata the pessoa candidata
   * @param pessoaEleitora  the pessoa eleitora
   * @param cpfComputado    the cpf computado
   */
  public GerenciamentoVotacao(PessoaCandidata pessoaCandidata,
      PessoaEleitora pessoaEleitora, String cpfComputado) {
    this.pessoasCandidatas.add(pessoaCandidata);
    this.pessoasEleitoras.add(pessoaEleitora);
    this.cpfsComputados.add(cpfComputado);
  }
}
