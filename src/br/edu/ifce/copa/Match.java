/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifce.copa;

/**
 *
 * @author ikrov
 */
public class Match {
    private Selecao a, b;
    private int golsA, golsB;
    private boolean score;
    
    public Match(Selecao a, Selecao b) {
        this.a = a;
        this.b = b;
    }

    public Match(Selecao a, Selecao b, int golsA, int golsB) {
        this.a = a;
        this.b = b;
        this.golsA = golsA;
        this.golsB = golsB;
    }

    public boolean isScore() {
        return score;
    }

    public Selecao getA() {return a; }

    public Selecao getB() {
        return b;
    }

    public int getGolsA() {
        return golsA;
    }

    public int getGolsB() {
        return golsB;
    }

    public void setA(Selecao a) {
        this.a = a;
    }

    public void setB(Selecao b) {
        this.b = b;
    }

    public void setGolsA(int golsA) {
        this.golsA = golsA;
    }

    public void setGolsB(int golsB) {
        this.golsB = golsB;
    }

    public void setScore(boolean oitavas) {
        this.score = oitavas;
    }
}
