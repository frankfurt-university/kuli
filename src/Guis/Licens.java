/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Guis;

import dbServices.DBServiceInvoker;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kain
 */
public class Licens extends javax.swing.JFrame {

    /**
     * Creates new form Licens
     */
    public Licens() {
        initComponents();
        showTable(LicenseTable, MaintenanceTable, LeasingTable, GroupLicenseTable);
    }
    /** fills table <code>LicenseTable</code> with data and shows it in this form
     * 
     */
    private void showTable(JTable table, JTable table2, JTable table3, JTable table4) {
        try {
            DefaultTableModel defaultTable = (DefaultTableModel) table.getModel();
            DBServiceInvoker invoke = new DBServiceInvoker();
            List<String> pers = invoke.invokeSelect("license", "");
            Iterator<String> i = pers.iterator();
            while (i.hasNext()) {
                String[] subString = i.next().split(Pattern.quote(" "));
                String licenseId = subString[0];
                String currentProductId = subString[1];
                String perkuId = subString[2];
                String maintenanceId = subString[3];
                String key = subString[4];
                String activated = subString[5];
                String saleDate = subString[6];
                String expiry = subString[7];
                String upgradable = subString[8];
                defaultTable.addRow(new Object[]{licenseId, currentProductId, perkuId, maintenanceId, key, activated, saleDate, expiry, upgradable});
            }
            invoke.cleanErrorString();

        } catch (SQLException sqlex) {
            System.out.println("SQL Error : " + sqlex.getMessage());
        } 
        try {
            DefaultTableModel defaultTable2 = (DefaultTableModel) table2.getModel();
            DBServiceInvoker invoke = new DBServiceInvoker();
            List<String> pers = invoke.invokeSelect("maintenance", "");
            Iterator<String> i = pers.iterator();
            while (i.hasNext()) {
                String[] subString = i.next().split(Pattern.quote(" "));
                String idMaintenance = subString[0];
                String StartDate = subString[1];
                String ExpiryDate = subString[2];
                String price = subString[3];
                String maintenancecol = subString[4];
                defaultTable2.addRow(new Object[]{idMaintenance, StartDate, ExpiryDate, price, maintenancecol});
            }
            invoke.cleanErrorString();
        }catch (SQLException sqlex) {
            System.out.println("SQL Error : " + sqlex.getMessage());
        }
        try {
            DefaultTableModel defaultTable3 = (DefaultTableModel) table3.getModel();
            DBServiceInvoker invoke = new DBServiceInvoker();
            List<String> pers = invoke.invokeSelect("leasing", "");
            Iterator<String> i = pers.iterator();
            while (i.hasNext()) {
                String[] subString = i.next().split(Pattern.quote(" "));
                String idLesing = subString[0];
                String currentProductsId = subString[1];
                String StartDate = subString[2];
                String ExpiryDate = subString[3];
                String firstInvoice = subString[4];
                String lastInvoice = subString[5];
                String nextInvoice = subString[6];
                String canceled = subString[7];
                defaultTable3.addRow(new Object[]{idLesing, currentProductsId, StartDate, ExpiryDate, firstInvoice, firstInvoice, lastInvoice, nextInvoice, canceled});
            }
            invoke.cleanErrorString(); 
        }catch(SQLException sqlex){
            System.out.println("SQL Error : " + sqlex.getMessage());
        }
        try {
            DefaultTableModel defaultTable = (DefaultTableModel) table4.getModel();
            DBServiceInvoker invoke = new DBServiceInvoker();
            List<String> pers = invoke.invokeSelect("group_license", "");
            Iterator<String> i = pers.iterator();
            while (i.hasNext()) {
                String[] subString = i.next().split(Pattern.quote(" "));
                String groupLicenseId = subString[0];
                String currentProductId = subString[1];
                String perkuId = subString[2];
                String maintenanceId = subString[3];
                String key = subString[4];
                String activated = subString[5];
                String soldDate = subString[7];
                String expiry = subString[8];
                String upgradable = subString[9];
                String groupSize = subString[6];
                defaultTable.addRow(new Object[]{groupLicenseId, currentProductId, perkuId, maintenanceId, key, activated, groupSize, soldDate, expiry, upgradable});
            }
            invoke.cleanErrorString();

        } catch (SQLException sqlex) {
            System.out.println("SQL Error : " + sqlex.getMessage());
        } 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonRefresh = new javax.swing.JButton();
        jButtonEditLeasing = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        LicenseTable = new javax.swing.JTable();
        jButtonAddLeasing = new javax.swing.JButton();
        jButtonClose = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        LeasingTable = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        MaintenanceTable = new javax.swing.JTable();
        jButtonAddLicense = new javax.swing.JButton();
        jButtonAddMaintenance = new javax.swing.JButton();
        jButtonEditMaintenance = new javax.swing.JButton();
        jButtonUpdateLicense = new javax.swing.JButton();
        jButtonUpdateGroupLicense = new javax.swing.JButton();
        jButtonAddGroupLicense = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        GroupLicenseTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("License");

        jButtonRefresh.setText("Refresh");
        jButtonRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefreshActionPerformed(evt);
            }
        });

        jButtonEditLeasing.setText("Update Leas");
        jButtonEditLeasing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditLeasingActionPerformed(evt);
            }
        });

        LicenseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "License ID", "Current Product ID", "Perku ID", "Maintenance ID", "Key", "Activated", "Sale Date", "Expiry", "Upgradable"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        LicenseTable.setToolTipText("Single License");
        LicenseTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane3.setViewportView(LicenseTable);

        jButtonAddLeasing.setText("Add new Leasing");
        jButtonAddLeasing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddLeasingActionPerformed(evt);
            }
        });

        jButtonClose.setText("Close");
        jButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseActionPerformed(evt);
            }
        });

        LeasingTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Leasing ID", "Current Product ID", "Start Date", "Expire Date", "First Invoice", "Last Invoice", "Next Invoice", "Canceled"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        LeasingTable.setToolTipText("Leasing");
        LeasingTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane4.setViewportView(LeasingTable);

        MaintenanceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Maintenance ID", "Start Date", "Expire Date", "Price", "MaintenanceCol"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        MaintenanceTable.setToolTipText("Maintance");
        MaintenanceTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane5.setViewportView(MaintenanceTable);

        jButtonAddLicense.setText("Add new License");
        jButtonAddLicense.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddLicenseActionPerformed(evt);
            }
        });

        jButtonAddMaintenance.setText("Add new Maintenance");
        jButtonAddMaintenance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddMaintenanceActionPerformed(evt);
            }
        });

        jButtonEditMaintenance.setText("Update Maint");
        jButtonEditMaintenance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditMaintenanceActionPerformed(evt);
            }
        });

        jButtonUpdateLicense.setText("Update Lic");
        jButtonUpdateLicense.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateLicenseActionPerformed(evt);
            }
        });

        jButtonUpdateGroupLicense.setText("Update Group Lic");
        jButtonUpdateGroupLicense.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateGroupLicenseActionPerformed(evt);
            }
        });

        jButtonAddGroupLicense.setText("Add new Group License");
        jButtonAddGroupLicense.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddGroupLicenseActionPerformed(evt);
            }
        });

        GroupLicenseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Group License ID", "Current Product ID", "Perku ID", "Maintenance ID", "Key", "Activated", "Group Size", "Sold Date", "Expiry", "Upgradable"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        GroupLicenseTable.setToolTipText("Group License");
        GroupLicenseTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane6.setViewportView(GroupLicenseTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jButtonAddGroupLicense, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonUpdateGroupLicense, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonAddLeasing, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonEditLeasing, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jButtonAddMaintenance)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonEditMaintenance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 552, Short.MAX_VALUE)
                        .addComponent(jButtonRefresh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonClose))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAddLicense, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonUpdateLicense, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane6))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddLicense)
                    .addComponent(jButtonUpdateLicense))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddGroupLicense)
                    .addComponent(jButtonUpdateGroupLicense))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddMaintenance)
                    .addComponent(jButtonEditMaintenance))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonClose)
                    .addComponent(jButtonAddLeasing)
                    .addComponent(jButtonEditLeasing)
                    .addComponent(jButtonRefresh))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefreshActionPerformed
        try {
            DefaultTableModel defaultTable = (DefaultTableModel) LicenseTable.getModel();
            defaultTable.setRowCount(0);
            DefaultTableModel defaultTable2 = (DefaultTableModel) MaintenanceTable.getModel();
            defaultTable2.setRowCount(0);
            DefaultTableModel defaultTable3 = (DefaultTableModel) LeasingTable.getModel();
            defaultTable3.setRowCount(0);
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        showTable(LicenseTable, MaintenanceTable, LeasingTable, GroupLicenseTable);       
    }//GEN-LAST:event_jButtonRefreshActionPerformed

    private void jButtonEditLeasingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditLeasingActionPerformed
        int count = LeasingTable.getSelectedRow();
        StringBuilder id = new StringBuilder();
        if (count > -1) {
            for (int i = 0; i < LeasingTable.getColumnCount() ; i++) {
                id.append(LeasingTable.getValueAt(count, i));
                id.append(" ");
            }
            //Todo new AddLeasing(id.toString()).setVisible(true);
            super.dispose();
        }
        else new PleaseSelectMessage().setVisible(true);
    }//GEN-LAST:event_jButtonEditLeasingActionPerformed

    private void jButtonAddLeasingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddLeasingActionPerformed
        
    }//GEN-LAST:event_jButtonAddLeasingActionPerformed

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButtonCloseActionPerformed

    private void jButtonAddLicenseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddLicenseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAddLicenseActionPerformed

    private void jButtonAddMaintenanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddMaintenanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAddMaintenanceActionPerformed

    private void jButtonEditMaintenanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditMaintenanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEditMaintenanceActionPerformed

    private void jButtonUpdateLicenseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateLicenseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonUpdateLicenseActionPerformed

    private void jButtonUpdateGroupLicenseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateGroupLicenseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonUpdateGroupLicenseActionPerformed

    private void jButtonAddGroupLicenseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddGroupLicenseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAddGroupLicenseActionPerformed

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
            java.util.logging.Logger.getLogger(Licens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Licens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Licens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Licens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Licens().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable GroupLicenseTable;
    private javax.swing.JTable LeasingTable;
    private javax.swing.JTable LicenseTable;
    private javax.swing.JTable MaintenanceTable;
    private javax.swing.JButton jButtonAddGroupLicense;
    private javax.swing.JButton jButtonAddLeasing;
    private javax.swing.JButton jButtonAddLicense;
    private javax.swing.JButton jButtonAddMaintenance;
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonEditLeasing;
    private javax.swing.JButton jButtonEditMaintenance;
    private javax.swing.JButton jButtonRefresh;
    private javax.swing.JButton jButtonUpdateGroupLicense;
    private javax.swing.JButton jButtonUpdateLicense;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    // End of variables declaration//GEN-END:variables
}
