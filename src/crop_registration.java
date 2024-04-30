
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kavi♥
 */
public class crop_registration extends javax.swing.JFrame {

    /**
     * Creates new form plantation_registration
     */
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    DefaultTableModel d;
    
    
    public crop_registration() {
        initComponents();
        con=SQLCON.connect();
        Crop_id();
        addcropLoad();
    }
    
    //auto gen Crop Id    
        public void Crop_id()
   {
       try
       {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(crop_id) FROM crop");
            rs.next();
            rs.getString("MAX(crop_id)");
           
            if(rs.getString("MAX(crop_id)")==null)
            {
                txtcrop_id.setText("CID00001");
            }
            else
            {
                long cropid = Long.parseLong(rs.getString("MAX(crop_id)").substring(3,rs.getString("MAX(crop_id)").length()));
                cropid++;
                txtcrop_id.setText("CID" + String.format("%05d", cropid));
            }
        }
       
     catch (SQLException ex) {
            Logger.getLogger(crop_registration.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
        
         
        //Adding Item to Jtable
   public void addcropLoad()
   {
       int c;
        try {
            pst = con.prepareStatement("SELECT * FROM crop");
            rs = pst.executeQuery();
           
            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
            d = (DefaultTableModel)tblcrop.getModel();
         
            d.setRowCount(0);
            
           
//** While loop for load the data
            while(rs.next())
            {
              Vector v2 = new Vector();
              for(int i=1; i<=c; i++)
              {
              
              v2.add(rs.getString("crop_id"));
              v2.add(rs.getString("crop_name"));
              v2.add(rs.getString("planters_name"));
              v2.add(rs.getString("crop_amount"));
              v2.add(rs.getString("harvest_date"));
              
                                      
              }
             
             d.addRow(v2);
             
            }
             
        } catch (SQLException ex) {
            Logger.getLogger(fertilizer_registration.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnadd = new javax.swing.JButton();
        txtcrop_id = new javax.swing.JTextField();
        txtcrop_name = new javax.swing.JTextField();
        txtplantersname = new javax.swing.JTextField();
        txtcropamount = new javax.swing.JTextField();
        txtharvestdate = new javax.swing.JTextField();
        btnsearch = new javax.swing.JButton();
        txtsearch = new javax.swing.JTextField();
        btnreset = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblcrop = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("Crop Registration");

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Crop ID");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("Planter's Name");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("Crop Name");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("Crop Amount");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setText("Harvest Date");

        btnadd.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnadd.setText("Add");
        btnadd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });

        btnsearch.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnsearch.setText("Search");
        btnsearch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchActionPerformed(evt);
            }
        });

        txtsearch.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        btnreset.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnreset.setText("Reset");
        btnreset.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        btnreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresetActionPerformed(evt);
            }
        });

        btnupdate.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnupdate.setText("Update");
        btnupdate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });

        btndelete.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btndelete.setText("Delete");
        btndelete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addGap(153, 153, 153)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtharvestdate)
                    .addComponent(txtcrop_name)
                    .addComponent(txtcrop_id, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                    .addComponent(txtplantersname)
                    .addComponent(txtcropamount))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(btnupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(btnreset, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(btnadd, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(172, 172, 172))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtcrop_id, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcrop_name, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtplantersname, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtcropamount, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtharvestdate, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(78, 78, 78)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnadd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btndelete)
                        .addComponent(btnupdate)
                        .addComponent(btnreset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(116, 116, 116))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(178, 178, 178)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tblcrop.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Crop ID", "Crop Name", "Planter's Name", "Crop Amount", "Harvest Date"
            }
        ));
        jScrollPane1.setViewportView(tblcrop);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(1109, 846));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        // TODO add your handling code here:
        
        
        String crop_id=txtcrop_id.getText();
        String crop_name=txtcrop_name.getText();
        String planter_name=txtplantersname.getText();
        String crop_amount=txtcropamount.getText();
        String h_date=txtharvestdate.getText();
        
        
        
        
        
         if (crop_id.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Enter Crop ID");
            }
         else if (crop_name.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Enter Crop Name");
            }
        else if (planter_name.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Enter Planter's Name");
            }
        else if (crop_amount.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Enter Crop Amount");
            }
        else if (h_date.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Enter Harvest Date");
            }
        
         
        else
        {
            
        
        String sql="INSERT INTO crop VALUES(?,?,?,?,?)";
        
        try
        {
            pst=con.prepareStatement(sql);
            pst.setString(1, txtcrop_id.getText());
            pst.setString(2, txtcrop_name.getText());
            pst.setString(3, txtplantersname.getText());
            pst.setString(4, txtcropamount.getText());
            pst.setString(5, txtharvestdate.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data added Successfully");
            
            //clear added data
            txtcrop_id.setText("");
            txtcrop_name.setText("");
            txtplantersname.setText("");
            txtcropamount.setText("");
            txtharvestdate.setText("");
            Crop_id();
            addcropLoad();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
            
            
        }
        }
    }//GEN-LAST:event_btnaddActionPerformed

    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed
        // TODO add your handling code here:
        
        try
        {
        Statement st= con.createStatement();
        String search=txtsearch.getText();
        
        String sql="SELECT * FROM crop WHERE crop_id='"+search+"'";
        ResultSet rs=st.executeQuery(sql);
        
        if (rs.next()==false)
        {
             JOptionPane.showMessageDialog(null,"invalid Crop ID");
        }
        
             
        
        
        String c_id=rs.getString("crop_id");
        txtcrop_id.setText(c_id);
        
        String c_name=rs.getString("crop_name");
        txtcrop_name.setText(c_name);

        
        String p_name=rs.getString("planters_name");
        txtplantersname.setText(p_name);
        
        String c_amount=rs.getString("crop_amount");
        txtcropamount.setText(c_amount);
        
                
        String h_date=rs.getString("harvest_date");
        txtharvestdate.setText(h_date);
        
       
        
        
        
        
        
        //clear added data
            txtsearch.setText("");

        
          

              
       
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_btnsearchActionPerformed

    private void btnresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetActionPerformed
        // TODO add your handling code here:
        //clear added data
            txtcrop_id.setText("");
            txtcrop_name.setText("");
            txtplantersname.setText("");
            txtcropamount.setText("");
            txtharvestdate.setText("");
            Crop_id();
            addcropLoad();
        
    }//GEN-LAST:event_btnresetActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        // TODO add your handling code here:
        
        String id=txtcrop_id.getText();
        String sql="DELETE  FROM crop WHERE crop_id ='"+id+"'";
        
        int opt = JOptionPane.showConfirmDialog(null, "Are you sure to delete details?","Delete",JOptionPane.YES_NO_OPTION);
        if(opt==0)
        
         try
        {
           
           pst=con.prepareStatement(sql);
           
           pst.execute();
           
           JOptionPane.showMessageDialog(null,"succesefully Delete");
           
           //clear added data
            txtcrop_id.setText("");
            txtcrop_name.setText("");
            txtplantersname.setText("");
            txtcropamount.setText("");
            txtharvestdate.setText("");
            Crop_id();
            addcropLoad();
        }
        catch (Exception e)
        {
         JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        // TODO add your handling code here:
        
        String id=txtcrop_id.getText();
        String cropname=txtcrop_name.getText();
        String plantername=txtplantersname.getText();
        String amount=txtcropamount.getText();
        String h_date=txtharvestdate.getText();
        
        
        
        
        
         if (id.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Enter Crop ID");
            }
         else if (cropname.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Enter Crop name");
            }
        else if (plantername.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Enter Planter name");
            }
        else if (amount.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Enter Crop Amount");
            }
          
        else if (h_date.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Enter Harvest Date");
            }
       
        else
        {
        
        
        
        
        String sql="UPDATE crop SET crop_id=?, crop_name=? , planters_name=? , crop_amount=? , harvest_date=? WHERE crop_id='"+id+"'";
        
        
        
        
     
        try
        {
            pst=con.prepareStatement(sql);
            pst.setString(1, txtcrop_id.getText());
            pst.setString(2, txtcrop_name.getText());
            pst.setString(3, txtplantersname.getText());
            pst.setString(4, txtcropamount.getText());
            pst.setString(5,txtharvestdate.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "update");
            
            
            
            
            
           //clear added data
            txtcrop_id.setText("");
            txtcrop_name.setText("");
            txtplantersname.setText("");
            txtcropamount.setText("");
            txtharvestdate.setText("");
            Crop_id();
            addcropLoad();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        }
    }//GEN-LAST:event_btnupdateActionPerformed

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
            java.util.logging.Logger.getLogger(crop_registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(crop_registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(crop_registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(crop_registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new crop_registration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnreset;
    private javax.swing.JButton btnsearch;
    private javax.swing.JButton btnupdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblcrop;
    private javax.swing.JTextField txtcrop_id;
    private javax.swing.JTextField txtcrop_name;
    private javax.swing.JTextField txtcropamount;
    private javax.swing.JTextField txtharvestdate;
    private javax.swing.JTextField txtplantersname;
    private javax.swing.JTextField txtsearch;
    // End of variables declaration//GEN-END:variables
}
