
package br.edu.ifce.copa.views;

import br.edu.ifce.copa.Grupo;
import br.edu.ifce.copa.Pontuacao;
import br.edu.ifce.copa.Selecao;

import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.table.DefaultTableModel;

public class SimuladorWindow extends javax.swing.JFrame implements ISimuladorView {

    private final SimuladorPresenter presenter = new SimuladorPresenter(this);
    private DefaultTableModel tableModel;

    public SimuladorWindow() {
        initComponents();
        this.setTitle("Copa do Mundo 2018 - Simulador");

        this.presenter.initialize();
    }

    private void setupTable() {
        this.tableModel = new DefaultTableModel();
        this.selecoesTable.setModel(this.tableModel);
        this.tableModel.addColumn("Nome");
        this.tableModel.addColumn("Pontos");
        this.tableModel.addColumn("Jogos");
        this.tableModel.addColumn("Vitorias");
        this.tableModel.addColumn("Empates");
        this.tableModel.addColumn("Derrotas");
        this.tableModel.addColumn("Gols Pró");
        this.tableModel.addColumn("Saldo de Gols");
    }

    @Override
    public void exibirPontuacao(Collection<Pontuacao> pontuacoes) {
        this.clearData();

        for (Pontuacao p : pontuacoes) {
            this.tableModel.addRow(new Object[]{
                    p.getSelecao().getNome(),
                    p.getPontos(),
                    p.getJogos(),
                    p.getVitorias(),
                    p.getEmpates(),
                    p.getDerrotas(),
                    p.getGp(),
                    p.getSg()
            });
        }
    }

    @Override
    public void exibirSelecoes(Collection<Selecao> selecoes) {
        for (Selecao s : selecoes) {
            this.selecaoBComboBox.addItem(s.getNome());
            this.selecaoAComboBox.addItem(s.getNome());
        }
    }

    private void clearData() {
        this.selecaoBComboBox.removeAllItems();
        this.selecaoAComboBox.removeAllItems();
        this.setupTable();
    }

    @Override
    public void setGroups(ArrayList<Grupo> groups) {
        for (Grupo g : groups) {
            this.gruposComboBox.addItem(g.getName());
        }
    }

    @Override
    public void selectSelecaoA(int selecaoIdx) {
        this.selecaoAComboBox.setSelectedIndex(selecaoIdx);
    }

    @Override
    public void selectSelecaoB(int selecaoIdx) {
        this.selecaoBComboBox.setSelectedIndex(selecaoIdx);
    }

    @Override
    public void setGolsA(int golsA) {
        this.golsATextField.setText(String.valueOf(golsA));
    }

    @Override
    public void setGolsB(int golsB) {
        this.golsBTextField.setText(String.valueOf(golsB));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PainelGrupoA = new javax.swing.JPanel();
        gruposComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        selecoesTable = new javax.swing.JTable();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        golsATextField = new javax.swing.JTextField();
        selecaoBComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        golsBTextField = new javax.swing.JTextField();
        selecaoAComboBox = new javax.swing.JComboBox<>();
        nextButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        gruposComboBox.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        gruposComboBox.addItemListener(evt -> gruposComboBoxItemStateChanged(evt));

        selecoesTable.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        selecoesTable.setMinimumSize(new java.awt.Dimension(50, 60));
        jScrollPane1.setViewportView(selecoesTable);

        label1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        label1.setText("Simulador Copa 2018");

        label2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        label2.setText("Adicionar Jogo");

        golsATextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        golsATextField.setText("0");

        selecaoBComboBox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("x");

        golsBTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        golsBTextField.setText("0");

        selecaoAComboBox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        nextButton.setText("Próximo Jogo");
        nextButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nextButtonMouseClicked(evt);
            }
        });

        saveButton.setText("Salvar");
        saveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PainelGrupoALayout = new javax.swing.GroupLayout(PainelGrupoA);
        PainelGrupoA.setLayout(PainelGrupoALayout);
        PainelGrupoALayout.setHorizontalGroup(
                PainelGrupoALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PainelGrupoALayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(PainelGrupoALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1)
                                        .addGroup(PainelGrupoALayout.createSequentialGroup()
                                                .addGroup(PainelGrupoALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(PainelGrupoALayout.createSequentialGroup()
                                                                .addComponent(gruposComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(24, 24, 24)
                                                                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(PainelGrupoALayout.createSequentialGroup()
                                                                .addGroup(PainelGrupoALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(selecaoAComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(golsATextField, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jLabel1)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(golsBTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(selecaoBComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(PainelGrupoALayout.createSequentialGroup()
                                                                .addComponent(nextButton)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(saveButton)))
                                                .addGap(0, 272, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        PainelGrupoALayout.setVerticalGroup(
                PainelGrupoALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PainelGrupoALayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(PainelGrupoALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(gruposComboBox, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                                        .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PainelGrupoALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(selecaoBComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(golsATextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1)
                                        .addComponent(golsBTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(selecaoAComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PainelGrupoALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(nextButton)
                                        .addComponent(saveButton))
                                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(PainelGrupoA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(PainelGrupoA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        pack();
    }

    private void saveButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveButtonMouseClicked
        this.presenter.onMatchSaved(
                this.selecaoAComboBox.getSelectedIndex(),
                this.selecaoBComboBox.getSelectedIndex(),
                Integer.parseInt(golsATextField.getText()),
                Integer.parseInt(golsBTextField.getText())
        );
    }

    private void nextButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextButtonMouseClicked
        this.presenter.onNextMatch(
                this.selecaoAComboBox.getSelectedIndex(),
                this.selecaoBComboBox.getSelectedIndex(),
                Integer.parseInt(golsATextField.getText()),
                Integer.parseInt(golsBTextField.getText())
        );
    }

    private void gruposComboBoxItemStateChanged(ItemEvent evt) {
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            this.presenter.onGroupSelected(this.gruposComboBox.getSelectedIndex());
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PainelGrupoA;
    private javax.swing.JComboBox<String> gruposComboBox;
    private javax.swing.JComboBox<String> selecaoBComboBox;
    private javax.swing.JComboBox<String> selecaoAComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField golsATextField;
    private javax.swing.JTextField golsBTextField;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private javax.swing.JButton nextButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JTable selecoesTable;
    // End of variables declaration//GEN-END:variables

}
