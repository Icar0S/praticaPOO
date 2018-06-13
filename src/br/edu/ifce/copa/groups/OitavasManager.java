package br.edu.ifce.copa.groups;

import br.edu.ifce.copa.*;
import com.sun.istack.internal.NotNull;

import java.util.ArrayList;

public class OitavasManager extends GroupManager {

    public OitavasManager(Campeonato campeonato) {
        super(campeonato);
    }

    @Override
    @NotNull
    public ArrayList<Selecao> getSelecoes() {
        ArrayList<Selecao> list = new ArrayList<>();

        for (int i = 0; i <= 7; i++) {
            ArrayList<Pontuacao> pontuacoes = this.pontuacao.setGroupId(i).build();
            list.add(pontuacoes.get(0).getSelecao());
            list.add(pontuacoes.get(1).getSelecao());
        }

        return list;
    }

    @Override
    @NotNull
    public Match getMatch(int matchNumber) {
        matchNumber = matchNumber % 8;
        int groupA = matchNumber;
        int groupB = (matchNumber % 2 == 0) ? groupA + 1 : groupA - 1;

        ArrayList<Pontuacao> selecoesA = this.pontuacao.setGroupId(groupA).build();
        ArrayList<Pontuacao> selecoesB = this.pontuacao.setGroupId(groupB).build();

        return this.campeonato.getMatch(selecoesA.get(0).getSelecao(), selecoesB.get(1).getSelecao());
    }
}
