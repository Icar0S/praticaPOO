package br.edu.ifce.copa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class PontuacaoBuilder {

    private Campeonato campeonato;
    private int groupId;

    public PontuacaoBuilder(Campeonato campeonato) {
        this.campeonato = campeonato;
    }

    public PontuacaoBuilder setGroupId(int groupId) {
        this.groupId = groupId;
        return this;
    }

    public ArrayList<Pontuacao> build() {
        ArrayList<Selecao> selecoes = this.campeonato.selecoesPorGrupo(this.groupId);
        HashMap<Selecao, Pontuacao> pontuacoes = new HashMap<>(selecoes.size());

        for (Selecao s : this.campeonato.getSelecoes()) {
            pontuacoes.put(s, new Pontuacao(s));
        }

        for (Match m : this.campeonato.getMatches()) {
            Pontuacao a = pontuacoes.get(m.getA());
            Pontuacao b = pontuacoes.get(m.getB());
            this.givePoints(a, b, m);
        }

        ArrayList<Pontuacao> list = new ArrayList<>(selecoes.size());
        for (Pontuacao p: pontuacoes.values()) {
            if (selecoes.contains(p.getSelecao()))
                list.add(p);
        }

        Collections.sort(list);

        return list;
    }

    private void givePoints(Pontuacao a, Pontuacao b, Match m) {
        if (m.getGolsA() > m.getGolsB()) {
            a.addVitoria(m.getGolsA(), m.getGolsB());
            b.addDerrota(m.getGolsB(), m.getGolsA());
        } else if ((m.getGolsA() < m.getGolsB()) ) {
            a.addDerrota(m.getGolsA(), m.getGolsB());
            b.addVitoria(m.getGolsB(), m.getGolsA());
        } else {
            a.addEmpate(m.getGolsA(), m.getGolsB());
            b.addEmpate(m.getGolsB(), m.getGolsA());
        }
    }
}
