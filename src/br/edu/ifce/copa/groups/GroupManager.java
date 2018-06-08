package br.edu.ifce.copa.groups;

import br.edu.ifce.copa.Campeonato;
import br.edu.ifce.copa.Match;
import br.edu.ifce.copa.Selecao;

import java.util.ArrayList;

abstract public class GroupManager {

    protected Campeonato campeonato;

    public GroupManager(Campeonato campeonato) {
        this.campeonato = campeonato;
    }

    public abstract ArrayList<Selecao> getSelecoes();

    public abstract Match getMatch(int matchNumber);
}
