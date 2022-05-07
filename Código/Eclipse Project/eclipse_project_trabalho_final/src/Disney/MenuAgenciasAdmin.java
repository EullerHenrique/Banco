package Disney;

import DeathStars.Agencia;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MenuAgenciasAdmin extends javax.swing.JFrame {

    public MenuAgenciasAdmin() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Admin - AGE");
        setMinimumSize(new java.awt.Dimension(700, 450));
        setPreferredSize(new java.awt.Dimension(700, 450));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridLayout(6, 1, 0, 5));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MENU AGÊNCIAS - ADMIN");
        getContentPane().add(jLabel1);

        jButton1.setText("RESGISTAR NOVA AGÊNCIA");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);

        jButton2.setText("EDITAR NOME DE AGÊNCIA");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);

        jButton3.setText("NOVO GERENTE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);

        jButton4.setText("REMOVER AGÊNCIA");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);

        jButton6.setText("BUSCAR AGÊNCIA");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        JOptionPane.showMessageDialog(null, "Entre com os dados do gerente e o "
                + "endereço da nova agência");
        FormularioAgencia.formularioAgencia();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.setVisible(false);
    }//GEN-LAST:event_formWindowClosing

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        ArrayList<String> nros = new ArrayList<String>();
        
        for(Agencia agen : Main.getAdmin().getAgencias().listar())
            nros.add("" + agen.getNum());
        
        if(nros.size() != 0) {
        
            String aux = ((String) JOptionPane.showInputDialog(null, "Agência que ter"
                    + "á o gerente alterado", null, JOptionPane.QUESTION_MESSAGE,
                    null, nros.toArray(), nros.get(0)));
            
            if(aux == null)
                return;
            
            int nroAgen = Integer.parseInt(aux);
            Agencia agencia = ((Agencia) Main.getAdmin().getAgencias().buscar(nroAgen));
            agencia.getFuncionarios().excluir(agencia.getGerente().getCpf());
            FormularioGerente.formularioGerente(nroAgen);
            
        } else
            JOptionPane.showMessageDialog(null, "Não há agências cadastradas");

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        ArrayList<String> nros = new ArrayList<String>();
        
        for(Agencia agen : Main.getAdmin().getAgencias().listar())
            nros.add("" + agen.getNum());

        if(nros.size() != 0) {

            String aux = ((String) JOptionPane.showInputDialog(null, "Qual agência de"
                    + "ve ser removida", null, JOptionPane.QUESTION_MESSAGE, null,
                    nros.toArray(), nros.get(0)));
            
            if(aux == null)
                return;
            
            int nroAgen = Integer.parseInt(aux);
            Main.getAdmin().getAgencias().excluir(nroAgen);
            JOptionPane.showMessageDialog(null, "Agencia de número " + nroAgen + " "
                    + "removida com sucesso");
            
        } else
            JOptionPane.showMessageDialog(null, "Não há agências cadastradas");

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        
        ArrayList<String> nros = new ArrayList<String>();
        
        for(Agencia agen : Main.getAdmin().getAgencias().listar())
            nros.add("" + agen.getNum());
        
        if(nros.size() != 0) {

            String aux = ((String) JOptionPane.showInputDialog(null, "Escolha uma agê"
                    + "ncia", null, JOptionPane.QUESTION_MESSAGE, null,
                    nros.toArray(), nros.get(0)));
            
            if(aux == null)
                return;
            
            int nroAgen = Integer.parseInt(aux);
            JOptionPane.showMessageDialog(null, "Informações da agência escolhida\n\n"
                    + ((Agencia) Main.getAdmin().getAgencias().buscar(nroAgen))
                    .toString());

        } else
            JOptionPane.showMessageDialog(null, "Não há agências cadastradas");
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ArrayList<String> nros = new ArrayList<String>();
        
        for(Agencia agencia : Main.getAdmin().getAgencias().listar())
            nros.add("" + agencia.getNum());
        
        if(nros.size() != 0) {
            
            String aux = ((String) JOptionPane.showInputDialog(null, "Nº da agênc"
                + "ia que terá o nome trocado", null, JOptionPane.QUESTION_MESSAGE,
                null, nros.toArray(), nros.get(0)));
            
            if(aux == null)
                return;
            
            int nroAgen = Integer.parseInt(aux);
            String nome = JOptionPane.showInputDialog(
                    ((Agencia)Main.getAdmin().getAgencias().buscar(nroAgen))
                    .getNome() + "\n\nNovo nome da Agencia");
            
            ((Agencia) Main.getAdmin().getAgencias().buscar(nroAgen))
                    .setNome(nome);
            
            JOptionPane.showMessageDialog(null, "Nome alterado para " +
                ((Agencia)Main.getAdmin().getAgencias().buscar(nroAgen))
                .getNome());

        } else
            JOptionPane.showMessageDialog(null, "Não há agências cadastradas");

    }//GEN-LAST:event_jButton2ActionPerformed

    public static void menuAgenciasAdmin() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuAgenciasAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuAgenciasAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuAgenciasAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuAgenciasAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MenuAgenciasAdmin menuAgenA = new MenuAgenciasAdmin();
                menuAgenA.setLocationRelativeTo(null);
                menuAgenA.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
