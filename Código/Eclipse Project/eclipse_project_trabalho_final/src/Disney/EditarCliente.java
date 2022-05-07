package Disney;

import DeathStars.Agencia;
import Falcon.ValidaCpf;
import StormTroppers.Cliente;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EditarCliente extends javax.swing.JFrame {

    public EditarCliente(int nroAgen) {
        this.nroAgen = nroAgen;
        this.cpfs = new ArrayList<String>();
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Gerente - EDC");
        setMinimumSize(new java.awt.Dimension(450, 450));
        setPreferredSize(new java.awt.Dimension(450, 450));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridLayout(4, 1, 0, 5));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Editar Cliente");
        getContentPane().add(jLabel1);

        jButton1.setText("MUDAR ENDEREÇO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);

        jButton2.setText("ATUALIZAR ESTADO CIVIL");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);

        jButton3.setText("ATUALIZAR ESCOLARIDADE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        for(String cpf : this.cpfs) {

            Agencia agencia = ((Agencia) Main.getAdmin().getAgencias().buscar(this.nroAgen));
            Cliente cliente = ((Cliente) agencia.getClientes().buscar(cpf));
            
            cliente.setEndereco(EnderecoAuxiliar.pop(0));

        }// for
        
        JOptionPane.showMessageDialog(null, "Alterações de endereço realizadas com sucesso");
        
        EnderecoAuxiliar.limparArrs();
        this.setVisible(false);

    }//GEN-LAST:event_formWindowClosing

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        boolean flag = false;
        String cpf = ((String) JOptionPane.showInputDialog("Entre com o cpf do cliente "
                + "a ser alterado (Apenas números)"));
        Agencia agencia = ((Agencia) Main.getAdmin().getAgencias().buscar(this.nroAgen));
        
        if(cpf == null) // Cancelar
            return;
        
        if(!ValidaCpf.ehNumerico(cpf) || !ValidaCpf.validaCpf(cpf)) {
            
            JOptionPane.showMessageDialog(null, "CPF digitado é inválido");
            return;
            
        }// if
        
        cpf = ValidaCpf.toString(cpf);
        for(Cliente cliente : agencia.getClientes().listar()) {
            if(cliente.getCpf().equals(cpf)) {
                flag = true;
                break;
            }// if
        }// for
        
        if(flag) {

            this.cpfs.add(cpf);
            FormularioEndereco.formularioEndereco(0);

        } else
            JOptionPane.showMessageDialog(null, "CPF não cadastrado nessa agência");

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        boolean flag = false;
        String cpf = ((String) JOptionPane.showInputDialog("Entre com o cpf do cliente "
                + "a ser alterado (Apenas números)"));
        Agencia agencia = ((Agencia) Main.getAdmin().getAgencias().buscar(this.nroAgen));
        
        if(cpf == null) // Cancelar
            return;
        
        if(!ValidaCpf.ehNumerico(cpf) || !ValidaCpf.validaCpf(cpf)) {
            
            JOptionPane.showMessageDialog(null, "CPF digitado é inválido");
            return;
            
        }// if
        
        cpf = ValidaCpf.toString(cpf);
        for(Cliente cliente : agencia.getClientes().listar()) {
            if(cliente.getCpf().equals(cpf)) {
                flag = true;
                break;
            }// if
        }// for
        
        if(flag) {

            String[] opcoes = {"Casado(a)", "Solteiro(a)", "Divorciado(a)", "Viúvo(a)"};
            String escolha = ((String) JOptionPane.showInputDialog(null, "Novo valor do campo"
                    + " estado civil", null, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]));
            
            if(escolha == null)
                return;
            
            Cliente cliente = ((Cliente) agencia.getClientes().buscar(cpf));
            cliente.setEstadoCivil(escolha);
            
            JOptionPane.showMessageDialog(null, "Atualização realizada com sucesso");

            
        } else
            JOptionPane.showMessageDialog(null, "CPF não cadastrado nessa agência");

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        boolean flag = false;
        String cpf = ((String) JOptionPane.showInputDialog("Entre com o cpf do cliente "
                + "a ser alterado (Apenas números)"));
        Agencia agencia = ((Agencia) Main.getAdmin().getAgencias().buscar(this.nroAgen));
        
        if(cpf == null) // Cancelar
            return;
        
        if(!ValidaCpf.ehNumerico(cpf) || !ValidaCpf.validaCpf(cpf)) {
            
            JOptionPane.showMessageDialog(null, "CPF digitado é inválido");
            return;
            
        }// if
        
        cpf = ValidaCpf.toString(cpf);
        for(Cliente cliente : agencia.getClientes().listar()) {
            if(cliente.getCpf().equals(cpf)) {
                flag = true;
                break;
            }// if
        }// for
        
        if(flag) {

            String[] opcoes = {"Fundamental", "Médio", "Superior"};
            String escolha = ((String) JOptionPane.showInputDialog(null, "Novo valor do campo"
                    + " escolaridade", null, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]));
            
            if(escolha == null)
                return;
            
            Cliente cliente = ((Cliente) agencia.getClientes().buscar(cpf));
            cliente.setEscolaridade(escolha);
            
            JOptionPane.showMessageDialog(null, "Atualização realizada com sucesso");

            
        } else
            JOptionPane.showMessageDialog(null, "CPF não cadastrado nessa agência");

    }//GEN-LAST:event_jButton3ActionPerformed

    public static void editarCliente(int nroAgen) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EditarCliente edCli = new EditarCliente(nroAgen);
                edCli.setLocationRelativeTo(null);
                edCli.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
    private int nroAgen;
    private ArrayList<String> cpfs;
}
