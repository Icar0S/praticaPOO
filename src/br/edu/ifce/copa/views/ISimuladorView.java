/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifce.copa.views;

import br.edu.ifce.copa.Grupo;
import br.edu.ifce.copa.Pontuacao;
import br.edu.ifce.copa.Selecao;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author ikrov
 */
interface ISimuladorView {
    void exibirPontuacao(Collection<Pontuacao> pontuacoes);
    void exibirSelecoes(Collection<Selecao> selecoes);
    void setGroups(ArrayList<Grupo> groups);
    void selectSelecaoA(int selecaoIdx);
    void selectSelecaoB(int selecaoIdx);
    void setGolsA(int golsA);
    void setGolsB(int golsB);
}
