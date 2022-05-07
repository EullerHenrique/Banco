package Disney;

import DeathStars.Agencia;
import Falcon.ValidaCpf;
import Siths.DadosAgencias;
import StormTroppers.Funcionario;
import StormTroppers.Gerente;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class FormularioAgencia extends javax.swing.JFrame {

    public FormularioAgencia() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cpf = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        rg = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        estado_civil = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        nroCarteira = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        sexo = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        senha = new javax.swing.JPasswordField();
        jLabel12 = new javax.swing.JLabel();
        confirm_senha = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        salario = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        formacao = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Nova Agência");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridLayout(12, 2, 5, 5));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Informações");
        getContentPane().add(jLabel10);

        jLabel7.setText(" do Gerente");
        getContentPane().add(jLabel7);

        jLabel2.setText("Nome");
        getContentPane().add(jLabel2);
        getContentPane().add(nome);

        jLabel3.setText("CPF (Apenas nº)");
        getContentPane().add(jLabel3);

        cpf.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(cpf);

        jLabel6.setText("RG");
        getContentPane().add(jLabel6);
        getContentPane().add(rg);

        jLabel4.setText("Estado Civil");
        getContentPane().add(jLabel4);

        estado_civil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Casado(a)", "Solteiro(a)", "Divorciado(a)", "Viúvo(a)" }));
        getContentPane().add(estado_civil);

        jLabel5.setText("Número da Carteira");
        getContentPane().add(jLabel5);
        getContentPane().add(nroCarteira);

        jLabel8.setText("Sexo");
        getContentPane().add(jLabel8);

        sexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Feminino" }));
        getContentPane().add(sexo);

        jLabel11.setText("Senha");
        getContentPane().add(jLabel11);
        getContentPane().add(senha);

        jLabel12.setText("Confirme sua senha");
        getContentPane().add(jLabel12);
        getContentPane().add(confirm_senha);

        jLabel9.setText("Salário");
        getContentPane().add(jLabel9);
        getContentPane().add(salario);

        jButton2.setText("Endereço agência");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);

        jButton3.setText("Endereço gerente");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);

        formacao.setText("Possui formação");
        getContentPane().add(formacao);

        jButton1.setText("Confirmar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        EnderecoAuxiliar.limparArrs();
        this.setVisible(false);

    }//GEN-LAST:event_formWindowClosing

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(this.nome.getText().equals("") || this.cpf.getText().equals("") ||
           this.rg.getText().equals("") || this.nroCarteira.getText().equals("")
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
        
        if(EnderecoAuxiliar.sizeArr(0) == 0 || EnderecoAuxiliar.sizeArr(1) == 0
                ) {
            JOptionPane.showMessageDialog(null, "Os dois endereços devem ser pr"
                    + "eenchidos.");
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
            
            // Cria gerente
            Gerente gerente = new Gerente(this.nome.getText(), ValidaCpf
                .toString(cpf), ((String) this.estado_civil.getSelectedItem()),
                EnderecoAuxiliar.pop(1), this.nroCarteira.getText(),
                this.rg.getText(), "Gerente", sexo, salario, dataIngresso,
                DadosAgencias.getProxNro(), this.formacao.isSelected(),
                new String(this.senha.getPassword()));

            // Cadastra Agência
            Main.getAdmin().getAgencias().cadastar("Agência " +
                DadosAgencias.getProxNro(), EnderecoAuxiliar.pop(0), gerente);
            
            // Insere gerente como funcionario da Agência
            ((Agencia) Main.getAdmin().getAgencias().buscar(DadosAgencias
                    .getProxNro() - 1)).getFuncionarios().inserir(gerente);

            EnderecoAuxiliar.limparArrs();
            this.setVisible(false);

            JOptionPane.showMessageDialog(null, "\"Agência " + (DadosAgencias
                .getProxNro() - 1) + "\" cadastrada com sucesso, caso q"
                + "ueira mudar o nome da Agência, basta editar as infor"
                + "mações dela pela opções \"EDITAR NOME DE AGÊNCIA\" n"
                + "o menu anterior");

        } catch(NumberFormatException exc) {

            JOptionPane.showMessageDialog(null, "O salário deve ser um número");
        
        } catch(Exception exc) {
            
            JOptionPane.showMessageDialog(null, exc.toString());
            
        }// try catch
                
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        FormularioEndereco.formularioEndereco(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        FormularioEndereco.formularioEndereco(1);
    }//GEN-LAST:event_jButton3ActionPerformed

    public static void formularioAgencia() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormularioAgencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioAgencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioAgencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioAgencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormularioAgencia formularioAgen = new FormularioAgencia();
                formularioAgen.setLocationRelativeTo(null);
                formularioAgen.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.JPasswordField confirm_senha;
    private javax.swing.JTextField cpf;
    private javax.swing.JComboBox<String> estado_civil;
    private javax.swing.JRadioButton formacao;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
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
    private javax.swing.JTextField nroCarteira;
    private javax.swing.JTextField rg;
    private javax.swing.JTextField salario;
    private javax.swing.JPasswordField senha;
    private javax.swing.JComboBox<String> sexo;
    // End of variables declaration//GEN-END:variables
}
