/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbms;
/**
 *
 * @author Amulya
 */

import javax.swing.JFrame;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

import java.lang.*;
import java.util.*;
import java.sql.*;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.*;
import java.net.*;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Student2 extends javax.swing.JFrame  implements ActionListener {

	Connection co;
	int id;
	int flag;
    /**
     * Creates new form Student2
     */
	
	public int Compute()
	{
		String days="";
        try
        {
        Statement stmt=co.createStatement();
       
        Calendar cal = Calendar.getInstance();
        int val = cal.get(Calendar.DAY_OF_WEEK);
      

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY/MM/dd");
        String dates=LocalDate.now().format(formatter);
  	 // System.out.println("Studne2"+dates);
        Calendar cal1 = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String timer=sdf.format(cal1.getTime());
        
  	       
        
        switch(val)
        {
        case 1: days="Sunday";
                break;
        case 2: days="Monday";
                break;
        case 3: days="Tuesday";
        		break;
        case 4: days="Wednesday";
        		break;
        case 5: days="Thursday";
        		break;
        case 6: days="Friday";
        		break;
        case 7: days="Saturday";
        		break;
        		
        
        }
       // System.out.println(days+"Days");
   
        
        ResultSet rs2=stmt.executeQuery("select day from timeTable where rollno=" + " '"+id+"';" );
		  
	      while (rs2.next())
	      {
	       	if(rs2.getString("day").equals(days)) 
	       	{
	       	    ResultSet rs=stmt.executeQuery("select start_time ,end_time from timeTable where rollno=" + " '"+id+"' and day="+"'"+days+"';" );
	       	    rs.next();
	       	   int c= rs.getString("start_time").compareTo(timer);
	       	   int d=rs.getString("end_time").compareTo(timer);
		       	if( c<d ) 
		       	{	
		       	ResultSet r=stmt.executeQuery("select start_time ,end_time,lab_no,professor_name from timeTable where rollno=" + " '"+id+"' and day="+"'"+days+"';");	
		       	r.next();
		       	String str=r.getString("start_time");
		    	String stre=r.getString("end_time");
		    	String strl=r.getString("lab_no");
		    	String strp=r.getString("professor_name");
		    	
		        stmt.executeUpdate("insert into TAA(rollNO,TDate,start_time,end_time,Lab_no,professor_name,Attendance)"+  "values( '"+id+"','"+dates+"','"+str+"','"+stre+"','"+strl+"','"+strp+"','P'); ");
		        return 0;
		       	}
		   
		        break;
	       	}
	      }//while
        
	      
        
        
        }//try
        catch(Exception e){}
return -1;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    public Student2(Connection con,int id) {
        initComponents();
        co=con;
        this.id=id;
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        profile_btn = new javax.swing.JButton();
        TA_btn = new javax.swing.JButton();
        timetable_btn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        worklog_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("MENU");

        profile_btn.setText("Profile");
        profile_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
               // profile_btnActionPerformed(evt);
        });

        TA_btn.setText("Mark TA Attendance");
        TA_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TA_btnActionPerformed(evt);
            }
        });

        timetable_btn.setText("Time Table");
        timetable_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timetable_btnActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("TA-SHIP ATTENDANCE");

        jSeparator2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jSeparator1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 50)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("M.E Stipend Management System");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("MARK ATTENDANCE");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(this);

        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel1.setText("   MARK TODAY'S ATTENDACE");

        worklog_btn.setText("Work-Log");
        worklog_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                worklog_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(worklog_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(timetable_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TA_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(profile_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(29, 29, 29)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(291, 291, 291)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(300, 300, 300)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(40, 40, 40))
            .addGroup(layout.createSequentialGroup()
                .addGap(187, 187, 187)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 841, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(215, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(27, 27, 27)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel5)
                        .addGap(63, 63, 63)
                        .addComponent(profile_btn)
                        .addGap(64, 64, 64)
                        .addComponent(TA_btn)
                        .addGap(68, 68, 68)
                        .addComponent(timetable_btn)
                        .addGap(74, 74, 74)
                        .addComponent(worklog_btn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel6)
                        .addGap(87, 87, 87)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    
    public void actionPerformed(ActionEvent ae)
  	 {
  		   if(ae.getSource()==jButton1)
  		   {
  			   try
  			   {
  			   Connection 	co=DriverManager.getConnection("jdbc:mysql://localhost/project", "amulya", "12345678");
  			   Student2 o=new Student2(co,id);
  			   
  			  int ans= o.Compute();
  			 // System.out.println("Studne2"+ans);
  			   if(ans==-1)
  			   {
  				
  			    	 JOptionPane.showMessageDialog(null,"Cannot mark you atten no seesion","Attendance error",JOptionPane.ERROR_MESSAGE);
  			     
  			    	 
  			   }
  			   else
  			   {
  				 JOptionPane.showMessageDialog(null,"Attendance marked","Attendancer",JOptionPane.INFORMATION_MESSAGE);
  			     
  			   }
  			   
  			   }
  			   catch(Exception e){}
  		   }
  	 }

    private void timetable_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timetable_btnActionPerformed
        // TODO add your handling code here:
                this.setVisible(false);
        new Student3(co,id).setVisible(true);
    }//GEN-LAST:event_timetable_btnActionPerformed

    


    private void worklog_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_worklog_btnActionPerformed
        // TODO add your handling code here:
         this.setVisible(false);
        new Student4(co,id).setVisible(true);
    }//GEN-LAST:event_worklog_btnActionPerformed

    private void profile_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profile_btnActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new Student1(co,id).setVisible(true);
    }//GEN-LAST:event_profile_btnActionPerformed

    private void TA_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TA_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TA_btnActionPerformed

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
            java.util.logging.Logger.getLogger(Student2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Student2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Student2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Student2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Student2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton TA_btn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton profile_btn;
    private javax.swing.JButton timetable_btn;
    private javax.swing.JButton worklog_btn;
    // End of variables declaration//GEN-END:variables
}
