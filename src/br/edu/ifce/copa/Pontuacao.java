package br.edu.ifce.copa;

public class Pontuacao implements Comparable<Pontuacao> {

    private Selecao selecao;
    private int pontos, jogos, vitorias, empates, derrotas, gp, gc;

    private static final int PONTOS_POR_VITORIA = 3;
    private static final int PONTOS_POR_EMPATE = 1;

    public Pontuacao(Selecao selecao) {
        this.selecao = selecao;
    }

    public Selecao getSelecao() {
        return selecao;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public int getJogos() {
        return jogos;
    }

    public void setJogos(int jogos) {
        this.jogos = jogos;
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    public int getEmpates() {
        return empates;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public int getGp() {
        return gp;
    }

    public void setGp(int gp) {
        this.gp = gp;
    }

    public int getGc() {
        return gc;
    }

    public void setGc(int gc) {
        this.gc = gc;
    }

    public int getSg() {
        return this.getGp() - this.getGc();
    }

    public void addVitoria(int golsPro, int golsCon) {
        this.vitorias++;
        this.jogos++;
        this.pontos += PONTOS_POR_VITORIA;
        this.gp += golsPro;
        this.gc += golsCon;
    }

    public void addDerrota(int golsPro, int golsCon) {
        this.derrotas++;
        this.jogos++;
        this.gp += golsPro;
        this.gc += golsCon;
    }

    public void addEmpate(int golsA, int golsB) {
        this.empates++;
        this.pontos += PONTOS_POR_EMPATE;
        this.jogos++;
        this.gp += golsA;
        this.gc += golsB;
    }

    @Override
    public int compareTo(Pontuacao pontuacao) {
        int compare = pontuacao.getPontos() - this.getPontos();

        if (compare == 0)
            compare = pontuacao.getVitorias() - this.getVitorias();

        if (compare == 0)
            compare = pontuacao.getSg() - this.getSg();

        if(compare == 0)
            compare = pontuacao.getGp() - this.getGp();

        if(compare == 0)
            compare = this.getGc() - pontuacao.getGc();
        return compare;
    }

    public boolean equals(Pontuacao o) {
        return o.getSelecao().equals(this.getSelecao());
    }
}
