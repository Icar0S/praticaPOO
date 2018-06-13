
package br.edu.ifce.copa;

import br.edu.ifce.copa.groups.CommonGroup;
import br.edu.ifce.copa.groups.GroupManager;
import br.edu.ifce.copa.groups.OitavasManager;
import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import java.util.ArrayList;
//import java.util.Random;

/**
 * @author ikrov
 */
public class Campeonato {

    public static final int OITAVAS_GROUP_ID = 8;
    private final ArrayList<Selecao> selecoes;
    private final ArrayList<Grupo> grupos;
    private final ArrayList<Match> partidas;

    public Campeonato() {
        this.selecoes = new ArrayList<>();
        this.grupos = new ArrayList<>();
        this.partidas = new ArrayList<>();

        carregar();
    }

    private void carregar() {
        addSelecao("Russia");
        addSelecao("Arábia Saudita");
        addSelecao("Egito");
        addSelecao("Uruguai");

        addSelecao("Espanha");
        addSelecao("Portugal");
        addSelecao("Marrocos");
        addSelecao("Irã");

        addSelecao("França");
        addSelecao("Autrália");
        addSelecao("Peru");
        addSelecao("Dinamarca");

        addSelecao("Argentina");
        addSelecao("Islândia");
        addSelecao("Croácia");
        addSelecao("Nigéria");

        addSelecao("Brasil");
        addSelecao("Costa Rica");
        addSelecao("Sérvia");
        addSelecao("Suíça");

        addSelecao("Alemanha");
        addSelecao("Coreia do Sul");
        addSelecao("México");
        addSelecao("Suécia");

        addSelecao("Bélgica");
        addSelecao("Inglaterra");
        addSelecao("Panamá");
        addSelecao("Tunísia");

        addSelecao("Colômbia");
        addSelecao("Japão");
        addSelecao("Polônia");
        addSelecao("Senegal");

        this.grupos.add(new Grupo("Oitavas"));
        this.grupos.add(new Grupo("Quartas"));
        this.grupos.add(new Grupo("Semis"));
        this.grupos.add(new Grupo("Final"));

        /*for (int i = 0; i < 20; i++) {
            this.addRandomMatch();
        }*/
    }

    private void addSelecao(String selecao) {
        int group = this.selecoes.size() / CommonGroup.SELECOES_POR_GRUPO;
        if (this.selecoes.size() % CommonGroup.SELECOES_POR_GRUPO == 0) {
            String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            char letter = alphabet.charAt(group);
            this.grupos.add(new Grupo(String.format("Grupo %s", letter)));
        }

        Selecao sel = new Selecao(selecao);
        this.selecoes.add(sel);
    }

    private GroupManager getManager(int groupId) {
        if (groupId == OITAVAS_GROUP_ID)
            return new OitavasManager(this);
        else
            return new CommonGroup(this, groupId);
    }

    public ArrayList<Selecao> getSelecoes(int groupId) {
        return this.getManager(groupId).getSelecoes();
    }

    public ArrayList<Selecao> getSelecoes() {
        return this.selecoes;
    }

    public ArrayList<Grupo> getGrupos() {
        return this.grupos;
    }


    /*public void addRandomMatch() {
        int a = Math.abs(new Random().nextInt() % this.selecoes.size());
        int b = Math.abs((new Random().nextInt() + 1) % this.selecoes.size());
        int golsA = Math.abs(new Random().nextInt() % 4);
        int golsB = Math.abs(new Random().nextInt() % 4);
        Selecao selA = this.selecoes.get(a);
        Selecao selB = this.selecoes.get(b);

        this.setMatchGols(selA, selB, golsA, golsB, true);
    }*/

    @NotNull
    public Match getGroupMatch(int groupId, int matchNumber) {
        return this.getManager(groupId).getMatch(matchNumber);
    }

    @NotNull
    public Match getMatch(Selecao a, Selecao b) {
        Match match = this.findMatch(a, b);
        if (match == null) {
            match = new Match(a, b);
            this.partidas.add(match);
        }

        return match;
    }

    @Nullable
    public Match findMatch(Selecao a, Selecao b) {
        for (Match m : this.partidas) {
            if ((m.getA().equals(a) && m.getB().equals(b)) || (m.getA().equals(b) && m.getB().equals(a)))
                return m;
        }

        return null;
    }

    public void setMatchGols(Selecao a, Selecao b, int golsA, int golsB, boolean score) {
        Match match = this.getMatch(a, b);
        match.setGolsA(golsA);
        match.setGolsB(golsB);
        match.setScore(score);
    }

    public ArrayList<Match> getMatches() {
        return this.partidas;
    }
}
