package br.edu.ifpb.gestaobibliotecadigital.views.colecoes;

import br.edu.ifpb.gestaobibliotecadigital.models.livros.Colecao;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.LivroBase;
import br.edu.ifpb.gestaobibliotecadigital.services.impl.ColecaoService;
import br.edu.ifpb.gestaobibliotecadigital.views.components.UpdateObserver;
import javax.swing.JOptionPane;

public class AcoesColecao extends javax.swing.JPanel {

    public final UpdateObserver events = new UpdateObserver();
    private final ColecaoService colecaoService = new ColecaoService();

    private Colecao colecao;
    private LivroBase livro;

    public AcoesColecao() {
        initComponents();
    }

    public void setColecao(Colecao colecao, LivroBase livro) {
        this.colecao = colecao;
        this.livro = livro;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        atualizar = new javax.swing.JButton();
        adicionar = new javax.swing.JButton();
        remover = new javax.swing.JButton();

        atualizar.setText("Atualizar");
        atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarActionPerformed(evt);
            }
        });

        adicionar.setText("Adicionar");
        adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarActionPerformed(evt);
            }
        });

        remover.setText("Remover");
        remover.setEnabled(false);
        remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(atualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(adicionar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(remover)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adicionar)
                    .addComponent(remover)
                    .addComponent(atualizar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarActionPerformed
        events.emit();
    }//GEN-LAST:event_atualizarActionPerformed

  
    private void removerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerActionPerformed
        try {
            colecaoService.removerDaColecao(colecao, livro);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage(),
                    "Erro ao sakvar coleção",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_removerActionPerformed

    private void adicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarActionPerformed
        CriarColecao criarReservaDialog = new CriarColecao(null, true);
        criarReservaDialog.setVisible(true);
        events.emit();
    }//GEN-LAST:event_adicionarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adicionar;
    private javax.swing.JButton atualizar;
    private javax.swing.JButton remover;
    // End of variables declaration//GEN-END:variables
}
