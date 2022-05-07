package Disney;

import DeathStars.Agencia;
import Falcon.ValidaCpf;
import Force.Conta;
import StormTroppers.Cliente;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MenuClientesGerente extends javax.swing.JFrame {

    public MenuClientesGerente(int nroAgen) {
        this.nroAgen = nroAgen;
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Gerente - CLI");
        setMinimumSize(new java.awt.Dimension(700, 450));
        setPreferredSize(new java.awt.Dimension(700, 450));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridLayout(5, 1, 0, 5));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MENU CLIENTE");
        getContentPane().add(jLabel1);

        jButton1.setText("REGISTRAR NOVO CLIENTE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);

        jButton2.setText("EDITAR DADOS DE UM CLIENTE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);

        jButton4.setText("EXIBIR DADOS DE CLIENTE");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);

        jButton3.setText("REMOVER CLIENTE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        FormularioCliente.formularioCliente(this.nroAgen);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.setVisible(false);
    }//GEN-LAST:event_formWindowClosing

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        Cliente cliente = null;
        String cpf = ((String) JOptionPane.showInputDialog("Cpf (Apenas números"
                + ") do cliente que será removido"));
        
        if(cpf == null) // Cancelar
            return;

        if(!ValidaCpf.ehNumerico(cpf) || !ValidaCpf.validaCpf(cpf)) {

            JOptionPane.showMessageDialog(null, "CPF inserido é inválido");
            return;

        }// if
        
        cpf = ValidaCpf.toString(cpf);
        Agencia agencia = ((Agencia) Main.getAdmin().getAgencias().buscar(this
            .nroAgen));
        
        if(agencia.getClientes().excluir(cpf)) {
            
            ArrayList<Conta> ds_conta = new ArrayList<Conta>();

            for(Conta conta : agencia.getContas().listar()) {
                for(Cliente cliente1 : conta.getCliente()) {
                    
                    if(cliente1.getCpf().equals(cpf) && conta.getProprietarios() == 1)
                        ds_conta.add(conta);

                    else if(cliente1.getCpf().equals(cpf)) {
                        conta.rmvCliente(cliente1);
                        conta.setProprietarios(1);
                    }// if else
                }// for
            }// for
            
            for(Conta conta : ds_conta) // Desativar contas do cliente removido
                conta.setStatus(false);
            
            JOptionPane.showMessageDialog(null, "Cliente excluido");

        } else
            JOptionPane.showMessageDialog(null, "Cliente não encontrado");
                
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        JOptionPane.showMessageDialog(null, "\nAtenção!!\n\nOs endereços serão lidos\ne substituidos"
                + "\napenas ao fechar o menu de edição\n(Somente os endereços)");
        EditarCliente.editarCliente(this.nroAgen);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        Cliente cliente = null;
        String cpf = ((String) JOptionPane.showInputDialog("Cpf (Apenas números"
                + ") do cliente que será exibido"));
        
        if(cpf == null) // Cancelar
            return;

        if(!ValidaCpf.ehNumerico(cpf) || !ValidaCpf.validaCpf(cpf)) {

            JOptionPane.showMessageDialog(null, "CPF inserido é inválido");
            return;

        }// if
        
        Agencia agencia = ((Agencia) Main.getAdmin().getAgencias().buscar(this
            .nroAgen));

        cpf = ValidaCpf.toString(cpf);
        if(agencia.getClientes().buscar(cpf) instanceof Cliente) {

            cliente = ((Cliente) agencia.getClientes().buscar(cpf));
            JOptionPane.showMessageDialog(null, "Informações do cliente\n\n" + 
                    cliente.toString());

        } else
            JOptionPane.showMessageDialog(null, "Cliente não encontrado");

    }//GEN-LAST:event_jButton4ActionPerformed

    public static void menuClientesGerente(int nroAgen) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuClientesGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuClientesGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuClientesGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuClientesGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MenuClientesGerente menuGerenG = new MenuClientesGerente(nroAgen);
                menuGerenG.setLocationRelativeTo(null);
                menuGerenG.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
    private int nroAgen;
}
