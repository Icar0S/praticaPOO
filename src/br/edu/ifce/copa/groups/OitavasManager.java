package br.edu.ifce.copa.groups;

import br.edu.ifce.copa.*;

import java.util.ArrayList;

public class OitavasManager extends GroupManager {


    public OitavasManager(Campeonato campeonato) {
        super(campeonato);
    }

    @Override
    public ArrayList<Selecao> getSelecoes() {
        ArrayList<Selecao> list = new ArrayList<>();

        for (int i = 0; i <= 7; i++) {
            ArrayList<Pontuacao> pontuacoes = new PontuacaoBuilder(campeonato).setGroupId(i).build();
            list.add(pontuacoes.get(0).getSelecao());
            list.add(pontuacoes.get(1).getSelecao());
        }

        return list;
    }

    @Override
    public Match getMatch(int matchNumber) {
        matchNumber = matchNumber % 7;
        int groupA = matchNumber;
        int groupB = (matchNumber % 2 == 0)? groupA + 1 : groupA - 1;

        ArrayList<Pontuacao> selecoesA = new PontuacaoBuilder(campeonato).setGroupId(groupA).build();
        ArrayList<Pontuacao> selecoesB = new PontuacaoBuilder(campeonato).setGroupId(groupB).build();

        return new Match(selecoesA.get(0).getSelecao(), selecoesB.get(1).getSelecao());
    }
}
