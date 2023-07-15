package dbms;

import java.sql.DriverManager;

import javax.swing.JFrame;
import java.lang.*;
import java.util.*;
import java.sql.*;
import java.util.concurrent.*;
import java.net.*;
import java.util.Scanner;
import java.io.*;

/**
 *
 * @author Amulya
 */
public class Dbms {

	
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      //  new Student1().setVisible(true);
    	try
    	{
    	Class.forName("com.mysql.jdbc.Driver");  
    	Connection 	con=DriverManager.getConnection("jdbc:mysql://localhost/project", "amulya", "12345678");
        new Login(con).setVisible(true);
    	}
    	catch(Exception e){}
       
    }
    
    
}