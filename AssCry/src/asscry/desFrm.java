/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asscry;

import java.awt.FileDialog;
import java.io.File;
import javax.swing.JOptionPane;
import static org.bouncycastle.crypto.tls.SignatureAlgorithm.rsa;

/**
 *
 * @author duymi
 */
public class desFrm extends javax.swing.JFrame {

    /**
     * Creates new form desFrm
     */
    public desFrm() {
        initComponents();
        this.setTitle("Mã hóa DES");
    }
    private desKeygenerate deskey;
    private clsDES des;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtFile = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btKey = new javax.swing.JButton();
        btnBw = new javax.swing.JButton();
        btnKey = new javax.swing.JButton();
        tfKey = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnMahoa = new javax.swing.JButton();
        btDecr = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Chọn một file để mã hóa:");

        btKey.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btKey.setText("Key Generation");
        btKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btKeyActionPerformed(evt);
            }
        });

        btnBw.setText("...");
        btnBw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBwActionPerformed(evt);
            }
        });

        btnKey.setText("...");
        btnKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeyActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Chọn Key :");

        btnMahoa.setText("Encrypt");
        btnMahoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMahoaActionPerformed(evt);
            }
        });

        btDecr.setText("Decrypt");
        btDecr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDecrActionPerformed(evt);
            }
        });

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btKey))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tfKey, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFile))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnBw, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                                    .addComponent(btnKey, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnMahoa, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btDecr, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btKey, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBw, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFile, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfKey, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKey, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btDecr, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMahoa, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btKeyActionPerformed
        // TODO add your handling code here:
        deskey = new desKeygenerate();
        deskey.saveKey();

    }//GEN-LAST:event_btKeyActionPerformed

    private void btnBwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBwActionPerformed
        // TODO add your handling code here:
        File file = getFileDialogOpen("*.*");
        if(file== null)
        return;
        txtFile.setText(file.getAbsolutePath());

    }//GEN-LAST:event_btnBwActionPerformed

    private void btnKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeyActionPerformed
        // TODO add your handling code here:
        File kfile = getFileDialogOpen("*.*");
        if(kfile== null)
        return;
        tfKey.setText(kfile.getAbsolutePath());
    }//GEN-LAST:event_btnKeyActionPerformed

    private void btnMahoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMahoaActionPerformed
        // TODO add your handling code here:
        File directory = new File("");
        String outPut = directory.getAbsolutePath();

        des = new clsDES();
        des.desEncrypt(tfKey.getText(), txtFile.getText(), outPut);
        JOptionPane.showMessageDialog(null, "Mã hóa thành công^^","Done",JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_btnMahoaActionPerformed

    private void btDecrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDecrActionPerformed
        // TODO add your handling code here:

        File directory = new File("");
        String outPut = directory.getAbsolutePath();

        des = new clsDES();
        des.desDecrypt(tfKey.getText(), txtFile.getText(), outPut);
        JOptionPane.showMessageDialog(null, "Giải mã thành công^^","Done",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btDecrActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    /**
     * @param args the command line arguments
     */
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDecr;
    private javax.swing.JButton btKey;
    private javax.swing.JButton btnBw;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnKey;
    private javax.swing.JButton btnMahoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField tfKey;
    private javax.swing.JTextField txtFile;
    // End of variables declaration//GEN-END:variables

private File getFileDialogOpen(String string) {
        FileDialog fd = new FileDialog(this, "Chọn file", FileDialog.LOAD);
        fd.setFile(string);
        fd.setVisible(true);
        if (fd.getFile()==null) {
            return null;
        }
        File file = new File(fd.getDirectory()+fd.getFile());
        if(!file.canRead()){
            JOptionPane.showMessageDialog(null, "File bạn chọn không thể đọc.",
                    "Error",JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return file;
    }

}
