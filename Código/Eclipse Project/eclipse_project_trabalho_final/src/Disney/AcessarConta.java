package Disney;

import DeathStars.Agencia;
import Falcon.Transacao;
import Force.Conta;
import Jabba.ContaPoupanca;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class AcessarConta extends javax.swing.JFrame {

    public AcessarConta(int nroConta, int nroAgen) {
        this.nroConta = nroConta;
        this.nroAgen  = nroAgen;
        
        Agencia agencia  = ((Agencia) Main.getAdmin().getAgencias().buscar(this.nroAgen));
        Conta conta      = ((Conta) agencia.getContas().buscar(this.nroConta));
        
        if(conta instanceof ContaPoupanca) {

            ((ContaPoupanca) conta).calcularRendMes();
            JOptionPane.showMessageDialog(null, "Rendimento da Poupança calcula"
                    + "da com sucesso");

        }// if
        
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Cliente - CON");
        setMinimumSize(new java.awt.Dimension(450, 450));
        setPreferredSize(new java.awt.Dimension(450, 450));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridLayout(7, 1, 0, 5));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CONTA");
        getContentPane().add(jLabel1);

        jButton1.setText("SAQUE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);

        jButton2.setText("TRANSFERÊNCIA");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);

        jButton3.setText("DEPÓSITO");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);

        jButton4.setText("PAGAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);

        jButton5.setText("EXIBIR DADOS");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);

        jButton6.setText("BUSCAR TRANSAÇÃO");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.setVisible(false);
    }//GEN-LAST:event_formWindowClosing

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String senha = ((String) JOptionPane.showInputDialog("Digite a senha da sua conta"));
        
        if(senha == null)   // Cancelar
            return;
        
        String[] opcoes_canal = {"internet banking", "caixa eletrônico", "caixa físico"};
        String escolhida = ((String) JOptionPane.showInputDialog(null, "Escolha um canal",
                null, JOptionPane.QUESTION_MESSAGE, null, opcoes_canal, opcoes_canal[0]));
        
        if(escolhida == null)   // Cancelar
            return;
        
        try {
            
            String real_str = (String)JOptionPane.showInputDialog("Valor do saque");
        
            if(real_str == null)   // Cancelar
                return;
            
            float qtd = Float.parseFloat(real_str);
            
            Agencia agencia = ((Agencia) Main.getAdmin().getAgencias().buscar(this.nroAgen));
            Conta conta = ((Conta) agencia.getContas().buscar(this.nroConta));
            
            if(conta.saque(qtd, escolhida, senha))
                JOptionPane.showMessageDialog(null, "Operação realizada com sucesso");
            
            else
                JOptionPane.showMessageDialog(null, "Senha incorreta ou valor digitado é"
                        + "inválido");
            
        } catch(NumberFormatException exc) {
            
            JOptionPane.showMessageDialog(null, "O valor da transação de ser númerico");
            
        } catch(Exception exc) {
            
            JOptionPane.showMessageDialog(null, exc.toString());
            
        }// try catch

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        String senha = ((String) JOptionPane.showInputDialog("Digite a senha da sua conta"));
        
        if(senha == null)   // Cancelar
            return;

        String[] opcoes_canal = {"internet banking", "caixa eletrônico", "caixa físico"};
        String escolhida = ((String) JOptionPane.showInputDialog(null, "Escolha um canal",
                null, JOptionPane.QUESTION_MESSAGE, null, opcoes_canal, opcoes_canal[0]));
        
        if(escolhida == null)   // Cancelar
            return;
        
        ArrayList<String> nroAgen_dest = new ArrayList<String>();
        ArrayList<String> nroCont_dest = new ArrayList<String>();
        
        for(Agencia agencia : Main.getAdmin().getAgencias().listar())
            nroAgen_dest.add("" + agencia.getNum());

        String aux = ((String) JOptionPane.showInputDialog(null, "Escolha a agência da conta q"
                + "ue receberá a transferência", null, JOptionPane.QUESTION_MESSAGE, null,
                nroAgen_dest.toArray(), nroAgen_dest.get(0)));
        
        if(aux == null)   // Cancelar
            return;
        
        int age_dest = Integer.parseInt(aux);
        Agencia agencia = ((Agencia) Main.getAdmin().getAgencias().buscar(age_dest));
        
        for(Conta conta : agencia.getContas().listar()) {

            if(conta.getNroConta() != this.nroConta)
                nroCont_dest.add("" + conta.getNroConta());

        }// for
        
        if(nroCont_dest.size() == 0) {
            
            JOptionPane.showMessageDialog(null, "Não há outras contas para receber a"
                    + "transferência");
            return;

        }// if
        
        aux = ((String) JOptionPane.showInputDialog(null, "Escolha a conta que rece"
                + "berá a transferência", null, JOptionPane.QUESTION_MESSAGE, null,
                nroCont_dest.toArray(), nroCont_dest.get(0)));
        
        if(aux == null)   // Cancelar
            return;
        
        int con_dest = Integer.parseInt(aux);
        try {
            
            aux = (String) JOptionPane.showInputDialog("Valor da transferência");
        
            if(aux == null)   // Cancelar
                return;
            
            float qtd = Float.parseFloat(aux);
            agencia = ((Agencia) Main.getAdmin().getAgencias().buscar(this.nroAgen));
            Conta conta = ((Conta) agencia.getContas().buscar(this.nroConta));
            
            if(conta.transf(qtd, senha, escolhida, age_dest, con_dest)) {

                JOptionPane.showMessageDialog(null, "Operação realizada com sucesso");
                
                agencia = ((Agencia) Main.getAdmin().getAgencias().buscar(age_dest));
                conta = ((Conta) agencia.getContas().buscar(con_dest));
                conta.setSaldoAtual(conta.getSaldoAtual() + qtd);       // Atualiza saldo que recebeu
                                                                        // transferencia
            
            } else
                JOptionPane.showMessageDialog(null, "Senha incorreta ou valor digitado é"
                        + "inválido");
            
        } catch(NumberFormatException exc) {
            
            JOptionPane.showMessageDialog(null, "O valor da transação de ser númerico");
            
        } catch(Exception exc) {
            
            JOptionPane.showMessageDialog(null, exc.toString());
            
        }// try catch

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        String senha = ((String) JOptionPane.showInputDialog("Digite a senha da sua conta"));
        
        if(senha == null)   // Cancelar
            return;
        
        String[] opcoes_canal = {"internet banking", "caixa eletrônico", "caixa físico"};
        String escolhida = ((String) JOptionPane.showInputDialog(null, "Escolha um canal",
                null, JOptionPane.QUESTION_MESSAGE, null, opcoes_canal, opcoes_canal[0]));
        
        if(escolhida == null)   // Cancelar
            return;
        
        try {
            
            String aux = (String) JOptionPane.showInputDialog("Valor do depósito");
        
            if(aux == null)   // Cancelar
                return;
            
            float qtd = Float.parseFloat(aux);
            Agencia agencia = ((Agencia) Main.getAdmin().getAgencias().buscar(this.nroAgen));
            Conta conta = ((Conta) agencia.getContas().buscar(this.nroConta));
            
            if(conta.depos(qtd, senha, escolhida))
                JOptionPane.showMessageDialog(null, "Operação realizada com sucesso");
            
            else
                JOptionPane.showMessageDialog(null, "Senha incorreta ou valor digitado é"
                        + "inválido");
            
        } catch(NumberFormatException exc) {
            
            JOptionPane.showMessageDialog(null, "O valor da transação de ser númerico");
            
        } catch(Exception exc) {
            
            JOptionPane.showMessageDialog(null, exc.toString());
            
        }// try catch

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        String senha = ((String) JOptionPane.showInputDialog("Digite a senha da sua conta"));
        
        if(senha == null)   // Cancelar
            return;
        
        String[] opcoes_canal = {"internet banking", "caixa eletrônico", "caixa físico"};
        String escolhida = ((String) JOptionPane.showInputDialog(null, "Escolha um canal",
                null, JOptionPane.QUESTION_MESSAGE, null, opcoes_canal, opcoes_canal[0]));
        
        if(escolhida == null)   // Cancelar
            return;
        
        try {
            
            String aux = (String) JOptionPane.showInputDialog("Valor à pagar");
        
            if(aux == null)   // Cancelar
                return;
            
            float qtd = Float.parseFloat(aux);
            Agencia agencia = ((Agencia) Main.getAdmin().getAgencias().buscar(this.nroAgen));
            Conta conta = ((Conta) agencia.getContas().buscar(this.nroConta));
            
            if(conta.pagar(qtd, senha, escolhida))
                JOptionPane.showMessageDialog(null, "Operação realizada com sucesso");
            
            else
                JOptionPane.showMessageDialog(null, "Senha incorreta ou valor digitado é"
                        + "inválido");
            
        } catch(NumberFormatException exc) {
            
            JOptionPane.showMessageDialog(null, "O valor da transação de ser númerico");
            
        } catch(Exception exc) {
            
            JOptionPane.showMessageDialog(null, exc.toString());
            
        }// try catch

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        
        Agencia agencia = ((Agencia) Main.getAdmin().getAgencias().buscar(this.nroAgen));
        Conta conta = (Conta) agencia.getContas().buscar(this.nroConta);
        
        JOptionPane.showMessageDialog(null, "Dados da Conta\n\n" + conta.toString());
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        
        ArrayList<String> datas_transacoes = new ArrayList<String>();
        Agencia agencia = ((Agencia) Main.getAdmin().getAgencias().buscar(this.nroAgen));
        Conta conta = (Conta) agencia.getContas().buscar(this.nroConta);
        
        for(Transacao transacao : conta.getTrasacoes()) {
            if(!datas_transacoes.contains(transacao.getDataTransacao()))
                datas_transacoes.add(transacao.getDataTransacao());
        }// for
        
        if(datas_transacoes.size() != 0) {

            String data_escolhida = ((String) JOptionPane.showInputDialog(null, "De qual data dese"
                    + "ja buscar as transações", null, JOptionPane.QUESTION_MESSAGE, null,
                    datas_transacoes.toArray(), datas_transacoes.get(0)));
            
            if(data_escolhida == null)  // Cancelar
                return;

            String str = "";
            for(Transacao transacao : conta.buscaTransacao(data_escolhida))
                str += "\n\n" + transacao.toString();
            
            JTextArea textArea = new JTextArea("Dados:\n" + str);
            JScrollPane scrollPane = new JScrollPane(textArea);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            textArea.setEditable(false);
            scrollPane.setPreferredSize(new Dimension(500, 500));
            JOptionPane.showMessageDialog(null, scrollPane);
                
        } else
            JOptionPane.showMessageDialog(null, "Essa conta não possui transações");
        
    }//GEN-LAST:event_jButton6ActionPerformed

    public static void acessarConta(int nroConta, int nroAgen) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AcessarConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AcessarConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AcessarConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AcessarConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AcessarConta menuConta = new AcessarConta(nroConta, nroAgen);
                menuConta.setLocationRelativeTo(null);
                menuConta.setVisible(true);
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
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
    private int nroConta, nroAgen;
}
