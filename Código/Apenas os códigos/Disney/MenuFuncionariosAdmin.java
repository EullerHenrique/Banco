package Disney;

import DeathStars.Agencia;
import StormTroppers.Funcionario;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MenuFuncionariosAdmin extends javax.swing.JFrame {

    public MenuFuncionariosAdmin() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Admin - FUN");
        setMinimumSize(new java.awt.Dimension(600, 450));
        setPreferredSize(new java.awt.Dimension(600, 450));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridLayout(4, 1, 0, 5));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MENU FUNCIONÁRIOS - ADMIN");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel1);

        jButton1.setText("REGISTRAR NOVO FUNCIONÁRIO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);

        jButton3.setText("REMOVER FUNCIONÁRIO");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);

        jButton4.setText("BUSCAR FUNCIONÁRIO");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        ArrayList<String> nros = new ArrayList<String>();
        
        for(Agencia agencia : Main.getAdmin().getAgencias().listar())
            nros.add("" + agencia.getNum());
        
        if(nros.size() != 0) {
            
            ArrayList<String> cpfs = new ArrayList<String>();
            String aux = ((String) JOptionPane.showInputDialog(null, "Nº da agênc"
                + "ia do funcionário a ser exibido", null, JOptionPane
                .QUESTION_MESSAGE, null, nros.toArray(), nros.get(0)));
            
            if(aux == null)
                return;
            
            int nroAgen = Integer.parseInt(aux);
            Agencia agencia = ((Agencia) Main.getAdmin().getAgencias()
                    .buscar(nroAgen));
            
            for(Funcionario funcionario : agencia.getFuncionarios().listar())
                cpfs.add(funcionario.getCpf());

            if(cpfs.size() != 0) {

                String cpfEscolhido = ((String) JOptionPane.showInputDialog(null
                    ,"CPF do funcionário a ser exibido", null, JOptionPane
                    .QUESTION_MESSAGE, null, cpfs.toArray(), cpfs.get(0)));

                JOptionPane.showMessageDialog(null, "Informações do funcionário"
                    + " selecionado\n\n" + agencia.getFuncionarios()
                    .buscar(cpfEscolhido).toString());
                
            } else
                JOptionPane.showMessageDialog(null, "Não há funcionários nessa "
                        + "agência");

        } else
            JOptionPane.showMessageDialog(null, "Não há agências cadastradas");

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        ArrayList<String> nros = new ArrayList<String>();
        
        for(Agencia agencia : Main.getAdmin().getAgencias().listar())
            nros.add("" + agencia.getNum());
        
        if(nros.size() != 0) {
            
            String aux = ((String) JOptionPane.showInputDialog(null, "Nº da agênc"
                + "ia em que receberá o novo funcionário", null, JOptionPane
                .QUESTION_MESSAGE, null, nros.toArray(), nros.get(0)));
            
            if(aux == null)
                return;
            
            int nroAgen = Integer.parseInt(aux);
            FormularioFuncionario.formularioFuncionario(nroAgen);
            
        } else
            JOptionPane.showMessageDialog(null, "Não há agências cadastradas");
            
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.setVisible(false);
    }//GEN-LAST:event_formWindowClosing

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        ArrayList<String> nros = new ArrayList<String>();
        
        for(Agencia agencia : Main.getAdmin().getAgencias().listar())
            nros.add("" + agencia.getNum());
        
        if(nros.size() != 0) {
            
            ArrayList<String> cpfs = new ArrayList<String>();
            String aux = ((String) JOptionPane.showInputDialog(null, "Nº da agênc"
                + "ia do funcionário a ser removido", null, JOptionPane
                .QUESTION_MESSAGE, null, nros.toArray(), nros.get(0)));
            
            if(aux == null)
                return;
            
            int nroAgen = Integer.parseInt(aux);
            Agencia agencia = ((Agencia) Main.getAdmin().getAgencias()
                    .buscar(nroAgen));
            
            for(Funcionario funcionario : agencia.getFuncionarios().listar()) {

                if(!funcionario.isGerente())
                    cpfs.add(funcionario.getCpf());

            }// for

            if(cpfs.size() != 0) {

                String cpfEscolhido = ((String) JOptionPane.showInputDialog(null
                    ,"CPF do funcionário a ser removido", null, JOptionPane
                    .QUESTION_MESSAGE, null, cpfs.toArray(), cpfs.get(0)));

                agencia.getFuncionarios().excluir(cpfEscolhido);

                JOptionPane.showMessageDialog(null, "Funcionário removido com s"
                        + "ucesso");
                
            } else
                JOptionPane.showMessageDialog(null, "Não há funcionários nessa "
                        + "agência");

        } else
            JOptionPane.showMessageDialog(null, "Não há agências cadastradas");

    }//GEN-LAST:event_jButton3ActionPerformed

    public static void menuFuncionariosAdmin() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuFuncionariosAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuFuncionariosAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuFuncionariosAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuFuncionariosAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MenuFuncionariosAdmin menuFunA = new MenuFuncionariosAdmin();
                menuFunA.setLocationRelativeTo(null);
                menuFunA.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
