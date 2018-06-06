package br.edu.ifce.copa;


public class Selecao implements Comparable<Selecao>{

    private final String nome;

    public Selecao(String nome) {
        this.nome = nome;
    }
    
    public String getNome() {
        return nome;
    }

    @Override
    public int compareTo(Selecao selecao) {
        return this.getNome().compareTo(selecao.getNome());
    }

    public boolean equals(Selecao o) {
        return o.getNome().equals(this.getNome());
    }
}