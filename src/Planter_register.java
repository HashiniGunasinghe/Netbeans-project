
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
public class Planter_register extends javax.swing.JFrame {

    /**
     * Creates new form Register
     */
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    DefaultTableModel d;
    
    
    
    public Planter_register() {
        initComponents();
        con=SQLCON.connect();
        Planter_id();
        addplanterLoad();
        
    }

    
    //auto gen planter Id    
        public void Planter_id()
   {
       try
       {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(planter_ID) FROM register");
            rs.next();
            rs.getString("MAX(planter_ID)");
           
            if(rs.getString("MAX(planter_ID)")==null)
            {
                txtplanterid.setText("PID00001");
            }
            else
            {
                long planterid = Long.parseLong(rs.getString("MAX(planter_ID)").substring(3,rs.getString("MAX(planter_ID)").length()));
                planterid++;
                txtplanterid.setText("PID" + String.format("%05d", planterid));
            }
        }
       
     catch (SQLException ex) {
            Logger.getLogger(Planter_register.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
        
        
         
        //Adding Item to Jtable
   public void addplanterLoad()
   {
       int c;
        try {
            pst = con.prepareStatement("SELECT * FROM register");
            rs = pst.executeQuery();
           
            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
            d = (DefaultTableModel)tblplanter.getModel();
         
            d.setRowCount(0);
            
           
//** While loop for load the data
            while(rs.next())
            {
              Vector v2 = new Vector();
              for(int i=1; i<=c; i++)
              {
              
              v2.add(rs.getString("planter_ID"));
              v2.add(rs.getString("planter_fname"));
              v2.add(rs.getString("planter_lname"));
              v2.add(rs.getString("planter_address"));
              v2.add(rs.getString("planter_telno"));
              v2.add(rs.getString("planter_district"));
              
            
              
                                      
              }
             
             d.addRow(v2);
             
            }
             
        } catch (SQLException ex) {
            Logger.getLogger(Planter_register.class.getName()).log(Level.SEVERE, null, ex);
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

        txtaddress2 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtplanterid = new javax.swing.JTextField();
        txtplanteraddress = new javax.swing.JTextField();
        txtplanterlname = new javax.swing.JTextField();
        txtplantertelno = new javax.swing.JTextField();
        txtplanterfname = new javax.swing.JTextField();
        btnadd = new javax.swing.JButton();
        txtconfirmpassword = new javax.swing.JPasswordField();
        txtpassword = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnsearch = new javax.swing.JButton();
        txtsearch = new javax.swing.JTextField();
        btndelete = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        btnreset = new javax.swing.JButton();
        lbldistrict = new javax.swing.JLabel();
        txtdistrict = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblplanter = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel8.setText("Planter/Plantation registration form");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(30, 30, 30))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        txtplanterlname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtplanterlnameActionPerformed(evt);
            }
        });

        txtplantertelno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtplantertelnoActionPerformed(evt);
            }
        });

        btnadd.setBackground(new java.awt.Color(255, 255, 255));
        btnadd.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnadd.setText("Add");
        btnadd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 4, true));
        btnadd.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Planter/Plantation ID");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Planter First name");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("Planter Last name");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("Planter/Plantation Address");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("Planter Telephone number");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setText("Password");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setText("Confirm Password");

        btnsearch.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnsearch.setText("Search");
        btnsearch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchActionPerformed(evt);
            }
        });

        txtsearch.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        btndelete.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btndelete.setText("Delete");
        btndelete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
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

        btnreset.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnreset.setText("Reset");
        btnreset.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        btnreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresetActionPerformed(evt);
            }
        });

        lbldistrict.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbldistrict.setText("District");

        txtdistrict.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtdistrict.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nuwaraeliya", "Kandy", "Badulla", "Rathnapura", "Kegalle", "Mathale", "Kurunegala", "Colombo", "Kaluthara", "Galle", "Mathara", "Monaragala", "Hambanthota" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbldistrict, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(66, 66, 66)
                                        .addComponent(btnupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)))))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnreset, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addComponent(btnadd, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtdistrict, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtplanterid)
                                        .addComponent(txtplanterfname)
                                        .addComponent(txtplanterlname)
                                        .addComponent(txtplanteraddress)
                                        .addComponent(txtplantertelno)
                                        .addComponent(txtpassword)
                                        .addComponent(txtconfirmpassword, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)))
                                .addGap(62, 62, 62))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnsearch, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(txtsearch))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(txtplanterid, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtplanterfname, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 81, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtplanterlname, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtplanteraddress, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(29, 29, 29)
                        .addComponent(lbldistrict)
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtconfirmpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnreset, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnadd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(14, 14, 14))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtplantertelno, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtdistrict, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        tblplanter.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Planter/Palntation ID", "Planter's First Name", "Planter's Last Name", "Palnter/Plantation Address", "Planter's tel no", "district"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblplanter);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtplantertelnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtplantertelnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtplantertelnoActionPerformed

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        
        String id=txtplanterid.getText();
        String firstname=txtplanterfname.getText();
        String lastname=txtplanterlname.getText();
        String address=txtplanteraddress.getText();
        String phone=txtplantertelno.getText();
        String district=txtdistrict.getSelectedItem().toString();
        String password=txtpassword.getText();
        String cpassword=txtconfirmpassword.getText();
        
        
        
        
        
         if (id.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Enter planter ID");
            }
         else if (firstname.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Enter first name");
            }
        else if (lastname.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Enter last name");
            }
        else if (address.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Enter Address");
            }
        
         // contact validation
        else if (!(Pattern.matches("^\\d{10}$", txtplantertelno.getText())))
            {
                JOptionPane.showMessageDialog(null, "Please Eneter Valid Contact Number", "Error",JOptionPane.ERROR_MESSAGE);
            }
         else if (district.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Select a District");
            }
          
        else if (password.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Enter password");
            }
        
           
        else if (cpassword.equals(""))
            {
                JOptionPane.showMessageDialog(null,"RE-Enter password");
            }
        else
        {
        
        
        
        String sql="INSERT INTO register VALUES (?,?,?,?,?,?,?,?)";
        
        try
        {
            pst=con.prepareStatement(sql);
            pst.setString(1, txtplanterid.getText());
            pst.setString(2, txtplanterfname.getText());
            pst.setString(3, txtplanterlname.getText());
            pst.setString(4, txtplanteraddress.getText());
            pst.setString(5,txtplantertelno.getText());
            pst.setString(6,txtdistrict.getSelectedItem().toString());
            pst.setString(7, txtpassword.getText());
            pst.setString(8, txtconfirmpassword.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data added Successfully");
            
            
            
            
            
            //clear added data
            txtplanterid.setText("");
            txtplanterfname.setText("");
            txtplanterlname.setText("");
            txtplanteraddress.setText("");
            txtplantertelno.setText("");
            txtdistrict.setSelectedIndex(-1);
            txtpassword.setText("");
            txtconfirmpassword.setText("");
            Planter_id();
            addplanterLoad();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        }
    }//GEN-LAST:event_btnaddActionPerformed

    private void txtplanterlnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtplanterlnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtplanterlnameActionPerformed

    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed
        // TODO add your handling code here:
         try
        {
        Statement st= con.createStatement();
        String search=txtsearch.getText();
        
        String sql="SELECT * FROM register WHERE planter_ID ='"+search+"'";
        ResultSet rs=st.executeQuery(sql);
        
        if (rs.next()==false)
        {
             JOptionPane.showMessageDialog(null,"invalid Planter ID");
        }
     
        
        String p_id=rs.getString("planter_ID");
       txtplanterid.setText(p_id);
        
        String p_fname=rs.getString("planter_fname");
        txtplanterfname.setText(p_fname);

        
        String p_lname=rs.getString("planter_lname");
        txtplanterlname.setText(p_lname);
        
        String p_address=rs.getString("planter_address");
        txtplanteraddress.setText(p_address);
        
                
        String p_telno=rs.getString("planter_telno");
        txtplantertelno.setText(p_telno);
        
         String district=rs.getString("planter_district");
        txtdistrict.setSelectedItem(district);
        
        
        String p_password=rs.getString("password");
        txtpassword.setText(p_password);
        
        String p_cpassword=rs.getString("c_password");
        txtconfirmpassword.setText(p_cpassword);
        
        
        
        
        
        //clear added data
            txtsearch.setText("");

        
          

              
       
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_btnsearchActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        // TODO add your handling code here:
        
        String id=txtplanterid.getText();
        String sql="DELETE  FROM register WHERE planter_ID ='"+id+"'";
        
        int opt = JOptionPane.showConfirmDialog(null, "Are you sure to delete details?","Delete",JOptionPane.YES_NO_OPTION);
        if(opt==0)
        
         try
        {
           
           pst=con.prepareStatement(sql);
           
           pst.execute();
           
           JOptionPane.showMessageDialog(null,"succesefully Delete");
           
           //clear added data
            txtplanterid.setText("");
            txtplanterfname.setText("");
            txtplanterlname.setText("");
            txtplanteraddress.setText("");
            txtplantertelno.setText("");
            txtdistrict.setSelectedIndex(-1);
            txtpassword.setText("");
            txtconfirmpassword.setText("");
            Planter_id();
            addplanterLoad();
        }
        catch (Exception e)
        {
         JOptionPane.showMessageDialog(null,e);
        }
       
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        // TODO add your handling code here:
         String id=txtplanterid.getText();
        String firstname=txtplanterfname.getText();
        String lastname=txtplanterlname.getText();
        String address=txtplanteraddress.getText();
        String phone=txtplantertelno.getText();
        String district=txtdistrict.getSelectedItem().toString();
        String password=txtpassword.getText();
        String cpassword=txtconfirmpassword.getText();
        
        
        
        
        
         if (id.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Enter planter ID");
            }
         else if (firstname.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Enter first name");
            }
        else if (lastname.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Enter last name");
            }
        else if (address.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Enter Address");
            }
        
         // contact validation
        else if (!(Pattern.matches("^\\d{10}$", txtplantertelno.getText())))
            {
                JOptionPane.showMessageDialog(null, "Please Eneter Valid Contact Number", "Error",JOptionPane.ERROR_MESSAGE);
            }
         else if (district.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Select a District");
            }
          
        else if (password.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Enter password");
            }
        
           
        else if (cpassword.equals(""))
            {
                JOptionPane.showMessageDialog(null,"RE-Enter password");
            }
        else
        {
        
        
        
        
        String sql="UPDATE register SET planter_ID=?, planter_fname=? , planter_lname=? , planter_address=? , planter_telno=?,planter_district=?, password=?, c_password=? WHERE planter_ID='"+id+"'";
        
        
        
        
     
        try
        {
            pst=con.prepareStatement(sql);
            pst.setString(1, txtplanterid.getText());
            pst.setString(2, txtplanterfname.getText());
            pst.setString(3, txtplanterlname.getText());
            pst.setString(4, txtplanteraddress.getText());
            pst.setString(5,txtplantertelno.getText());
            pst.setString(6,txtdistrict.getSelectedItem().toString());
            pst.setString(7, txtpassword.getText());
            pst.setString(8, txtconfirmpassword.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Updated the Data");
            
            
            
            
            
            //clear added data
            txtplanterid.setText("");
            txtplanterfname.setText("");
            txtplanterlname.setText("");
            txtplanteraddress.setText("");
            txtplantertelno.setText("");
            txtdistrict.setSelectedIndex(-1);
            txtpassword.setText("");
            txtconfirmpassword.setText("");
            Planter_id();
            addplanterLoad();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        }
        
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btnresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetActionPerformed
        // TODO add your handling code here:
        
            //clear added data
            
            txtplanterid.setText("");
            txtplanterfname.setText("");
            txtplanterlname.setText("");
            txtplanteraddress.setText("");
            txtplantertelno.setText("");
            txtdistrict.setSelectedIndex(-1);
            txtpassword.setText("");
            txtconfirmpassword.setText("");
            Planter_id();
            addplanterLoad();
    }//GEN-LAST:event_btnresetActionPerformed

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
            java.util.logging.Logger.getLogger(Planter_register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Planter_register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Planter_register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Planter_register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Planter_register().setVisible(true);
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbldistrict;
    private javax.swing.JTable tblplanter;
    private javax.swing.JTextField txtaddress2;
    private javax.swing.JPasswordField txtconfirmpassword;
    private javax.swing.JComboBox<String> txtdistrict;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JTextField txtplanteraddress;
    private javax.swing.JTextField txtplanterfname;
    private javax.swing.JTextField txtplanterid;
    private javax.swing.JTextField txtplanterlname;
    private javax.swing.JTextField txtplantertelno;
    private javax.swing.JTextField txtsearch;
    // End of variables declaration//GEN-END:variables

    private Object getSelectedItem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
