/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_laba_2;

public class MainJFrame extends javax.swing.JFrame {

    Surface s;
    Client c;

    public MainJFrame() {
        initComponents();

        s = new Surface();
        //setVisible(true);
        panel.add(s);
        s.setSize(panel.getSize());
        panel.addMouseListener(s);
        panel.addKeyListener(s);
        addWindowListener(new HelpListener());
        // timer.start();
        s.setVisible(true);
        pack();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        hostLabel = new javax.swing.JLabel();
        hostEdit = new javax.swing.JTextField();
        portLabel = new javax.swing.JLabel();
        portInputEdit = new javax.swing.JTextField();
        startClientButton = new javax.swing.JButton();
        startServerButton = new javax.swing.JButton();
        statusLabel = new javax.swing.JLabel();
        portOutputEdit = new javax.swing.JTextField();
        portOutput = new javax.swing.JLabel();
        swapPortsButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setLocationByPlatform(true);
        setResizable(false);
        setSize(new java.awt.Dimension(666, 367));

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
                panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 458, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
                panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        hostLabel.setText("host");

        hostEdit.setText("localhost");

        portLabel.setText("port (input)");

        portInputEdit.setText("7001");
        portInputEdit.setToolTipText("");

        startClientButton.setText("Start client");
        startClientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startClientButtonActionPerformed(evt);
            }
        });

        startServerButton.setText("Start server");
        startServerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startServerButtonActionPerformed(evt);
            }
        });

        statusLabel.setFont(new java.awt.Font("Source Sans Pro", 1, 18)); // NOI18N
        statusLabel.setText("OFFLINE");

        portOutputEdit.setText("7002");
        portOutputEdit.setToolTipText("");

        portOutput.setText("port (output)");

        swapPortsButton.setText("Swap ports");
        swapPortsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                swapPortsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(portOutput)
                                                .addGap(18, 18, 18)
                                                .addComponent(swapPortsButton)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(startClientButton, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(statusLabel)
                                                        .addComponent(startServerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(hostLabel)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(hostEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(portLabel)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(portInputEdit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                                                                .addComponent(portOutputEdit, javax.swing.GroupLayout.Alignment.LEADING)))
                                                .addGap(0, 8, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(hostLabel)
                                        .addComponent(hostEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17)
                                .addComponent(portLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(portInputEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(portOutput)
                                        .addComponent(swapPortsButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(portOutputEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                                .addComponent(startClientButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(startServerButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(statusLabel)
                                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startServerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startServerButtonActionPerformed
        String host = hostEdit.getText();
        int port_in = Integer.parseInt(portInputEdit.getText());
        int port_out = Integer.parseInt(portOutputEdit.getText());
        Server server = new Server(s, host, port_out, port_in);
        server.start();

        statusLabel.setText("SERVER RUNNING");
        hostEdit.setEnabled(false);
        portInputEdit.setEnabled(false);
        portOutputEdit.setEnabled(false);

        new Thread(new Runnable() {
            public void run() {
                while (server.isAlive()) {
                }
                statusLabel.setText("OFFLINE");
                portInputEdit.setEnabled(true);
                portOutputEdit.setEnabled(true);
            }
        }).start();
    }//GEN-LAST:event_startServerButtonActionPerformed

    private void startClientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startClientButtonActionPerformed
        String host = hostEdit.getText();
        int port_in = Integer.parseInt(portInputEdit.getText());
        int port_out = Integer.parseInt(portOutputEdit.getText());
        c = new Client(s, host, port_out, port_in);
        c.start();

        statusLabel.setText("CLIENT RUNNING");
        hostEdit.setEnabled(false);
        portInputEdit.setEnabled(false);
        portOutputEdit.setEnabled(false);
        new Thread(new Runnable() {
            public void run() {
                while (c.isAlive()) {
                }
                statusLabel.setText("OFFLINE");
                portInputEdit.setEnabled(true);
                portOutputEdit.setEnabled(true);
            }
        }).start();
    }//GEN-LAST:event_startClientButtonActionPerformed

    private void swapPortsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_swapPortsButtonActionPerformed
        String temp = portInputEdit.getText();
        portInputEdit.setText(portOutputEdit.getText());
        portOutputEdit.setText(temp);
    }//GEN-LAST:event_swapPortsButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainJFrame f = new MainJFrame();
                f.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField hostEdit;
    private javax.swing.JLabel hostLabel;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField portInputEdit;
    private javax.swing.JLabel portLabel;
    private javax.swing.JLabel portOutput;
    private javax.swing.JTextField portOutputEdit;
    private javax.swing.JButton startClientButton;
    private javax.swing.JButton startServerButton;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JButton swapPortsButton;
    // End of variables declaration//GEN-END:variables

}
