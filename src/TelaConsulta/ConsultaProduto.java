
package TelaConsulta;

import Classes.Produto;
import TelaCadastro.CadastroCompra;
import TelaCadastro.CadastroProduto;
import TelaCadastro.CadastroVenda;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

public class ConsultaProduto extends javax.swing.JFrame {


    CadastroVenda telaVenda = new CadastroVenda();
    CadastroCompra telaCompra = new CadastroCompra();
    boolean compra = false;
    
    public ConsultaProduto() {
        initComponents();
        btnConfirmar.setVisible(false);
        gridProduto.getColumnModel().getColumn(0).setPreferredWidth(30);
    }
    public String verificarFiltro(){
        String filtroSQL = "";
        if (cbFiltro.getSelectedItem().toString() == "Código") {
            filtroSQL =  "codigo";
        }else if (cbFiltro.getSelectedItem().toString() == "Descrição") {
            filtroSQL = "descricao";
        }else{
            filtroSQL = cbFiltro.getSelectedItem().toString();
        }
        return filtroSQL;
    }
    public void addVenda(CadastroVenda obj){
        btnEditar.setVisible(false);
        btnExcluir.setVisible(false);
        btnConfirmar.setVisible(true);
        telaVenda = obj;
    }
        public void addCompra(CadastroCompra obj){
        btnEditar.setVisible(false);
        btnExcluir.setVisible(false);
        btnConfirmar.setVisible(true);
        telaCompra = obj;
        compra = true;
    }
    public void atualizar(){
        btnPesquisar.doClick();
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
        txtPesquisa = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        cbFiltro = new javax.swing.JComboBox<>();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        gridProduto = new javax.swing.JTable();
        btnConfirmar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Consulta Produtos");

        txtPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPesquisaKeyPressed(evt);
            }
        });

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/search.png"))); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        cbFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Código", "Descrição", "Tamanho", "Valor", "Quantidade" }));
        cbFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFiltroActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/editar-codigo.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/trash.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        gridProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod", "Descricao", "Tamanho", "Valor", "Quantidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(gridProduto);

        btnConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/confirm.png"))); // NOI18N
        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(btnPesquisar))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(btnEditar)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnExcluir)
                                    .addGap(57, 57, 57)
                                    .addComponent(btnConfirmar))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar)
                    .addComponent(cbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar)
                    .addComponent(btnExcluir)
                    .addComponent(btnConfirmar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            btnPesquisar.doClick();
        }
    }//GEN-LAST:event_txtPesquisaKeyPressed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        String filtro = verificarFiltro();
        String pesquisa = txtPesquisa.getText();
        Produto objProduto = new Produto();
        objProduto.searchProduto(gridProduto, filtro, pesquisa, compra);
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int qtdLinhas = gridProduto.getSelectedRowCount();

        if(qtdLinhas < 1){
            JOptionPane.showMessageDialog(null, "Selecione uma linha para realizar essa operação","Aviso",JOptionPane.INFORMATION_MESSAGE);
        }else if (qtdLinhas == 1){
            int linhaSel = gridProduto.getSelectedRow();

            Produto objUpdate = new Produto ();
            objUpdate.setProdutoId(Integer.parseInt(gridProduto.getValueAt(linhaSel,0).toString()));
            objUpdate.setDescricao(gridProduto.getValueAt(linhaSel,1).toString());
            objUpdate.setTamanho(gridProduto.getValueAt(linhaSel,2).toString());
            objUpdate.setValorVenda(Float.parseFloat(gridProduto.getValueAt(linhaSel,3).toString().replace(",",".")));
            objUpdate.setEstoque(Integer.parseInt(gridProduto.getValueAt(linhaSel,4).toString()));

            CadastroProduto objCadProd = new CadastroProduto ();
            objCadProd.update(objUpdate, this);
            objCadProd.setVisible(true);
        }else {
            JOptionPane.showMessageDialog(null, "Selecione apenas uma linha para realizar essa operação","Aviso",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int qtdLinhas = gridProduto.getSelectedRowCount();

        if(qtdLinhas < 1){
            JOptionPane.showMessageDialog(null, "Selecione uma linha para realizar essa operação");
        }else if (qtdLinhas == 1){
            int linhaSel = gridProduto.getSelectedRow();
            Produto objDel = new Produto ();
            objDel.setProdutoId(Integer.parseInt(gridProduto.getValueAt(linhaSel,0).toString()));
            objDel.delProduto(objDel);
            btnPesquisarActionPerformed(evt);
        }else {
            int [] linhaSel = gridProduto.getSelectedRows();
            Object[] options = { "Confirmar", "Cancelar" };
            int resposta = JOptionPane.showOptionDialog(null, "Você selecionou mais de um vendedor. Deseja continuar", "Aviso", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (resposta == 0){
                Produto objDel[] = new Produto[qtdLinhas];
                String teste;
                for (int i = 0; i < qtdLinhas; i++) {
                    objDel[i] = new Produto();
                    objDel[i].setProdutoId(Integer.parseInt(gridProduto.getValueAt(linhaSel[i],0).toString()));
                    /*  teste = gridVendedor.getValueAt(linhaSel[i],0).toString();
                    JOptionPane.showMessageDialog(null, "linhaSel- " + linhaSel[i]+ " pessoa id - " + teste);*/
                    objDel[i].delProduto(objDel[i]);
                }
            }
            btnPesquisarActionPerformed(evt);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void cbFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbFiltroActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        int qtdLinhas = gridProduto.getSelectedRowCount();

        if(qtdLinhas < 1){
            JOptionPane.showMessageDialog(null, "Selecione uma linha para realizar essa operação");
        }else if (qtdLinhas == 1){
            int linhaSel = gridProduto.getSelectedRow();
            Produto obj = new Produto ();
            obj.setProdutoId(Integer.parseInt(gridProduto.getValueAt(linhaSel,0).toString()));
            obj.setDescricao(gridProduto.getValueAt(linhaSel,1).toString());
            obj.setTamanho(gridProduto.getValueAt(linhaSel, 2).toString());            
            obj.setEstoque(Integer.parseInt(gridProduto.getValueAt(linhaSel, 4).toString()));
            
            if (compra) {
               obj.setValorCompra(Float.parseFloat(gridProduto.getValueAt(linhaSel, 3).toString().replace(",",".")));
               telaCompra.addProd(obj); 
            }else{
               obj.setValorVenda(Float.parseFloat(gridProduto.getValueAt(linhaSel, 3).toString().replace(",",".")));
               telaVenda.addProd(obj); 
            }
            
            dispose();
           
        }else {
            JOptionPane.showMessageDialog(null, "Selecione uma linha para realizar essa operação");
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JComboBox<String> cbFiltro;
    private javax.swing.JTable gridProduto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables
}