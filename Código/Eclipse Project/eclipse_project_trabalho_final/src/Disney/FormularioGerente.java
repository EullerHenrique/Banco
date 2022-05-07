package Disney;

import DeathStars.Agencia;
import Falcon.ValidaCpf;
import StormTroppers.Funcionario;
import StormTroppers.Gerente;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class FormularioGerente extends javax.swing.JFrame {

    public FormularioGerente(int nroAgencia) {
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
        nro_carteira = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        sexo = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        senha = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();
        confirm_senha = new javax.swing.JPasswordField();
        jLabel11 = new javax.swing.JLabel();
        salario = new javax.swing.JTextField();
        formacao = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Novo Gerente");
        setMinimumSize(new java.awt.Dimension(700, 450));
        setPreferredSize(new java.awt.Dimension(700, 450));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridLayout(12, 1, 0, 5));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Informações");
        getContentPane().add(jLabel1);

        jLabel2.setText(" do Novo Gerente");
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

        jLabel6.setText("EstadoCivil");
        getContentPane().add(jLabel6);

        estado_civil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Casado(a)", "Solteiro(a)", "Divorciado(a)", "Viúvo(a)" }));
        getContentPane().add(estado_civil);

        jLabel7.setText("Número da Carteira");
        getContentPane().add(jLabel7);
        getContentPane().add(nro_carteira);

        jLabel8.setText("Sexo");
        getContentPane().add(jLabel8);

        sexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Feminino" }));
        getContentPane().add(sexo);

        jLabel9.setText("Senha");
        getContentPane().add(jLabel9);
        getContentPane().add(senha);

        jLabel10.setText("Confirme sua senha");
        getContentPane().add(jLabel10);
        getContentPane().add(confirm_senha);

        jLabel11.setText("Salário");
        getContentPane().add(jLabel11);
        getContentPane().add(salario);

        formacao.setText("Possui formaçao");
        getContentPane().add(formacao);

        jButton1.setText("Preencher Endereço");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        getContentPane().add(jLabel12);

        jButton2.setText("Confirmar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        FormularioEndereco.formularioEndereco(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        if(this.nome.getText().equals("") || this.cpf.getText().equals("") ||
           this.rg.getText().equals("") || this.nro_carteira.getText().equals("")
           || new String(this.senha.getPassword()).equals("") || this.salario
           .getText().equals("")){

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

        ArrayList<String> cpfs = new ArrayList<String>();

        for(Agencia agencia : Main.getAdmin().getAgencias().listar())
            for(Funcionario funcionario : agencia.getFuncionarios().listar())
                cpfs.add(funcionario.getCpf());

        if(cpfs.contains(ValidaCpf.toString(cpf))) {

            JOptionPane.showMessageDialog(null, "CPF digiado já pertence à "
                    + "outro funcionário");
            return;

        }// if
        
        Agencia agencia = (Agencia) Main.getAdmin().getAgencias().buscar
            (this.nroAgencia);
        
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
        
        if(!(new String(this.senha.getPassword())).equals(new String(this
                .confirm_senha.getPassword()))) {
            
            JOptionPane.showMessageDialog(null, "Senhas não são iguais");
            this.senha.setText("");
            this.confirm_senha.setText("");

            return;

        }// if

        try {

            float salario = Float.parseFloat(this.salario.getText());
            
            Gerente gerente = new Gerente(this.nome.getText(), ValidaCpf.toString(cpf),
                ((String) this.estado_civil.getSelectedItem()), EnderecoAuxiliar
                .pop(0), this.nro_carteira.getText(), this.rg.getText(), "Ge"
                + "rente", sexo, salario, dataIngresso, this.nroAgencia, this
                .formacao.isSelected(), (new String(this.senha.getPassword())));
            
            agencia.getFuncionarios().excluir(agencia.getGerente().getCpf());
            agencia.getFuncionarios().inserir(gerente);
            agencia.setGerente(gerente);
            
            EnderecoAuxiliar.limparArrs();
            this.setVisible(false);

            JOptionPane.showMessageDialog(null, "Novo gerente cadastrado com su"
                    + "cesso");

        } catch(NumberFormatException exc) {

            JOptionPane.showMessageDialog(null, "O salário deve ser um número");
        
        } catch(Exception exc) {
            
            JOptionPane.showMessageDialog(null, exc.toString());

        }// try catch

    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        EnderecoAuxiliar.limparArrs();
        this.setVisible(false);

    }//GEN-LAST:event_formWindowClosing

    public static void formularioGerente(int nroAgencia) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormularioGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormularioGerente formG = new FormularioGerente(nroAgencia);
                formG.setLocationRelativeTo(null);
                formG.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField confirm_senha;
    private javax.swing.JTextField cpf;
    private javax.swing.JComboBox<String> estado_civil;
    private javax.swing.JRadioButton formacao;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JTextField nro_carteira;
    private javax.swing.JTextField rg;
    private javax.swing.JTextField salario;
    private javax.swing.JPasswordField senha;
    private javax.swing.JComboBox<String> sexo;
    // End of variables declaration//GEN-END:variables
    private int nroAgencia;
}
