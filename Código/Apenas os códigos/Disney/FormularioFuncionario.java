package Disney;

import DeathStars.Agencia;
import Falcon.ValidaCpf;
import StormTroppers.Funcionario;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class FormularioFuncionario extends javax.swing.JFrame {

    public FormularioFuncionario(int nroAgencia) {
        this.nroAgencia = nroAgencia;
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cpf = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        rg = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        estado_civil = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        nroCarteira = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cargo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        sexo = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        salario = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Novo Funcionário");
        setMinimumSize(new java.awt.Dimension(700, 450));
        setPreferredSize(new java.awt.Dimension(700, 450));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridLayout(10, 2, 0, 5));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Informações do novo");
        getContentPane().add(jLabel1);

        jLabel2.setText(" Funcionário");
        getContentPane().add(jLabel2);

        jLabel3.setText("Nome");
        getContentPane().add(jLabel3);
        getContentPane().add(nome);

        jLabel4.setText("CPF (Apenas nº)");
        getContentPane().add(jLabel4);
        getContentPane().add(cpf);

        jLabel5.setText("RG");
        getContentPane().add(jLabel5);
        getContentPane().add(rg);

        jLabel6.setText("Estado Civil");
        getContentPane().add(jLabel6);

        estado_civil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Casado(a)", "Solteiro(a)", "Divorciado(a)", "Viúvo(a)" }));
        getContentPane().add(estado_civil);

        jLabel7.setText("Número da Carteira");
        getContentPane().add(jLabel7);
        getContentPane().add(nroCarteira);

        jLabel8.setText("Cargo");
        getContentPane().add(jLabel8);
        getContentPane().add(cargo);

        jLabel9.setText("Sexo");
        getContentPane().add(jLabel9);

        sexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Feminino" }));
        getContentPane().add(sexo);

        jLabel12.setText("Salário");
        getContentPane().add(jLabel12);
        getContentPane().add(salario);

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
           this.rg.getText().equals("") || this.nroCarteira.getText().equals("")
           || this.cargo.getText().equals("") || this.salario.getText()
           .equals("")) {

            JOptionPane.showMessageDialog(null, "Todos os campos devem ser pree"
                    + "nchidos!!");
            
            return;

        }// if
        
        String cpf  = this.cpf.getText();
        if(!ValidaCpf.ehNumerico(cpf) || !ValidaCpf.validaCpf(cpf)) {

            this.cpf.setText("");

            JOptionPane.showMessageDialog(null, "CPF inválido");
            return;
            
        }// if
        
        Agencia agencia = ((Agencia) Main.getAdmin().getAgencias()
                    .buscar(nroAgencia));
        
        ArrayList<String> cpfs = new ArrayList<String>();

        for(Funcionario funcionario : agencia.getFuncionarios().listar())
            cpfs.add(funcionario.getCpf());
        
        if(cpfs.contains(ValidaCpf.toString(cpf))) {
            
            JOptionPane.showMessageDialog(null, "CPF digitado já pertence à out"
                    + "ro funcionário");
            return;
            
        }// if
        
        if(EnderecoAuxiliar.sizeArr(0) == 0) {

            JOptionPane.showMessageDialog(null, "Preencha o endereço.");
            return;

        } //if
        
        String dataIngresso = (new SimpleDateFormat("dd/MM/yyyy"))
                        .format(new Date(System.currentTimeMillis()));

        char sexo;
        String aux = ((String) this.sexo.getSelectedItem());
        if(aux.equals("Masculino"))
            sexo = 'M';
        else
            sexo = 'F';
        
        try {
            
            float salario = Float.parseFloat(this.salario.getText());
            
            Funcionario funcionario = new Funcionario(this.nome.getText(),
                ValidaCpf.toString(cpf), ((String)this.estado_civil
                .getSelectedItem()), EnderecoAuxiliar.pop(0),
                this.nroCarteira.getText(), this.rg.getText(),
                this.cargo.getText(), sexo, salario, false);

            agencia.getFuncionarios().inserir(funcionario);
            
            EnderecoAuxiliar.limparArrs();
            this.setVisible(false);
            
            JOptionPane.showMessageDialog(null, "Funcionário cadastrado com suc"
                    + "esso!");

        } catch(NumberFormatException exc) {

            JOptionPane.showMessageDialog(null, "O salário deve ser um número");

        } catch(Exception exc) {
            
            JOptionPane.showMessageDialog(null, exc.toString());

        }// try catch

    }//GEN-LAST:event_jButton2ActionPerformed

    public static void formularioFuncionario(int nroAgencia) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormularioFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormularioFuncionario formF = new FormularioFuncionario(nroAgencia);
                formF.setLocationRelativeTo(null);
                formF.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cargo;
    private javax.swing.JTextField cpf;
    private javax.swing.JComboBox<String> estado_civil;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField nome;
    private javax.swing.JTextField nroCarteira;
    private javax.swing.JTextField rg;
    private javax.swing.JTextField salario;
    private javax.swing.JComboBox<String> sexo;
    // End of variables declaration//GEN-END:variables
    private int nroAgencia;
}
