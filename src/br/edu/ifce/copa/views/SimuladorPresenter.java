package br.edu.ifce.copa.views;

import br.edu.ifce.copa.Campeonato;
import br.edu.ifce.copa.Match;
import br.edu.ifce.copa.PontuacaoBuilder;
import br.edu.ifce.copa.Selecao;

import java.util.ArrayList;

/**
 * @author ikrov
 */
public class SimuladorPresenter {

    private final ISimuladorView view;
    private final Campeonato campeonato;
    private int match;
    private int selectedGroupId;

    public SimuladorPresenter(ISimuladorView view) {
        this.view = view;
        this.campeonato = new Campeonato();
    }

    public void initialize() {
        this.view.setGroups(this.campeonato.getGrupos());
        this.setSelectedGroupId(0);
    }

    public void setSelectedGroupId(int selectedGroupId) {
        this.selectedGroupId = selectedGroupId;
        this.showPontuacao();
        this.setMatch(0);
    }

    public void setMatch(int match) {
        this.match = match;
        Match m = this.campeonato.getGroupMatch(this.selectedGroupId, match);
        this.view.setGolsA(m.getGolsA());
        this.view.setGolsB(m.getGolsB());

        ArrayList<Selecao> selecoes = this.getSelecoes();
        this.view.selectSelecaoA(selecoes.indexOf(m.getA()));
        this.view.selectSelecaoB(selecoes.indexOf(m.getB()));
    }

    private void showPontuacao() {
        this.view.exibirPontuacao(
                new PontuacaoBuilder(this.campeonato)
                        .setGroupId(this.selectedGroupId)
                        .build()
        );
        this.view.exibirSelecoes(this.getSelecoes());
    }

    private ArrayList<Selecao> getSelecoes() {
        return this.campeonato.getSelecoes(this.selectedGroupId);
    }

    public void onGroupSelected(int groupId) {
        this.setSelectedGroupId(groupId);
    }

    public void onMatchSaved(int selecaoAIdx, int selecaoBIdx, int golsA, int golsB) {
        if (selecaoAIdx == selecaoBIdx)
            return;

        ArrayList<Selecao> selecoes = this.getSelecoes();
        this.campeonato.setMatchGols(selecoes.get(selecaoAIdx), selecoes.get(selecaoBIdx), golsA, golsB, this.shouldScore());
        this.showPontuacao();
    }

    private boolean shouldScore() {
        return selectedGroupId != Campeonato.OITAVAS_GROUP_ID;
    }

    public void onNextMatch(int selecaoAIdx, int selecaoBIdx, int golsA, int golsB) {
        this.onMatchSaved(selecaoAIdx, selecaoBIdx, golsA, golsB);
        this.setMatch(this.match + 1);
    }

}
