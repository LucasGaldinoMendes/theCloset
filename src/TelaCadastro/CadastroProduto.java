
package TelaCadastro;

import Classes.Produto;
import TelaConsulta.ConsultaProduto;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas
 */
public class CadastroProduto extends javax.swing.JFrame {
    boolean edita = false;
    Produto objUpdate = new Produto();
    ConsultaProduto telaAnterior = new ConsultaProduto();
    /**
     * Creates new form CadastroProduto
     */
    public CadastroProduto() {
        initComponents();
    }
    public void update(Produto obj, ConsultaProduto tela){
        if (obj.getProdutoId() != 0) {
            objUpdate.setProdutoId(obj.getProdutoId());
            edita = true;
            telaAnterior = tela;
            JOptionPane.showMessageDialog(null, "teste id!" + obj.getProdutoId() );
            String precoC = objUpdate.searchPrecoC(obj.getProdutoId());
            txtDescricao.setText(obj.getDescricao());
            txtQtd.setText(String.valueOf(obj.getEstoque()));
            txtTamanho.setText(obj.getTamanho());
            txtValorCompra.setText(precoC);
            txtValorVenda.setText(String.valueOf(obj.getValorVenda()).replace(".",",")+"0");
            
        }
    }
    public void clear(){
        txtDescricao.setText("");
        txtQtd.setText("");
        txtTamanho.setText("");
        txtValorCompra.setText("");
        txtValorVenda.setText("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTamanho = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtQtd = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        txtValorCompra = new javax.swing.JFormattedTextField();
        btnSalvar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtValorVenda = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Cadastro de Produtos");

        jLabel2.setText("Produto:");

        jLabel3.setText("Tamanho:");

        jLabel4.setText("Quantidade: ");

        txtQtd.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));

        jLabel5.setText("Valor de compra:");

        txtValorCompra.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtValorCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtValorCompraKeyPressed(evt);
            }
        });

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/save.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        jLabel6.setText("Valor de venda:");

        txtValorVenda.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtValorVenda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtValorVendaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(205, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(214, 214, 214))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtValorCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtQtd)
                                .addComponent(txtValorVenda, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                                .addComponent(txtTamanho)))
                        .addGap(94, 94, 94)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(btnSalvar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtValorVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtValorCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(btnSalvar)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (edita) {
            objUpdate.setDescricao(txtDescricao.getText());
            objUpdate.setEstoque(Integer.parseInt(txtQtd.getText()));
            objUpdate.setTamanho(txtTamanho.getText());
            objUpdate.setValorCompra(Float.parseFloat(txtValorCompra.getText().replace(",", ".")));
            objUpdate.setValorVenda(Float.parseFloat(txtValorVenda.getText().replace(",", ".")));
            objUpdate.updateProduto(objUpdate);
            telaAnterior.atualizar();
            dispose();
        }else{
            Produto objProduto = new Produto();
            objProduto.setDescricao(txtDescricao.getText());
            objProduto.setEstoque(Integer.parseInt(txtQtd.getText()));
            objProduto.setTamanho(txtTamanho.getText());
            objProduto.setValorCompra(Float.parseFloat(txtValorCompra.getText().replace(",", ".")));
            objProduto.setValorVenda(Float.parseFloat(txtValorVenda.getText().replace(",", ".")));
            objProduto.addProduto(objProduto); 
            clear();
            txtDescricao.requestFocus();
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void txtValorCompraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorCompraKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            btnSalvar.doClick();
        }
    }//GEN-LAST:event_txtValorCompraKeyPressed

    private void txtValorVendaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorVendaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorVendaKeyPressed

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
            java.util.logging.Logger.getLogger(CadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JFormattedTextField txtQtd;
    private javax.swing.JTextField txtTamanho;
    private javax.swing.JFormattedTextField txtValorCompra;
    private javax.swing.JFormattedTextField txtValorVenda;
    // End of variables declaration//GEN-END:variables
}