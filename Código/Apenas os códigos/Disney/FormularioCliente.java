package Disney;

import DeathStars.Agencia;
import Falcon.ValidaCpf;
import StormTroppers.Cliente;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FormularioCliente extends javax.swing.JFrame {

    public FormularioCliente(int nroAgen) {
        this.nroAgen = nroAgen;
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        nome = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        cpf = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        estado_civil = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        data = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        escolaridade = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jTextField3.setText("jTextField3");

        jTextField4.setText("jTextField4");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Novo Cliente");
        setMinimumSize(new java.awt.Dimension(700, 450));
        setPreferredSize(new java.awt.Dimension(700, 450));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridLayout(7, 2, 0, 5));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Informações");
        getContentPane().add(jLabel2);

        jLabel11.setText(" do Cliente");
        getContentPane().add(jLabel11);

        jLabel19.setText("Nome");
        getContentPane().add(jLabel19);
        getContentPane().add(nome);

        jLabel18.setText("CPF (Apenas números)");
        getContentPane().add(jLabel18);
        getContentPane().add(cpf);

        jLabel3.setText("Estado Civil");
        getContentPane().add(jLabel3);

        estado_civil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Casado(a)", "Solteiro(a)", "Divorciado(a)", "Viúvo(a)" }));
        getContentPane().add(estado_civil);

        jLabel4.setText("Dia de Nascimento (dd/mm/yyyy)");
        getContentPane().add(jLabel4);

        data.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        data.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(data);

        jLabel5.setText("Escoladidade");
        getContentPane().add(jLabel5);

        escolaridade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fundamental", "Médio", "Superior" }));
        getContentPane().add(escolaridade);

        jButton1.setText("Preencher endereço");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);

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
        
        EnderecoAuxiliar.limparArrs();
        this.setVisible(false);

    }//GEN-LAST:event_formWindowClosing

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        FormularioEndereco.formularioEndereco(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(this.nome.getText().equals("") || this.cpf.getText().equals("") ||
           this.data.getText().equals("")) {

            JOptionPane.showMessageDialog(null, "Todos os dados devem ser preenchidos");
            return;

        }// if
        
        String cpf = this.cpf.getText();
        if(!ValidaCpf.ehNumerico(cpf) || !ValidaCpf.validaCpf(cpf)) {
            
            JOptionPane.showMessageDialog(null, "CPF inválido");
            return;
            
        }// cpf

        Agencia agencia = ((Agencia) Main.getAdmin().getAgencias().buscar(this.nroAgen));
        
        ArrayList<String> cpfs = new ArrayList<String>();
        
        for(Cliente cliente : agencia.getClientes().listar())
            cpfs.add(cliente.getCpf());
        
        if(cpfs.contains(ValidaCpf.toString(cpf))) {
            
            JOptionPane.showMessageDialog(null, "O CPF digitado já pertence à o"
                    + "utro cliente");
            return;
            
        }// if

        if(EnderecoAuxiliar.sizeArr(0) == 0) {

            JOptionPane.showMessageDialog(null, "Preencha o endereço do cliente.");
            return;

        }// if

        agencia.getClientes().cadastar(this.nome.getText(), ValidaCpf.toString(cpf),
            ((String) this.estado_civil.getSelectedItem()), EnderecoAuxiliar.pop(0),
            ((String) this.escolaridade.getSelectedItem()), this.data.getText());
        
        EnderecoAuxiliar.limparArrs();
        this.setVisible(false);        
        JOptionPane.showMessageDialog(null, "Cliente " + this.nome.getText() + " cadastrado"
                + " com sucesso");
        
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void formularioCliente(int nroAgen) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormularioCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormularioCliente formC = new FormularioCliente(nroAgen);
                formC.setLocationRelativeTo(null);
                formC.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cpf;
    private javax.swing.JFormattedTextField data;
    private javax.swing.JComboBox<String> escolaridade;
    private javax.swing.JComboBox<String> estado_civil;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField nome;
    // End of variables declaration//GEN-END:variables
    private int nroAgen;
}
