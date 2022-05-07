package Disney;

import DeathStars.Agencia;
import Falcon.ValidaCpf;
import Force.Conta;
import StormTroppers.Cliente;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MenuContasGerente extends javax.swing.JFrame {

    public MenuContasGerente(int nroAgen) {
        this.nroAgen = nroAgen;
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Gerente - CON");
        setMinimumSize(new java.awt.Dimension(700, 450));
        setPreferredSize(new java.awt.Dimension(700, 450));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridLayout(8, 1, 0, 5));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MENU CONTAS - GERENTE");
        getContentPane().add(jLabel1);

        jButton1.setText("REGISTRAR NOVA CONTA");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);

        jButton6.setText("ADICIONAR CLIENTE A CONTA");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);

        jButton7.setText("REMOVER CLIENTE DE CONTA");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7);

        jButton5.setText("DESATIVAR CONTA");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);

        jButton4.setText("REATIVAR CONTA");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);

        jButton2.setText("ALTERAR SENHA DE CONTA");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);

        jButton3.setText("EXIBIR CONTA");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.setVisible(false);
    }//GEN-LAST:event_formWindowClosing

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        ArrayList<String> nros = new ArrayList<String>();
        
        Agencia agencia = ((Agencia) Main.getAdmin().getAgencias().buscar(this
                .nroAgen));
        for(Conta conta : agencia.getContas().listar())
            nros.add("" + conta.getNroConta());
        
        if(nros.size() == 0) {
            JOptionPane.showMessageDialog(null, "Não há contas nessa agência");
            return;
        }// if
        
        String aux = ((String) JOptionPane.showInputDialog(null, "Escolha uma con"
            + "ta", null, JOptionPane.QUESTION_MESSAGE, null, nros.toArray(),
            nros.get(0)));

        if(aux == null)
            return;
        
        int escolha = Integer.parseInt(aux);
        
        Conta conta = ((Conta) agencia.getContas().buscar(escolha));
        if(conta.isStatus()) {
            
            String nw_senha = ((String) JOptionPane.showInputDialog("Digite a n"
                + "ova senha"));
            
            if(!nw_senha.equals("")) {
                conta.setSenha(nw_senha);
                JOptionPane.showMessageDialog(null, "Senha alterada");

            } else
                JOptionPane.showMessageDialog(null, "Senha não pode ser vazia");

            
        } else
            JOptionPane.showMessageDialog(null, "A conta está desativada");
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        ArrayList<String> nros = new ArrayList<String>();
        
        Agencia agencia = ((Agencia) Main.getAdmin().getAgencias().buscar(this
                .nroAgen));
        for(Conta conta : agencia.getContas().listar())
            nros.add("" + conta.getNroConta());
        
        if(nros.size() == 0) {
            JOptionPane.showMessageDialog(null, "Não há contas nessa agência");
            return;
        }// if
        
        String aux = ((String) JOptionPane.showInputDialog(null, "Escolha uma con"
            + "ta", null, JOptionPane.QUESTION_MESSAGE, null, nros.toArray(),
            nros.get(0)));
        
        if(aux == null)
            return;
        
        int escolha = Integer.parseInt(aux);
        JOptionPane.showMessageDialog(null, "Informações da conta\n\n" +
            ((Conta) agencia.getContas().buscar(escolha)).toString());

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        ArrayList<String> nros = new ArrayList<String>();
        
        Agencia agencia = ((Agencia) Main.getAdmin().getAgencias().buscar(this
                .nroAgen));
        for(Conta conta : agencia.getContas().listar())
            nros.add("" + conta.getNroConta());
        
        if(nros.size() == 0) {
            JOptionPane.showMessageDialog(null, "Não há contas nessa agência");
            return;
        }// if
        
        String aux = ((String) JOptionPane.showInputDialog(null, "Escolha uma con"
            + "ta", null, JOptionPane.QUESTION_MESSAGE, null, nros.toArray(),
            nros.get(0)));
        
        if(aux == null)
            return;
        
        int escolha = Integer.parseInt(aux);
        
        if(!((Conta) agencia.getContas().buscar(escolha)).isStatus()) {
            JOptionPane.showMessageDialog(null, "Está conta já está desativada");
            return;
        }// if
        
        ((Conta) agencia.getContas().buscar(escolha)).setStatus(false);
        JOptionPane.showMessageDialog(null, "Conta desativada");

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        ArrayList<String> nros = new ArrayList<String>();
        
        Agencia agencia = ((Agencia) Main.getAdmin().getAgencias().buscar(this
                .nroAgen));
        for(Conta conta : agencia.getContas().listar())
            nros.add("" + conta.getNroConta());
        
        if(nros.size() == 0) {
            JOptionPane.showMessageDialog(null, "Não há contas nessa agência");
            return;
        }// if
        
        String aux = ((String) JOptionPane.showInputDialog(null, "Escolha uma con"
            + "ta", null, JOptionPane.QUESTION_MESSAGE, null, nros.toArray(),
            nros.get(0)));
        
        if(aux == null)
            return;
        
        int escolha = Integer.parseInt(aux);
        if(((Conta) agencia.getContas().buscar(escolha)).isStatus()) {
            JOptionPane.showMessageDialog(null, "Está conta já está ativada");
            return;
        }// if
        
        ((Conta) agencia.getContas().buscar(escolha)).setStatus(true);
        JOptionPane.showMessageDialog(null, "Conta ativada");

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        boolean flag = false;
        String cpf = ((String) JOptionPane.showInputDialog("Cpf (Apenas números"
                + ") do cliente que será dono da nova conta"));
        
        if(cpf == null) // Cancelar
            return;

        if(!ValidaCpf.ehNumerico(cpf) || !ValidaCpf.validaCpf(cpf)) {

            JOptionPane.showMessageDialog(null, "CPF inserido é inválido");
            return;

        }// if
        
        cpf = ValidaCpf.toString(cpf);
        Agencia agencia = ((Agencia) Main.getAdmin().getAgencias().buscar(this
            .nroAgen));
        
        for(Cliente cliente : agencia.getClientes().listar()) {
            if(cliente.getCpf().equals(cpf))
                flag = true;
        }// for
        
        if(flag)
            FormularioConta.formularioConta(this.nroAgen, cpf);
        else
            JOptionPane.showMessageDialog(null, "CPF não cadastrado nessa agência");

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        
        String cpf = JOptionPane.showInputDialog("Entre com o cpf do cliente a ser adicionado");
        
        if(!ValidaCpf.ehNumerico(cpf) || !ValidaCpf.validaCpf(cpf)) {
            
            JOptionPane.showMessageDialog(null, "CPF digitado é inválido");
            return;
            
        }// if
        
        cpf = ValidaCpf.toString(cpf);
        Agencia agencia = ((Agencia) Main.getAdmin().getAgencias().buscar(this.nroAgen));
        
        ArrayList<String> cpfs = new ArrayList<String>();
        for(Cliente cliente : agencia.getClientes().listar())
            cpfs.add(cliente.getCpf());

        if(cpfs.contains(cpf)){
            
            ArrayList<String> nros = new ArrayList<String>();
            for(Conta conta : agencia.getContas().listar()) {

                if(conta.getCliente().size() == 2) {
                    if(!conta.getCliente().get(0).getCpf().equals(cpf) &&
                       !conta.getCliente().get(1).getCpf().equals(cpf))
                            nros.add("" + conta.getNroConta());

                } else
                    if(!conta.getCliente().get(0).getCpf().equals(cpf))
                        nros.add("" + conta.getNroConta());

            }// for
            
            if(nros.size() > 0) {
                String aux = ((String)JOptionPane.showInputDialog(null, "Escolha a conta", null,
                        JOptionPane.QUESTION_MESSAGE, null, nros.toArray(), nros.get(0)));

                if(aux == null) // Cancelar
                    return;

                int nroConta = Integer.parseInt(aux);
                Cliente cliente = ((Cliente) agencia.getClientes().buscar(cpf));
                Conta conta     = ((Conta) agencia.getContas().buscar(nroConta));
                if(conta.adcCliente(cliente))
                    JOptionPane.showMessageDialog(null, "Cliente adicionado com sucesso");

                else
                    JOptionPane.showMessageDialog(null, "Conta já possui dois cliente");
            } else
                JOptionPane.showMessageDialog(null, "Não há contas para adicionar esse cli"
                        + "ente:\n\t1. Porque todas as conta da agência são desse cliente;"
                        + "\n\t2. Não há contas nessa agência.");

        } else {
            
            String[] opcoes = {"Sim", "Não"};

            int resp = JOptionPane.showOptionDialog(null, "Cliente não cadastrado nessa"
                    + " agência.\nDeseja cadastrá-lo?", null, JOptionPane.YES_NO_OPTION,
                   JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
            
            if(resp == JOptionPane.YES_OPTION)
                FormularioCliente.formularioCliente(this.nroAgen);

        }// if else
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        String cpf = JOptionPane.showInputDialog("Entre com o cpf do cliente a ser removido");
        
        if(!ValidaCpf.ehNumerico(cpf) || !ValidaCpf.validaCpf(cpf)) {
            
            JOptionPane.showMessageDialog(null, "CPF digitado é inválido");
            return;
            
        } else if(cpf == null)  // Cancelar
            return;
        
        cpf = ValidaCpf.toString(cpf);
        Agencia agencia = ((Agencia) Main.getAdmin().getAgencias().buscar(this.nroAgen));
        
        ArrayList<String> cpfs = new ArrayList<String>();
        for(Cliente cliente : agencia.getClientes().listar())
            cpfs.add(cliente.getCpf());

        if(cpfs.contains(cpf)){
            
            ArrayList<String> nros = new ArrayList<String>();
            for(Conta conta : agencia.getContas().listar()) {
                for(Cliente cliente : conta.getCliente()) {
                    if(cliente.getCpf().equals(cpf) && conta.isStatus())
                        nros.add("" + conta.getNroConta());

                }// for
            }// for
            
            if(nros.size() != 0) {
                String aux = ((String)JOptionPane.showInputDialog(null, "Escolha a conta", null,
                        JOptionPane.QUESTION_MESSAGE, null, nros.toArray(), nros.get(0)));

                if(aux == null) // Cancelar
                    return;

                int nroConta = Integer.parseInt(aux);
                Cliente cliente = ((Cliente) agencia.getClientes().buscar(cpf));
                Conta conta     = ((Conta) agencia.getContas().buscar(nroConta));

                if(conta.rmvCliente(cliente))
                    JOptionPane.showMessageDialog(null, "Cliente removido com sucesso");

                else
                    JOptionPane.showMessageDialog(null, "Impossível remover cliente, po"
                        + "is a conta só possui um proprietário");

            } else
                JOptionPane.showMessageDialog(null, "Esse cliente não possui contas "
                        + "ativas nessa agência");

        } else
            JOptionPane.showMessageDialog(null, "Esse cliente não pertence a essa agência");
            

    }//GEN-LAST:event_jButton7ActionPerformed

    public static void menuContasGerente(int nroAgen) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuContasGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuContasGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuContasGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuContasGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MenuContasGerente menuConG = new MenuContasGerente(nroAgen);
                menuConG.setLocationRelativeTo(null);
                menuConG.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
    private int nroAgen;
}
