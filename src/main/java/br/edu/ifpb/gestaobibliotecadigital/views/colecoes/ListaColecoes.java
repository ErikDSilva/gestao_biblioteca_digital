package br.edu.ifpb.gestaobibliotecadigital.views.colecoes;

import br.edu.ifpb.gestaobibliotecadigital.models.livros.Colecao;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.LivroBase;
import br.edu.ifpb.gestaobibliotecadigital.services.impl.ColecaoService;
import javax.swing.JOptionPane;

public class ListaColecoes extends javax.swing.JFrame {

    private final ColecaoService service = new ColecaoService();
    private Colecao colecao;
    private LivroBase livro;

    public ListaColecoes() {
        initComponents();

        tabelaColecao1.setDados(service.listarColecoes());
    }

    private void setTabelaLivros(Colecao colecaoSelecionadaLivros) {
        tabelaSelecionadaColecao1.setDados(service.listarLivrosDeColecao(colecaoSelecionadaLivros));
    }

    private void onItemDestacadoColcoes(Colecao colecaoLivros) {
        setTabelaLivros(colecaoLivros);
        acoesColecao1.setColecao(colecao, livro);
        aoDestacarColecao(colecao);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new javax.swing.JLabel();
        pesquisarPanel1 = new br.edu.ifpb.gestaobibliotecadigital.views.components.PesquisarPanel();
        usuarioPanel1 = new br.edu.ifpb.gestaobibliotecadigital.views.components.UsuarioPanel();
        titulo1 = new javax.swing.JLabel();
        tabelaColecao1 = new br.edu.ifpb.gestaobibliotecadigital.views.colecoes.TabelaColecao();
        tabelaSelecionadaColecao1 = new br.edu.ifpb.gestaobibliotecadigital.views.colecoes.TabelaSelecionadaColecao();
        acoesColecao1 = new br.edu.ifpb.gestaobibliotecadigital.views.colecoes.AcoesColecao();
        removerColecao = new javax.swing.JButton();

        titulo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        titulo.setText("Nova Coleção");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lista de coleções");
        setMinimumSize(new java.awt.Dimension(800, 720));

        titulo1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        titulo1.setText("Lista de Coleção");

        tabelaColecao1 = new br.edu.ifpb.gestaobibliotecadigital.views.colecoes.TabelaColecao(){
            @Override
            protected void onItemDestacado(Colecao item) {
                onItemDestacadoColcoes(item);
            }
        };

        tabelaSelecionadaColecao1 = new br.edu.ifpb.gestaobibliotecadigital.views.colecoes.TabelaSelecionadaColecao(){
            @Override
            protected void onItemDestacado(LivroBase item) {
                onItemDestacadoLivro(item);
            };
        };

        removerColecao.setText("Remover");
        removerColecao.setToolTipText("Remover uma coleção");
        removerColecao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerColecaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(titulo1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(usuarioPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pesquisarPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tabelaColecao1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tabelaSelecionadaColecao1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(removerColecao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(acoesColecao1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usuarioPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titulo1))
                .addGap(44, 44, 44)
                .addComponent(pesquisarPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tabelaSelecionadaColecao1, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                    .addComponent(tabelaColecao1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(acoesColecao1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removerColecao))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void aoDestacarColecao(Colecao colecao) {
        this.colecao = colecao;

    }

    public void onItemDestacadoLivro(LivroBase livro) {
        this.livro = livro;
    }

    private void removerColecaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerColecaoActionPerformed
        try {
            service.remover(colecao);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage(),
                    "Erro ao sakvar coleção",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_removerColecaoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListaColecoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaColecoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaColecoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaColecoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaColecoes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.edu.ifpb.gestaobibliotecadigital.views.colecoes.AcoesColecao acoesColecao1;
    private br.edu.ifpb.gestaobibliotecadigital.views.components.PesquisarPanel pesquisarPanel1;
    private javax.swing.JButton removerColecao;
    private br.edu.ifpb.gestaobibliotecadigital.views.colecoes.TabelaColecao tabelaColecao1;
    private br.edu.ifpb.gestaobibliotecadigital.views.colecoes.TabelaSelecionadaColecao tabelaSelecionadaColecao1;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel titulo1;
    private br.edu.ifpb.gestaobibliotecadigital.views.components.UsuarioPanel usuarioPanel1;
    // End of variables declaration//GEN-END:variables
}
