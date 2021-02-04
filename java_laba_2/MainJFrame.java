/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_laba_2;

public class MainJFrame extends javax.swing.JFrame  {

    Surface s;
    Client c;
    //private final Timer timer = new Timer(30, this);
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

        clearButton.setEnabled(false);
        closeConnectionButton.setEnabled(false);
        getAllObjectsButton.setEnabled(false);
        getObjectButton.setEnabled(false);
        getObjectCountButton.setEnabled(false);
        objectCountEdit.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        hostLabel = new javax.swing.JLabel();
        hostEdit = new javax.swing.JTextField();
        portLabel = new javax.swing.JLabel();
        portEdit = new javax.swing.JTextField();
        startConnectionButton = new javax.swing.JButton();
        closeConnectionButton = new javax.swing.JButton();
        getObjectButton = new javax.swing.JButton();
        objectCountEdit = new javax.swing.JTextField();
        getObjectCountButton = new javax.swing.JButton();
        launchServerButton = new javax.swing.JButton();
        statusLabel = new javax.swing.JLabel();
        getAllObjectsButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();

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

        portLabel.setText("port");

        portEdit.setText("8888");
        portEdit.setToolTipText("");

        startConnectionButton.setText("Start connection");
        startConnectionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startConnectionButtonActionPerformed(evt);
            }
        });

        closeConnectionButton.setText("Close connection");
        closeConnectionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeConnectionButtonActionPerformed(evt);
            }
        });

        getObjectButton.setText("Get object");
        getObjectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getObjectButtonActionPerformed(evt);
            }
        });

        objectCountEdit.setText("0");

        getObjectCountButton.setText("Get objects count");
        getObjectCountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getObjectCountButtonActionPerformed(evt);
            }
        });

        launchServerButton.setText("Launch server");
        launchServerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                launchServerButtonActionPerformed(evt);
            }
        });

        statusLabel.setFont(new java.awt.Font("Source Sans Pro", 1, 18)); // NOI18N
        statusLabel.setText("CLIENT");

        getAllObjectsButton.setText("Get all objects");
        getAllObjectsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getAllObjectsButtonActionPerformed(evt);
            }
        });

        clearButton.setActionCommand("cvc");
        clearButton.setLabel("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(getAllObjectsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(hostLabel)
                                                        .addComponent(portLabel))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(hostEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                                        .addComponent(portEdit)))
                                        .addComponent(closeConnectionButton, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                                        .addComponent(startConnectionButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(getObjectButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(objectCountEdit))
                                        .addComponent(getObjectCountButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(statusLabel)
                                        .addComponent(launchServerButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(clearButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 11, Short.MAX_VALUE))
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
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(portLabel)
                                        .addComponent(portEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(startConnectionButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(closeConnectionButton)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(getObjectButton)
                                        .addComponent(objectCountEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(getObjectCountButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(getAllObjectsButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(clearButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                                .addComponent(statusLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(launchServerButton)
                                .addGap(12, 12, 12))
        );

        clearButton.getAccessibleContext().setAccessibleName("clearButton");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void launchServerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_launchServerButtonActionPerformed
        String host = hostEdit.getText();
        int port = Integer.parseInt(portEdit.getText());

        Server server = new Server(s,host,port);
        server.start();

        statusLabel.setText("SERVER RUNNING");
        hostEdit.setEnabled(false);
        portEdit.setEnabled(false);

        new Thread(new Runnable() {
            public void run() {
                while(server.isAlive()) {}
                statusLabel.setText("CLIENT");
                hostEdit.setEnabled(true);
                portEdit.setEnabled(true);
            }
        }).start();
    }//GEN-LAST:event_launchServerButtonActionPerformed

    private void startConnectionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startConnectionButtonActionPerformed
        String host = hostEdit.getText();
        int port = Integer.parseInt(portEdit.getText());
        c = new Client(s,host,port);
        c.start();

        clearButton.setEnabled(true);
        startConnectionButton.setEnabled(false);
        closeConnectionButton.setEnabled(true);
        getAllObjectsButton.setEnabled(true);
        getObjectButton.setEnabled(true);
        getObjectCountButton.setEnabled(true);
        objectCountEdit.setEnabled(true);

        hostEdit.setEnabled(false);
        portEdit.setEnabled(false);
    }//GEN-LAST:event_startConnectionButtonActionPerformed

    private void getAllObjectsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getAllObjectsButtonActionPerformed
        try {
            Protocol.QueryObjects(c.socket);
        } catch (Exception e) { e.printStackTrace(); }
    }//GEN-LAST:event_getAllObjectsButtonActionPerformed

    private void closeConnectionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeConnectionButtonActionPerformed
        try {
            Protocol.CloseConnection(c.socket);
        } catch (Exception e) { e.printStackTrace(); }

        clearButton.setEnabled(false);
        startConnectionButton.setEnabled(true);
        closeConnectionButton.setEnabled(false);
        getAllObjectsButton.setEnabled(false);
        getObjectButton.setEnabled(false);
        getObjectCountButton.setEnabled(false);
        objectCountEdit.setEnabled(false);

        hostEdit.setEnabled(true);
        portEdit.setEnabled(true);
    }//GEN-LAST:event_closeConnectionButtonActionPerformed

    private void getObjectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getObjectButtonActionPerformed
        int count = Integer.parseInt(objectCountEdit.getText());
        try {
            Protocol.QueryObject(c.socket, count);
        } catch (Exception e) { e.printStackTrace(); }

    }//GEN-LAST:event_getObjectButtonActionPerformed

    private void getObjectCountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getObjectCountButtonActionPerformed
        try {
            Protocol.QueryListSize(c.socket);
        } catch (Exception e) { e.printStackTrace(); }

    }//GEN-LAST:event_getObjectCountButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        try {
            Protocol.ClearList(c.socket);
        } catch (Exception e) { e.printStackTrace(); }
    }//GEN-LAST:event_clearButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
                MainJFrame f =  new MainJFrame();
                f.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearButton;
    private javax.swing.JButton closeConnectionButton;
    private javax.swing.JButton getAllObjectsButton;
    private javax.swing.JButton getObjectButton;
    private javax.swing.JButton getObjectCountButton;
    private javax.swing.JTextField hostEdit;
    private javax.swing.JLabel hostLabel;
    private javax.swing.JButton launchServerButton;
    private javax.swing.JTextField objectCountEdit;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField portEdit;
    private javax.swing.JLabel portLabel;
    private javax.swing.JButton startConnectionButton;
    private javax.swing.JLabel statusLabel;
    // End of variables declaration//GEN-END:variables


}
