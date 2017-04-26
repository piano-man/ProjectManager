/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectmanagementsystem;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import static projectmanagementsystem.Query.displayMessage;


/**
 *
 * @author prank
 */
 
public class Teacher extends javax.swing.JFrame {

    /**
     * Creates new form Teacher
     */
  //String uid;
    public Teacher() {
        initComponents();
    }

         public Teacher(String para)
    {
        initComponents();
        tf1.setText(para);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlist1 = new javax.swing.JList<>();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tf1 = new javax.swing.JTextField();
        grade = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("View Projects");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 200, 124, 39));

        jlist1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jlist1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 250, 124, 170));

        jButton2.setText("Grade");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 200, 124, 39));

        jButton3.setText("Back");
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(695, 393, 70, 30));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("TeacherId");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 140, -1, -1));
        getContentPane().add(tf1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 130, 190, 40));

        grade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gradeActionPerformed(evt);
            }
        });
        getContentPane().add(grade, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 260, 124, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectmanagementsystem/all.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 700));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
 //String uid;
    private void gradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gradeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gradeActionPerformed

   
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
try
{
   
String name = tf1.getText();
Class.forName("com.mysql.jdbc.Driver");
java.sql.Connection con=null;
con = DriverManager.getConnection("jdbc:mysql://localhost/ProjectManagementSystem","root","bubu");
String query1 ="SELECT subject from Teachers where username ='"+name+"';";
Statement st1 = con.createStatement();
ResultSet rs1 = st1.executeQuery(query1);
rs1.next();
String sub = rs1.getString("subject");
String stat = "Complete";
String query = "SELECT * from Projects where Subject= '"+sub+"' and Status='"+stat+"';";
Statement st2 = con.createStatement();
ResultSet rs2 = st2.executeQuery(query);
DefaultListModel listModel;
listModel = new DefaultListModel();
//JList jlist1 = new JList(listModel);
int i=0;
String[] arr = new String[100]; 
while(rs2.next())
{
    
        String id = rs2.getString("ProjectId");
        //String nam = rs2.getString("Name");
        String ele = id;
        listModel.addElement(ele);
       
        arr[i]=ele;
        
        i++;
        
        

               
    
}
 jlist1.setModel(listModel);
//System.out.println(arr[0]);
//int k = 0;
//while ( arr[k]!="/0")
//{
  //  listModel.addElement((String)arr[k]);
    //k++;
//}
//jlist1.setModel(listModel);




   
    
        

jlist1.setModel(listModel);

// TODO add your handling code here:
}
catch(Exception e)
{
                       System.out.println(e.getMessage());

    
}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
  try{ 
       int a =Integer.parseInt( grade.getText());
     String str = jlist1.getSelectedValue().toString();
      Class.forName("com.mysql.jdbc.Driver");
java.sql.Connection con=null;
con = DriverManager.getConnection("jdbc:mysql://localhost/ProjectManagementSystem","root","bubu");
String q1  = "update Projects set Marks ="+a+" where ProjectId='"+str+"';";

 PreparedStatement pst = con.prepareStatement(q1);
 int updateCount = pst.executeUpdate();
 displayMessage("Your grade has been recorded","Prompt");

       
     //System.out.println(a);
   // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed
        catch(Exception e)
    {
        System.out.println(e);
    }
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
            java.util.logging.Logger.getLogger(Teacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Teacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Teacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Teacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Teacher().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField grade;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> jlist1;
    private javax.swing.JTextField tf1;
    // End of variables declaration//GEN-END:variables
}
