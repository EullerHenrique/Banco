package Disney;

import DeathStars.Agencia;
import StormTroppers.Cliente;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class FormularioConta extends javax.swing.JFrame {

    public FormularioConta(int nroAgen, String cpf) {
        this.nroAgen = nroAgen;
        this.cpf = cpf;
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tipo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        senha = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        confirm_senha = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Nova Conta");
        setMinimumSize(new java.awt.Dimension(700, 450));
        setPreferredSize(new java.awt.Dimension(700, 450));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridLayout(5, 2, 0, 5));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Informações");
        getContentPane().add(jLabel1);

        jLabel2.setText(" da Conta");
        getContentPane().add(jLabel2);

        jLabel6.setText("Tipo de Conta");
        getContentPane().add(jLabel6);

        tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Conta Corrente", "Conta Poupança", "Conta Salário" }));
        getContentPane().add(tipo);

        jLabel3.setText("Senha");
        getContentPane().add(jLabel3);
        getContentPane().add(senha);

        jLabel4.setText("Confirme sua senha");
        getContentPane().add(jLabel4);
        getContentPane().add(confirm_senha);
        getContentPane().add(jLabel5);

        jButton1.setText("Confirmar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        int tipo;
        if(((String) this.tipo.getSelectedItem()).equals("Conta Corrente"))
            tipo = 1;
        else if(((String) this.tipo.getSelectedItem()).equals("Conta Poupança"))
            tipo = 2;
        else
            tipo = 3;
        
        if((new String(this.senha.getPassword())).equals("")
           || (new String(this.confirm_senha.getPassword())).equals("")) {

            JOptionPane.showMessageDialog(null, "Todos os campos devem estar preenchidos");
            return;

        }// if
        
        String senha = new String(this.senha.getPassword());
        String confirm_senha = new String(this.confirm_senha.getPassword());
        
        if(!senha.equals(confirm_senha)) {
            JOptionPane.showMessageDialog(null, "Senha não são iguais");
            return;
        }// if

        String dataIngresso = (new SimpleDateFormat("dd/MM/yyyy"))
            .format(new Date(System.currentTimeMillis()));

        Agencia agencia = ((Agencia) Main.getAdmin().getAgencias()
            .buscar(this.nroAgen));
        for(Cliente cliente : agencia.getClientes().listar()) {
            if(cliente.getCpf().equals(this.cpf)) {

                agencia.getContas().cadastar(cliente, senha, dataIngresso, tipo);

                this.setVisible(false);
                JOptionPane.showMessageDialog(null, "Conta criada com sucesso");

                return;

            }// if
        }// for
        
        JOptionPane.showMessageDialog(null, "CPF não corresponde a nenhum cliente dessa"
                + "agência");

    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.setVisible(false);
    }//GEN-LAST:event_formWindowClosing

    public static void formularioConta(int nroAgen, String cpf) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormularioConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormularioConta formC = new FormularioConta(nroAgen, cpf);
                formC.setLocationRelativeTo(null);
                formC.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField confirm_senha;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPasswordField senha;
    private javax.swing.JComboBox<String> tipo;
    // End of variables declaration//GEN-END:variables
    private int nroAgen;
    private String cpf;
}
