package br.edu.ifce.copa.groups;

import br.edu.ifce.copa.Campeonato;
import br.edu.ifce.copa.Match;
import br.edu.ifce.copa.PontuacaoBuilder;
import br.edu.ifce.copa.Selecao;
import com.sun.istack.internal.NotNull;

import java.util.ArrayList;

abstract public class GroupManager {

    protected Campeonato campeonato;
    protected PontuacaoBuilder pontuacao;

    public GroupManager(Campeonato campeonato) {
        this.campeonato = campeonato;
        this.pontuacao = new PontuacaoBuilder(campeonato);
    }

    @NotNull
    public abstract ArrayList<Selecao> getSelecoes();

    @NotNull
    public abstract Match getMatch(int matchNumber);
}
