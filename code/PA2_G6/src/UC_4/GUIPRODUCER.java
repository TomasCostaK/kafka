/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UC_4;

import java.awt.Dimension;

/**
 *
 * @author alina
 */
public class GUIPRODUCER extends javax.swing.JFrame {

    /**
     * Creates new form GUIPRODUCER
     */
    public GUIPRODUCER() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        producersTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaP = new javax.swing.JTextArea();
        total = new javax.swing.JLabel();
        sensor1 = new javax.swing.JLabel();
        sensor3 = new javax.swing.JLabel();
        sensor2 = new javax.swing.JLabel();
        sensor4 = new javax.swing.JLabel();
        sensor5 = new javax.swing.JLabel();
        sensor0 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel1.setBackground(new java.awt.Color(239, 240, 240));
        jLabel1.setText("jLabel1");
        jLabel1.setOpaque(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(247, 249, 250));

        producersTitle.setFont(new java.awt.Font("Ubuntu Condensed", 3, 24)); // NOI18N
        producersTitle.setForeground(new java.awt.Color(90, 121, 225));
        producersTitle.setText("Producers GUI");

        textAreaP.setBackground(new java.awt.Color(245, 251, 254));
        textAreaP.setColumns(20);
        textAreaP.setRows(5);
        jScrollPane1.setViewportView(textAreaP);

        total.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        total.setForeground(new java.awt.Color(22, 24, 31));
        total.setText("Total:        ");

        sensor1.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        sensor1.setForeground(new java.awt.Color(22, 24, 31));
        sensor1.setText("Sensor 1:");

        sensor3.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        sensor3.setForeground(new java.awt.Color(22, 24, 31));
        sensor3.setText("Sensor 3:        ");

        sensor2.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        sensor2.setForeground(new java.awt.Color(22, 24, 31));
        sensor2.setText("Sensor 2:        ");

        sensor4.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        sensor4.setForeground(new java.awt.Color(22, 24, 31));
        sensor4.setText("Sensor 4:");

        sensor5.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        sensor5.setForeground(new java.awt.Color(22, 24, 31));
        sensor5.setText("Sensor 5:        ");

        sensor0.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        sensor0.setForeground(new java.awt.Color(22, 24, 31));
        sensor0.setText("Sensor 0:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(producersTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sensor1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sensor2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sensor0, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(sensor5, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sensor4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sensor3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(producersTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(total)
                    .addComponent(sensor3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sensor4)
                    .addComponent(sensor0))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sensor5)
                    .addComponent(sensor1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sensor2)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUIPRODUCER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIPRODUCER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIPRODUCER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIPRODUCER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIPRODUCER().setVisible(true);
            }
        });
    }
    
    public void updateTextArea(String text) {
        textAreaP.append(text + "\n");
        textAreaP.setCaretPosition(textAreaP.getText().length());
    }
    
    public void updateTitleArea(String idProducer) {
        producersTitle.setText("Producer " + idProducer + " GUI");
    }
    
    public void setNewLocation(int idProducer) {
        Dimension windowSize = getSize();
        int dx = windowSize.width * idProducer + 100;    
        setLocation(dx, 0);      
    }
    
    public void updateNumberRecords(String id, int number) {
        if (null != id) switch (id) {
            case "total":
                total.setText("Total: "+number);
                break;
            case "0":
                sensor0.setText("Sensor 0: "+number);
                break;
            case "1":
                sensor1.setText("Sensor 1: "+number);
                break;
            case "2":
                sensor2.setText("Sensor 2: "+number);
                break;
            case "3":
                sensor3.setText("Sensor 3: "+number);
                break;
            case "4":
                sensor4.setText("Sensor 4: "+number);
                break;
            case "5":
                sensor5.setText("Sensor 5: "+number);
                break;
            default:
                break;
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel producersTitle;
    private javax.swing.JLabel sensor0;
    private javax.swing.JLabel sensor1;
    private javax.swing.JLabel sensor2;
    private javax.swing.JLabel sensor3;
    private javax.swing.JLabel sensor4;
    private javax.swing.JLabel sensor5;
    private javax.swing.JTextArea textAreaP;
    private javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables
}
