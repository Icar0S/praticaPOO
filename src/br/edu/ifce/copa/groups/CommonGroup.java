package br.edu.ifce.copa.groups;

import br.edu.ifce.copa.Campeonato;
import br.edu.ifce.copa.Match;
import br.edu.ifce.copa.Selecao;

import java.util.ArrayList;
import java.util.Collections;

public class CommonGroup extends GroupManager {

    public static final int SELECOES_POR_GRUPO = 4;
    private static final int PARTIDAS_POR_GRUPO = 6;
    private int groupId;

    public CommonGroup(Campeonato campeonato, int groupId) {
        super(campeonato);
        this.groupId = groupId;
    }

    @Override
    public ArrayList<Selecao> getSelecoes() {
        ArrayList<Selecao> list = new ArrayList<>();
        int start = this.groupId * SELECOES_POR_GRUPO;
        int end = start + SELECOES_POR_GRUPO;
        for (int i = start; i < end; i++) {
            list.add(this.campeonato.getSelecoes().get(i));
        }
        Collections.sort(list);

        return list;
    }

    @Override
    public Match getMatch(int matchNumber) {
        ArrayList<Selecao> selecoes = this.campeonato.selecoesPorGrupo(groupId);
        int partida = matchNumber % PARTIDAS_POR_GRUPO;
        int a, b;

        switch (partida) {
            default:
            case 0:
                a = 0;
                b = 1;
                break;
            case 1:
                a = 2;
                b = 3;
                break;
            case 2:
                a = 0;
                b = 3;
                break;
            case 3:
                a = 1;
                b = 2;
                break;
            case 4:
                a = 1;
                b = 3;
                break;
            case 5:
                a = 0;
                b = 2;
                break;
        }

        Match m = this.campeonato.getMatch(selecoes.get(a), selecoes.get(b));
        if (m == null)
            return new Match(selecoes.get(a), selecoes.get(b));
        else
            return m;
    }
}
