package br.edu.ifce.copa.groups;

import br.edu.ifce.copa.Campeonato;
import br.edu.ifce.copa.Match;
import br.edu.ifce.copa.Selecao;

import java.util.ArrayList;

public class QuartasManager extends GroupManager {

    public QuartasManager(Campeonato campeonato) {
        super(campeonato);

    }

    @Override
    public ArrayList<Selecao> getSelecoes() {
        return null;
    }

    @Override
    public Match getMatch(int matchNumber) {
        return null;
    }
}
