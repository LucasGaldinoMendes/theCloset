
package Tela;

import Classes.Vendedor;
import TelaCadastro.CadastroCompra;
import TelaCadastro.CadastroFornecedor;
import TelaCadastro.CadastroVendedor;
import TelaCadastro.CadastroProduto;
import TelaCadastro.CadastroVenda;
import TelaConsulta.CompraMes;
import TelaConsulta.ConsultaCompra;
import TelaConsulta.ConsultaFornecedor;
import TelaConsulta.ConsultaVendedor;
import TelaConsulta.ConsultaProduto;
import TelaConsulta.ConsultaVenda;
import TelaConsulta.VendaMes;

/**
 *
 * @author Lucas
 */
public class TelaInicio extends javax.swing.JFrame {

    /**
     * Creates new form TelaInicio
     */
    
    
    public TelaInicio() {
        initComponents();
        
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
        jMenuBar1 = new javax.swing.JMenuBar();
        btnCadCompras = new javax.swing.JMenu();
        btnCadCompra = new javax.swing.JMenuItem();
        btnCadFornecedores = new javax.swing.JMenuItem();
        btnCadProdutos = new javax.swing.JMenuItem();
        btnCadVendas = new javax.swing.JMenuItem();
        btnCadFuncionarios = new javax.swing.JMenuItem();
        btnC = new javax.swing.JMenu();
        btnConCompras = new javax.swing.JMenuItem();
        btnConFornecedor = new javax.swing.JMenuItem();
        btnConProd = new javax.swing.JMenuItem();
        btnConVendas = new javax.swing.JMenuItem();
        btnConFuncionarios = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setForeground(java.awt.Color.black);
        setMinimumSize(getMaximumSize());

        jLabel1.setText("The Closet");

        btnCadCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/cadastro.png"))); // NOI18N
        btnCadCompras.setText("Cadastro");

        btnCadCompra.setText("Compras");
        btnCadCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadCompraActionPerformed(evt);
            }
        });
        btnCadCompras.add(btnCadCompra);

        btnCadFornecedores.setText("Fornecedores");
        btnCadFornecedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadFornecedoresActionPerformed(evt);
            }
        });
        btnCadCompras.add(btnCadFornecedores);

        btnCadProdutos.setText("Produtos");
        btnCadProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadProdutosActionPerformed(evt);
            }
        });
        btnCadCompras.add(btnCadProdutos);

        btnCadVendas.setText("Vendas");
        btnCadVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadVendasActionPerformed(evt);
            }
        });
        btnCadCompras.add(btnCadVendas);

        btnCadFuncionarios.setText("Vendedores");
        btnCadFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadFuncionariosActionPerformed(evt);
            }
        });
        btnCadCompras.add(btnCadFuncionarios);

        jMenuBar1.add(btnCadCompras);

        btnC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/find.png"))); // NOI18N
        btnC.setText("Consulta");

        btnConCompras.setText("Compras");
        btnConCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConComprasActionPerformed(evt);
            }
        });
        btnC.add(btnConCompras);

        btnConFornecedor.setText("Fornecedores");
        btnConFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConFornecedorActionPerformed(evt);
            }
        });
        btnC.add(btnConFornecedor);

        btnConProd.setText("Produtos");
        btnConProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConProdActionPerformed(evt);
            }
        });
        btnC.add(btnConProd);

        btnConVendas.setText("Vendas");
        btnConVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConVendasActionPerformed(evt);
            }
        });
        btnC.add(btnConVendas);

        btnConFuncionarios.setText("Vendedores");
        btnConFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConFuncionariosActionPerformed(evt);
            }
        });
        btnC.add(btnConFuncionarios);

        jMenuBar1.add(btnC);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/relatorio-de-seo.png"))); // NOI18N
        jMenu3.setText("Relatórios");

        jMenuItem4.setText("Compras por mês");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuItem6.setText("Vendas por mês");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        jMenuBar1.add(jMenu3);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/question-mark.png"))); // NOI18N
        jMenu4.setText("Ajuda");

        jMenuItem5.setText("Sobre");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem5);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(311, 311, 311)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(375, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(362, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadFuncionariosActionPerformed
        CadastroVendedor objCadastroFuncionario = new CadastroVendedor();
        objCadastroFuncionario.setResizable(false);
        objCadastroFuncionario.setVisible(true);
    }//GEN-LAST:event_btnCadFuncionariosActionPerformed

    private void btnCadFornecedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadFornecedoresActionPerformed
        CadastroFornecedor objCadastroFornecedor = new CadastroFornecedor();
        objCadastroFornecedor.setResizable(false);
        objCadastroFornecedor.setVisible(true);
    }//GEN-LAST:event_btnCadFornecedoresActionPerformed

    private void btnConFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConFornecedorActionPerformed
        ConsultaFornecedor objConsultaFornecedor = new ConsultaFornecedor();
        objConsultaFornecedor.setResizable(false);
        objConsultaFornecedor.setVisible(true);
    }//GEN-LAST:event_btnConFornecedorActionPerformed

    private void btnConFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConFuncionariosActionPerformed
        ConsultaVendedor objConsultaFuncionario = new ConsultaVendedor();
        objConsultaFuncionario.setResizable(false);
        objConsultaFuncionario.setVisible(true);
    }//GEN-LAST:event_btnConFuncionariosActionPerformed

    private void btnCadCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadCompraActionPerformed
        CadastroCompra objCadastroCompra = new CadastroCompra();
        objCadastroCompra.setResizable(false);
        objCadastroCompra.setVisible(true);
    }//GEN-LAST:event_btnCadCompraActionPerformed

    private void btnCadVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadVendasActionPerformed
        CadastroVenda objCadastroVenda = new CadastroVenda();
        objCadastroVenda.setResizable(false);
        objCadastroVenda.setVisible(true);
    }//GEN-LAST:event_btnCadVendasActionPerformed

    private void btnCadProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadProdutosActionPerformed
        CadastroProduto objCadastroProduto = new CadastroProduto();
        objCadastroProduto.setResizable(false);
        objCadastroProduto.setVisible(true);
    }//GEN-LAST:event_btnCadProdutosActionPerformed

    private void btnConComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConComprasActionPerformed
        ConsultaCompra objConsultaCompra = new ConsultaCompra();
        objConsultaCompra.setResizable(false);
        objConsultaCompra.setVisible(true);
    }//GEN-LAST:event_btnConComprasActionPerformed

    private void btnConProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConProdActionPerformed
        ConsultaProduto objConsultaProduto = new ConsultaProduto();
        objConsultaProduto.setResizable(false);
        objConsultaProduto.setVisible(true);
    }//GEN-LAST:event_btnConProdActionPerformed

    private void btnConVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConVendasActionPerformed
        ConsultaVenda objConsultaVenda = new ConsultaVenda();
        objConsultaVenda.setResizable(false);
        objConsultaVenda.setVisible(true);
    }//GEN-LAST:event_btnConVendasActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        CompraMes objCompraMes = new CompraMes();
        objCompraMes.setResizable(false);
        objCompraMes.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        VendaMes objVendaMes = new VendaMes();
        objVendaMes.setResizable(false);
        objVendaMes.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        Sobre objSobre = new Sobre();
        objSobre.setResizable(false);
        objSobre.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicio().setVisible(true);
            }
        });
    }
    
   
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu btnC;
    private javax.swing.JMenuItem btnCadCompra;
    private javax.swing.JMenu btnCadCompras;
    private javax.swing.JMenuItem btnCadFornecedores;
    private javax.swing.JMenuItem btnCadFuncionarios;
    private javax.swing.JMenuItem btnCadProdutos;
    private javax.swing.JMenuItem btnCadVendas;
    private javax.swing.JMenuItem btnConCompras;
    private javax.swing.JMenuItem btnConFornecedor;
    private javax.swing.JMenuItem btnConFuncionarios;
    private javax.swing.JMenuItem btnConProd;
    private javax.swing.JMenuItem btnConVendas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    // End of variables declaration//GEN-END:variables
}

