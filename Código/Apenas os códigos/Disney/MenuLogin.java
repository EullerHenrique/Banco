package Disney;

import DarthVader.Admin;
import DeathStars.Agencia;
import Falcon.ValidaCpf;
import Force.Conta;
import StormTroppers.Cliente;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class MenuLogin extends javax.swing.JFrame {

    public MenuLogin() {
        initComponents();
    }// MenuLogin

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Login");
        setBackground(new java.awt.Color(95, 95, 95));
        setMinimumSize(new java.awt.Dimension(500, 400));
        setPreferredSize(new java.awt.Dimension(500, 400));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridLayout(4, 1, 10, 20));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MENU DE LOGIN");
        getContentPane().add(jLabel1);

        jButton1.setText("LOGAR COMO ADMIN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);

        jButton2.setText("LOGAR COMO GERENTE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);

        jButton3.setText("LOGAR COMO CLIENTE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String senha = JOptionPane.showInputDialog("Digite a senha de administ"
                + "rador");

        if(senha.equals(Main.getAdmin().getSenha()))
            MenuAdmin.menuAdmin();

        else
            JOptionPane.showMessageDialog(null, "Senha Incorreta");

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        ArrayList<String> nros = new ArrayList<String>();
        
        for(Agencia agen : Main.getAdmin().getAgencias().listar())
            nros.add("" + agen.getNum());
        
        if(nros.size() != 0) {
        
            String aux = ((String) JOptionPane.showInputDialog(null, "Nº da agência ",
                    null, JOptionPane.QUESTION_MESSAGE, null, nros.toArray(),
                    nros.get(0)));
            
            if(aux == null)
                return;
            
            int nroAgen = Integer.parseInt(aux);
            Agencia agen = (Agencia) Main.getAdmin().getAgencias()
                    .buscar(nroAgen);

            String senha_gerente = JOptionPane.showInputDialog("Digite a senha "
                    + "do gerente da agência");

            if(senha_gerente.equals(((Agencia) agen).getGerente().getSenha()))
                MenuGerente.menuGerente(nroAgen);
            else
                JOptionPane.showMessageDialog(null, "Senha Incorreta");
            
        } else
            JOptionPane.showMessageDialog(null, "Não há agências cadastradas");

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        ArrayList<String> nros = new ArrayList<String>();
        ArrayList<String> contas = new ArrayList<String>();

        for(Agencia agen : Main.getAdmin().getAgencias().listar())
            nros.add("" + agen.getNum());
        
        String aux = ((String) JOptionPane.showInputDialog(null, "Escolha sua agê"
            + "ncia", null, JOptionPane.QUESTION_MESSAGE, null, nros.toArray(),
            nros.get(0)));
            
        if(aux == null)
            return;
           
        int nroAgen = Integer.parseInt(aux);
        Agencia agencia = ((Agencia) Main.getAdmin().getAgencias()
                .buscar(nroAgen));
        
        String cpf = ((String) JOptionPane.showInputDialog("Digite seu cpf" +
                "(Apenas números)"));        
        if(!ValidaCpf.ehNumerico(cpf) || !ValidaCpf.validaCpf(cpf)) {
            
            JOptionPane.showMessageDialog(null, "CPF inválido");
            return;
            
        }// if

        boolean flag = false;
        cpf = ValidaCpf.toString(cpf);  // Para comparação correta
        for(Cliente cliente : agencia.getClientes().listar())
            if(cliente.getCpf().equals(cpf)) {
                flag = true;
                break;
            }// if

        if(!flag) {
            JOptionPane.showMessageDialog(null, "Não há cliente com esse " +
                    "CPF nessa agência");
            return;
        }// if

        for(Conta conta : agencia.getContas().listar()) {
            for(Cliente cliente : conta.getCliente()) {
                if(cliente.getCpf().equals(cpf))
                    contas.add("" + conta.getNroConta());

            }// for
        }// for
        
        if(contas.size() != 0) {
        
            aux = ((String) JOptionPane.showInputDialog(null, "Escolha qu"
                    + "al conta deseja acessar", null, JOptionPane.QUESTION_MESSAGE,
                null, contas.toArray(), contas.get(0)));
            
            if(aux == null)
                return;
            
            int nroConta = Integer.parseInt(aux);
            Conta conta = ((Conta) agencia.getContas().buscar(nroConta));

            while(true) {

                String senha = JOptionPane.showInputDialog("Digite a senha da c"
                        + "onta");

                if(senha == null)   // Cancelar
                    break;

                else if(conta.getSenha().equals(senha)) {

                    MenuCliente.menuCliente(nroConta, nroAgen);
                    break;

                } else
                    JOptionPane.showMessageDialog(null, "Senha incorreta");

            }// while

        } else 
            JOptionPane.showMessageDialog(null, "Esse cpf não possui contas nes"
                    + "sa agência");

    }//GEN-LAST:event_jButton3ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        String[] opcoes = {"Sim", "Não"};

        this.setVisible(false);
        int resp = JOptionPane.showOptionDialog(null, "Tem certeza que " +
                   "deseja sair?", "Saída", JOptionPane.YES_NO_OPTION,
                   JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
        
        if(resp == JOptionPane.YES_OPTION) {
            Main.getAdmin().getAgencias().salvarAgencias();
            System.exit(0);

        } else
            this.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    public static void menuLogin() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MenuLogin menuLogin = new MenuLogin();
                menuLogin.setLocationRelativeTo(null);
                menuLogin.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
