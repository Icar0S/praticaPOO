
package br.edu.ifce.copa;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author ikrov
 */
public class Campeonato {

    private static final int PARTIDAS_POR_GRUPO = 6;
    private final ArrayList<Selecao> selecoes;
    private final ArrayList<Grupo> grupos;
    private final ArrayList<Match> partidas;
    private final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int SELECOES_POR_GRUPO = 4;

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
    }
    
    public Selecao addSelecao(String selecao) {
        int group = this.selecoes.size() / SELECOES_POR_GRUPO;
        if (this.selecoes.size() % SELECOES_POR_GRUPO == 0) {
            char letter = this.alphabet.charAt(group);
            this.grupos.add(new Grupo(String.format("Grupo %s", letter)));
        }
        
        Selecao sel = new Selecao(selecao);
        this.selecoes.add(sel);
        
        return sel;
    }    
    
    public ArrayList<Selecao> selecoesPorGrupo(int grupoId) {
        ArrayList<Selecao> list = new ArrayList<>();
        int start = grupoId * SELECOES_POR_GRUPO;
        int end = start + SELECOES_POR_GRUPO;
        for (int i = start; i < end; i++) {
            list.add(this.selecoes.get(i));
        }
        
        return list;
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
        ArrayList<Selecao> selecoes = this.selecoesPorGrupo(groupId);
        int partida = matchNumber % PARTIDAS_POR_GRUPO;

        int a, b;
        
        switch (partida) {
            default:
            case 0:
                a = 0; b = 1; break;
            case 1:
                a = 0; b = 2; break;
            case 2:
                a = 0; b = 3; break;

            case 4:
                a = 1; b = 2; break;
            case 5:
                a = 2; b =3; break;
        }

        Match m = this.getMatch(selecoes.get(a), selecoes.get(b));
        if (m == null)
            return new Match(a,b);
        else
            return m;
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
}
