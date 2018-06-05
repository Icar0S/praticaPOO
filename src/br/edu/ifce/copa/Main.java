package br.edu.ifce.copa;

import br.edu.ifce.copa.views.SimuladorWindow;

public class Main {

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new SimuladorWindow().setVisible(true));
    }
}
