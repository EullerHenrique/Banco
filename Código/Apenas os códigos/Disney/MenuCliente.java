package Disney;

import DeathStars.Agencia;
import Force.Conta;
import javax.swing.JOptionPane;

public class MenuCliente extends javax.swing.JFrame {

    public MenuCliente(int nroConta, int nroAgen) {
        this.nroConta = nroConta;
        this.nroAgen = nroAgen;
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Cliente");
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

        jButton1.setText("ACESSAR CONTA");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);

        jButton2.setText("DESATIVAR CONTA");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);

        jButton3.setText("ALTERAR SENHA");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);

        jButton4.setText("REATIVAR CONTA");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        Agencia agencia = ((Agencia) Main.getAdmin().getAgencias()
                .buscar(this.nroAgen));
        Conta conta = ((Conta) agencia.getContas().buscar(this.nroConta));
        
        if(conta.isStatus())
            AcessarConta.acessarConta(this.nroConta, this.nroAgen);
            
        else
            JOptionPane.showMessageDialog(null, "Conta de nº " +
                conta.getNroConta() + "está desativada");
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        Agencia agencia = ((Agencia) Main.getAdmin().getAgencias()
                .buscar(this.nroAgen));
        Conta conta = ((Conta) agencia.getContas().buscar(this.nroConta));
        
        if(conta.isStatus()) {
            
            String senha = JOptionPane.showInputDialog("Digite a senha da conta");
            
            if(!senha.equals(conta.getSenha())) {
                
                JOptionPane.showMessageDialog(null, "Senha incorreta");
                return;
            }// if
            
            String[] opcoes = {"Sim", "Não"};
            int escolha = JOptionPane.showOptionDialog(null, "Tem certeza que d"
                    + "eseja desativar sua conta?", "Desativar conta",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, opcoes, opcoes[0]);
            
            if(escolha == JOptionPane.NO_OPTION)
                return;
            
            conta.setStatus(false);
            JOptionPane.showMessageDialog(null, "Conta de nº " + this.nroConta
                + " desativada com sucesso\n\nVocê pode reativá-la posteriormen"
                + "te");
            
        } else
            JOptionPane.showMessageDialog(null, "A conta de nº " + this.nroConta
                + " já está desativada");

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        Agencia agencia = ((Agencia) Main.getAdmin().getAgencias()
                .buscar(this.nroAgen));
        Conta conta = ((Conta) agencia.getContas().buscar(this.nroConta));
        
        if(!conta.isStatus()) {
            
            String senha = JOptionPane.showInputDialog("Digite a senha da conta");
            
            if(!senha.equals(conta.getSenha())) {
                
                JOptionPane.showMessageDialog(null, "Senha incorreta");
                return;
            }// if
            
            String[] opcoes = {"Sim", "Não"};
            int escolha = JOptionPane.showOptionDialog(null, "Tem certeza que d"
                    + "eseja reativar sua conta?", "Reativar conta",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, opcoes, opcoes[0]);
            
            if(escolha == JOptionPane.NO_OPTION)
                return;

            conta.setStatus(true);
            JOptionPane.showMessageDialog(null, "Conta de nº " + this.nroConta
                + " reativada com sucesso\n\nVocê pode desativá-la posteriormen"
                + "te");
            
        } else
            JOptionPane.showMessageDialog(null, "A conta de nº " + this.nroConta
                + " já está ativada");
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.setVisible(false);
    }//GEN-LAST:event_formWindowClosing

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        Agencia agencia = ((Agencia) Main.getAdmin().getAgencias()
                .buscar(this.nroAgen));
        Conta conta = ((Conta) agencia.getContas().buscar(this.nroConta));
        
        if(conta.isStatus()) {
            
            String senha = JOptionPane.showInputDialog("Digite a senha da conta");
            String nw_senha = ((String) JOptionPane.showInputDialog("Digite a nova senha"));
            String confirm_senha = ((String) JOptionPane.showInputDialog("Confirme a nova senha"));
            
            if(!nw_senha.equals(confirm_senha)) {

                JOptionPane.showMessageDialog(null, "Confirmação de senha incorreta!");
                return;

            }// if
            
            if(conta.alterarSenha(senha, nw_senha))
                JOptionPane.showMessageDialog(null, "Senha alterada!");

            else
                JOptionPane.showMessageDialog(null, "Senha atual incorreta!");
            
        } else
            JOptionPane.showMessageDialog(null, "A conta de nº " + this.nroConta
                + " está desativada");

    }//GEN-LAST:event_jButton3ActionPerformed

   public static void menuCliente(int nroConta, int nroAgen) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MenuCliente menuCli = new MenuCliente(nroConta, nroAgen);
                menuCli.setLocationRelativeTo(null);
                menuCli.setVisible(true);
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
    private int nroAgen, nroConta;
}
