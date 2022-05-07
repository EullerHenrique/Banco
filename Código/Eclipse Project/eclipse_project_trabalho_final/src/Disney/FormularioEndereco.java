package Disney;

import Falcon.Endereco;
import javax.swing.JOptionPane;

public class FormularioEndereco extends javax.swing.JFrame {

    public FormularioEndereco(int tipo) {
        initComponents();
        this.tipo = tipo;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTextField6 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lograd = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        nome = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        nroCasa = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        estado = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cidade = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        bairro = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        jButton1.setText("jButton1");

        jTextField6.setText("jTextField6");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Novo Endereço");
        setMinimumSize(new java.awt.Dimension(700, 450));
        setPreferredSize(new java.awt.Dimension(700, 450));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridLayout(8, 2, 0, 5));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Informações");
        getContentPane().add(jLabel1);

        jLabel2.setText(" do Endereço");
        getContentPane().add(jLabel2);

        jLabel3.setText("Logradouro");
        getContentPane().add(jLabel3);
        getContentPane().add(lograd);

        jLabel4.setText("Nome");
        getContentPane().add(jLabel4);
        getContentPane().add(nome);

        jLabel5.setText("Nº da casa");
        getContentPane().add(jLabel5);
        getContentPane().add(nroCasa);

        jLabel6.setText("Estado");
        getContentPane().add(jLabel6);

        estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AP", "AL", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        getContentPane().add(estado);

        jLabel7.setText("Cidade");
        getContentPane().add(jLabel7);
        getContentPane().add(cidade);

        jLabel8.setText("Bairro");
        getContentPane().add(jLabel8);
        getContentPane().add(bairro);
        getContentPane().add(jLabel10);

        jButton2.setText("Confirmar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.setVisible(false);
    }//GEN-LAST:event_formWindowClosing

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(this.lograd.getText().equals("") || this.nome.getText().equals("") ||
           this.bairro.getText().equals("") || this.cidade.getText().equals("")
           || this.nroCasa.getText().equals("")) {

            JOptionPane.showMessageDialog(null, "Todos os campos devem ser pree"
                    + "nchidos!!");

            return;

        }// if
        
        try {

            int nroCasa = Integer.parseInt(this.nroCasa.getText());
            
            Endereco endereco = new Endereco(nroCasa, this.lograd.getText(),
                    this.nome.getText(), this.bairro.getText(), this.cidade.
                    getText(), ((String) this.estado.getSelectedItem()));
            
            EnderecoAuxiliar.push(endereco, this.tipo);
            
            this.setVisible(false);

        } catch(NumberFormatException exc) {
            
            JOptionPane.showMessageDialog(null, "O número da casa deve ser um n"
                    + "úmero inteiro");
            
        } catch(Exception exc) {
            
            JOptionPane.showMessageDialog(null, exc.toString());
            
        }// try catch
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void formularioEndereco(int tipo) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormularioEndereco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioEndereco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioEndereco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioEndereco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormularioEndereco formE =  new FormularioEndereco(tipo);
                formE.setLocationRelativeTo(null);
                formE.setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bairro;
    private javax.swing.JTextField cidade;
    private javax.swing.JComboBox<String> estado;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField lograd;
    private javax.swing.JTextField nome;
    private javax.swing.JTextField nroCasa;
    // End of variables declaration//GEN-END:variables
    private int tipo;
}
