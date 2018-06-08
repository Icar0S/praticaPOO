
package br.edu.ifce.copa;

import br.edu.ifce.copa.groups.CommonGroup;
import br.edu.ifce.copa.groups.GroupManager;
import br.edu.ifce.copa.groups.OitavasManager;
import com.sun.org.apache.bcel.internal.generic.Select;
import javafx.print.Collation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

/**
 * @author ikrov
 */
public class Campeonato {

    private final ArrayList<Selecao> selecoes;
    private final ArrayList<Grupo> grupos;
    private final ArrayList<Match> partidas;
    private final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

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
    }

    private void addSelecao(String selecao) {
        int group = this.selecoes.size() / CommonGroup.SELECOES_POR_GRUPO;
        if (this.selecoes.size() % CommonGroup.SELECOES_POR_GRUPO == 0) {
            char letter = this.alphabet.charAt(group);
            this.grupos.add(new Grupo(String.format("Grupo %s", letter)));
        }

        Selecao sel = new Selecao(selecao);
        this.selecoes.add(sel);
    }

    private GroupManager getManager(int groupId) {
        if (groupId == 8)
            return new OitavasManager(this);
        else
            return new CommonGroup(this, groupId);
    }

    public ArrayList<Selecao> selecoesPorGrupo(int grupoId) {
        return this.getManager(grupoId).getSelecoes();
    }

    public ArrayList<Grupo> getGrupos() {
        return this.grupos;
    }

    /*public void addRandomMatch() {
        int a = Math.abs(new Random().nextInt() % this.selecoes.size());
        int b = Math.abs((new Random().nextInt() +1) % this.selecoes.size());
        int golsA = Math.abs(new Random().nextInt() % 4);
        int golsB = Math.abs(new Random().nextInt() % 4);
        Selecao selA = this.selecoes.get(a);
        Selecao selB = this.selecoes.get(b);
        
        this.addMatch(selA, selB, golsA, golsB);
    }*/

    public Match getMatch(int groupId, int matchNumber) {
        return this.getManager(groupId).getMatch(matchNumber);
    }

    public Match getMatch(Selecao a, Selecao b) {
        for (Match m : this.partidas) {
            if ((m.getA().equals(a) && m.getB().equals(b)) || (m.getA().equals(b) && m.getB().equals(a)))
                return m;
        }

        return null;
    }

    public void addMatch(Selecao a, Selecao b, int golsA, int golsB) {
        Match match = this.getMatch(a, b);
        if (match == null) {
            match = new Match(a, b);
            this.partidas.add(match);
        }

        match.setGolsA(golsA);
        match.setGolsB(golsB);
    }

    public ArrayList<Match> getMatches() {
        return this.partidas;
    }

    public ArrayList<Selecao> getSelecoes() {
        return this.selecoes;
    }
}
