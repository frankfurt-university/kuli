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
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kain
 */
public class Perku extends javax.swing.JFrame {
    /**
     * Init variables
     */
    private static String ID;
    private String id;
    private String idRecord;
    private static String departmentId = null;
    private static String firstName = null;
    private static String lastName = null;
    private static String titl = null;
    private static String gender = null;
    private static String pos = null;
    private static String phoneNummber = null;
    private static String mail = null;
    private static String faX = null;
    private static String buildingNr = null;
    private static String roomNr = null;
    
    /**
     * Fils the Table with data from the DB
     */
    private void showTable() {
        DefaultTableModel defaultTable = (DefaultTableModel) PerkuTable.getModel();
        try {
            DBServiceInvoker invoke = new DBServiceInvoker();
            List<String> pers = invoke.invokeSelect("PerKu", "");
            Iterator<String> i = pers.iterator();
            while (i.hasNext()) {
                System.out.println(pers);
                String[] subString = i.next().split(Pattern.quote(" "));

                String idPerKu = subString[0];
                String idFiKu = subString[1];
                String departmentsIdDepartments = subString[2];
                String fName = subString[3];
                String lName = subString[4];
                String title = subString[5];
                String sex = subString[6];
                String position = subString[7];
                String phone = subString[8];
                String eMail = subString[9];
                String fax = subString[10];
                String building = subString[11];
                String room = subString[12];
                String fiKuHasPlaceFiKuIdFiKu = subString[13];
                String fiKuHasPlacePlaceIdPlace = subString[14];           

                defaultTable.addRow(new Object[]{idPerKu, idFiKu, departmentsIdDepartments, fName, lName, title, sex, position, phone, eMail, fax, building, room, fiKuHasPlaceFiKuIdFiKu, 
                    fiKuHasPlacePlaceIdPlace/*, fiKuName, city*/});
            }
            invoke.cleanErrorString();

        } catch (SQLException sqlex) {

            System.out.println("SQL Error : " + sqlex.getMessage());
        } catch (Exception e) {

            System.out.println("Error : " + e.getMessage());
        }

    }
    /**
     * 
     */
    private void showTable2() {
        DefaultTableModel defaultTable = (DefaultTableModel) secondTable.getModel();

        try {
            DBServiceInvoker invoke = new DBServiceInvoker();
            List<String> pers = invoke.invokeSelect("PerKu", "");
            Iterator<String> i = pers.iterator();
            while (i.hasNext()) {
                System.out.println(pers);
                String[] subString = i.next().split(Pattern.quote(" "));

                String idPerKu = subString[0];
                String idFiKu = subString[1];
                String departmentsIdDepartments = subString[2];
                String fName = subString[3];
                String lName = subString[4];
                String title = subString[5];
                String sex = subString[6];
                String position = subString[7];
                String phone = subString[8];
                String eMail = subString[9];
                String fax = subString[10];
                String building = subString[11];
                String room = subString[12];
                String fiKuHasPlaceFiKuIdFiKu = subString[13];
                String fiKuHasPlacePlaceIdPlace = subString[14];
                
                defaultTable.addRow(new Object[]{idPerKu, idFiKu, departmentsIdDepartments, fName, lName, title, sex, position, phone, eMail, fax, building, room, fiKuHasPlaceFiKuIdFiKu, 
                    fiKuHasPlacePlaceIdPlace/*, fiKuName, city*/});
            }
            invoke.cleanErrorString();

        } catch (SQLException sqlex) {

            System.out.println("SQL Error : " + sqlex.getMessage());
        } 
    }
    
    /**
     * Creates new form Place(s)
     * and fills the table with data
     */
    public Perku() {
        initComponents();
        showTable();
    }
    /**
    * Creates a new Place(s) 
    * just with a Table and one Button
    * @param value boolean to enable or disable
    */
    public Perku(boolean value){
        if(value!=false){
        initComponents2();
        showTable2();
        }
    }
    /**
     * 
     * @return the ID
     */
    public static String getPerkuID(){
        return ID;
    }
    /**
     * 
     * @return the ID
     */
    public static String getDepID(){
        return departmentId;
    }
    /**
     * 
     * @return the ID
     */
    public static String getFNameID(){
        return firstName;
    }
    /**
     * 
     * @return the ID
     */
    public static String getLNameID(){
        return lastName;
    }
    /**
     * 
     * @return the ID
     */
    public static String getTitleID(){
        return titl;
    }
    /**
     * 
     * @return the ID
     */
    public static String getSexID(){
        return gender;
    }
    /**
     * 
     * @return the ID
     */
    public static String getPositionID(){
        return pos;
    }
    /**
     * 
     * @return the ID
     */
    public static String getPhoneNumberID(){
        return phoneNummber;
    }
    /**
     * 
     * @return the ID
     */
    public static String getEMailID(){
        return mail;
    }
    /**
     * 
     * @return the ID
     */
    public static String getFaxID(){
        return faX;
    }
    /**
     * 
     * @return the ID
     */
    public static String getBuildingID(){
        return buildingNr;
    }
    /**
     * 
     * @return the ID
     */
    public static String getRoomID(){
        return roomNr;
    }
    /**
     * Copies our selected ID
     * @param toString 
     */
    private void setDepID(String toString) {
       String[] subString = toString.split(Pattern.quote(" "));
       departmentId = subString[2];
    }
    /**
     * Copies our selected ID
     * @param toString 
     */
    public void setFNameID(String toString) {
       String[] subString = toString.split(Pattern.quote(" "));
       firstName = subString[3];
    }
    /**
     * Copies our selected ID
     * @param toString 
     */
    public void setLNameID(String toString) {
       String[] subString = toString.split(Pattern.quote(" "));
       lastName = subString[4];
    }
    /**
     * Copies our selected ID
     * @param toString 
     */
    public void setTitleID(String toString) {
       String[] subString = toString.split(Pattern.quote(" "));
       titl = subString[5];
    }
    /**
     * Copies our selected ID
     * @param toString 
     */
    public void setGenderID(String toString) {
       String[] subString = toString.split(Pattern.quote(" "));
       gender = subString[6];
    }
    /**
     * Copies our selected ID
     * @param toString 
     */
    public void setPosID(String toString) {
       String[] subString = toString.split(Pattern.quote(" "));
       pos = subString[7];
    }
    /**
     * Copies our selected ID
     * @param toString 
     */
    public void setPhoneID(String toString) {
       String[] subString = toString.split(Pattern.quote(" "));
       phoneNummber = subString[8];
    }
    /**
     * Copies our selected ID
     * @param toString 
     */
    public void setMailID(String toString) {
       String[] subString = toString.split(Pattern.quote(" "));
       mail = subString[9];
    }
    /**
     * Copies our selected ID
     * @param toString 
     */
    public void setFaxID(String toString) {
       String[] subString = toString.split(Pattern.quote(" "));
       faX = subString[10];
    }
    /**
     * Copies our selected ID
     * @param toString 
     * 
     */
    public void setBuildingID(String toString) {
       String[] subString = toString.split(Pattern.quote(" "));
       buildingNr = subString[11];
    }
    /**
     * Copies our selected ID
     * @param toString 
     */
    public void setRoomID(String toString) {
       String[] subString = toString.split(Pattern.quote(" "));
        roomNr = subString[12];
    }
    
    /**
     * l
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        PerkuTable = new javax.swing.JTable();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        jButtonAdd = new javax.swing.JButton();
        jButtonUpdate = new javax.swing.JButton();
        jButtonRefresh = new javax.swing.JButton();
        jButtonClose = new javax.swing.JButton();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        jButtonDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Contacts");

        jPanel1.setToolTipText("");

        PerkuTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Person's ID", "Company ID", "Dept. ID", "First Name", "Last Name", "Title", "Sex", "Position", "Phone", "E-mail", "Fax", "Building", "Room", "Place FikuID", "Place PlaceID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        PerkuTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane3.setViewportView(PerkuTable);
        PerkuTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jButtonAdd.setText("Add new");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jButtonUpdate.setText("Update");
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        jButtonRefresh.setText("Refresh");
        jButtonRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefreshActionPerformed(evt);
            }
        });

        jButtonClose.setText("Close");
        jButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseActionPerformed(evt);
            }
        });

        jButtonDelete.setText("Delete");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonRefresh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonClose)
                .addGap(7, 7, 7))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(521, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(316, 316, 316))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(442, 442, 442))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 899, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(148, Short.MAX_VALUE)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAdd)
                    .addComponent(jButtonUpdate)
                    .addComponent(jButtonRefresh)
                    .addComponent(jButtonClose)
                    .addComponent(jButtonDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addGap(43, 43, 43)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        AddPerku addPerku = new AddPerku();
        addPerku.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefreshActionPerformed
        try {
            DefaultTableModel defaultTable = (DefaultTableModel) PerkuTable.getModel();
            defaultTable.setRowCount(0);
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
            showTable();
    }//GEN-LAST:event_jButtonRefreshActionPerformed

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        int count = PerkuTable.getSelectedRow();
        StringBuilder ident = new StringBuilder();
        if (count > -1) {
            for (int i = 0; i < PerkuTable.getColumnCount() ; i++) {
                ident.append(PerkuTable.getValueAt(count, i));
                ident.append(" ");
            }
            setDepID(ident.toString());
            setFNameID(ident.toString());
            setFNameID(ident.toString());
            setLNameID(ident.toString());
            setTitleID(ident.toString());
            setGenderID(ident.toString());
            setPosID(ident.toString());
            setPhoneID(ident.toString());
            setMailID(ident.toString());
            setFaxID(ident.toString());
            setBuildingID(ident.toString());
            setRoomID(ident.toString());
            new AddPerku(ident.toString()).setVisible(true);
            super.dispose();
        }
        else new PleaseSelectMessage().setVisible(true);
    }//GEN-LAST:event_jButtonUpdateActionPerformed

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButtonCloseActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        int count = PerkuTable.getSelectedRow();
        StringBuilder row = new StringBuilder();
        if (count > -1) {
            for (int i = 0; i < PerkuTable.getColumnCount() ; i++) {
                row.append(PerkuTable.getValueAt(count, i));
                row.append(";");
            }
            id = getSelectedID(row.toString());
            System.out.println(row);
            String[] substring = id.split(Pattern.quote(";"));
            System.out.println(substring.length);
            this.idRecord = substring[0];
            DBServiceInvoker invoke = new DBServiceInvoker();
            String attribut = "idPerKu = "+idRecord;
            invoke.invokeDelete("perku", attribut);
            //this is alternative to manual Refresh
            Perku newPerku = new Perku();
            newPerku.setVisible(true);
            this.dispose();
        }
        else new PleaseSelectMessage().setVisible(true);
    }//GEN-LAST:event_jButtonDeleteActionPerformed
    /**
     * This Method measures which row get´s clicked
     * 
     */
    private void jButtonOkActionPerformed(java.awt.event.ActionEvent evt){
        int count = secondTable.getSelectedRow();
        StringBuilder id = new StringBuilder();
        if (count > -1) {
            for (int i = 0; i < secondTable.getColumnCount() ; i++) {
                id.append(secondTable.getValueAt(count, i));
                id.append(" ");
            }
            ID = getSelectedID(id.toString());
            System.out.println(id);
            AddCurrentProduct newCurrentProduct = new AddCurrentProduct();
            newCurrentProduct.setVisible(true);
            super.dispose();

        }
        else new PleaseSelectMessage().setVisible(true);
    }
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
            java.util.logging.Logger.getLogger(Perku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Perku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Perku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Perku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Perku().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable PerkuTable;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonRefresh;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
    
    //Variables declaration do modify if nessesary
    private javax.swing.JButton okButton;
    private javax.swing.JTable secondTable;
    private javax.swing.JTable jTable2;
    private JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    //End of variables decleration
    private void initComponents2() {
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        secondTable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        okButton = new javax.swing.JButton();
        jButtonClose = new javax.swing.JButton();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Companies");

        secondTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Person's ID", "Company ID", "Dept. ID", "First Name", "Last Name", "Title", "Sex", "Position", "Phone", "E-mail", "Fax", "Building", "Room", "Place FikuID", "Place PlaceID"
            }
        ));
        jScrollPane5.setViewportView(secondTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
        );

        okButton.setText("OK");
        okButton.setToolTipText("Ok for this Table");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOkActionPerformed(evt);
            }
        });

 
        jButtonClose.setText("Close");
        jButtonClose.setToolTipText("Close and return");
        jButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(okButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonClose)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(jButtonClose)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }
    /**
     * Copies our selected ID
     * @param toString 
     * @return fikuId deliver the selected fikuId
     */
    public String getSelectedID(String toString) {
       String[] subString = toString.split(Pattern.quote(" "));
       String idPrimaryKey = subString[0];
       return idPrimaryKey;
    }
}
