package com.tap;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class mysql {
	private static Connection c;
	private static PreparedStatement st;
	private static ResultSet res;
	public static void main(String[] args) {

    	Scanner scan=new Scanner(System.in);
    	
    	
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String username = "root";
        String password = "root";
        

        try {
        c= DriverManager.getConnection(url, username, password);
       
        do {
        	System.out.println("press 1 for INSERT:"); 
            System.out.println("press 2 for UPDATE:"); 
            System.out.println("press 3 for DELETE:"); 
            System.out.println("press 4 for DISPLAY:"); 
            System.out.println("press 5 for EXIT:");
            int choice=scan.nextInt();
        
        	if(choice==1)
        	{
        		 INSERT();
        	}
        	else if(choice==2)
        	{
        		UPDATE();
        	}
        	else if(choice==3)
        	{
        		DELETE();
        	}
        	else if(choice==4)
        	{
        		DISPLAY();
        	}
        	else if(choice==5)
        	{
        		System.out.print("visit again.......");
        		System.exit(1);
        	}
        	System.out.println();
        }while(true);
        	
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
        	program1.close(c, st, res);
        }
        
        
        }
    

 static void INSERT()throws SQLException
{
	Scanner scan=new Scanner(System.in);
	String sql1="INSERT into employee(id,name,email,dept,salary)values(?,?,?,?,?)";

	 
  	   st=c.prepareStatement(sql1);
         System.out.println("enter id:");
         int idd=scan.nextInt();
         
        
         System.out.println("enter name:");
         String name=scan.next();
         System.out.println("enter email:");
         String email=scan.next();
         System.out.println("enter dept:");
         String dept=scan.next();
         System.out.println("enter salary:");
         int sal=scan.nextInt();
         
         st.setInt(1, idd);
         st.setString(2, name);
         st.setString(3, email);
         st.setString(4, dept);
         st.setInt(5, sal);
         int i= st.executeUpdate();
         System.out.println(i+"rows inserted");
         
    
}

 static void UPDATE()throws SQLException
{
	Scanner scan=new Scanner(System.in);
	System.out.println("enter column Name to proceed");
	String ip=scan.nextLine();
	
	String sql2="UPDATE employee set "+ip+"=? where id=?";

	 
  	   st=c.prepareStatement(sql2);
       
         
        if(ip.equals("id") || ip.equals("salary") )
        {
        	System.out.println("enter Value to proceed");
        	 st.setInt(1, scan.nextInt());
        }
        else
        {
        	System.out.println("enter Value to proceed");
        	st.setString(1, scan.nextLine());
        }
        System.out.println("enter Id to proceed:");
        st.setInt(2, scan.nextInt());
        
         
         int i= st.executeUpdate();
         System.out.println(i+"rows inserted");
}
 static void DELETE()throws SQLException
 {
 	Scanner scan=new Scanner(System.in);
 
 	System.out.println("enter,which column based row you need to delete");
 	String ip=scan.nextLine();
 	String sql3="DELETE from employee where "+ip+"=?";
 			
 		

 	 
   	   st=c.prepareStatement(sql3);
        
          
         if(ip.equals("id") || ip.equals("salary") )
         {
         	System.out.println("enter further information to proceed");
         	 st.setInt(1, scan.nextInt());
         }
         else
         {
         	System.out.println("enter further information to proceed");
         	st.setString(1, scan.nextLine());
         }
       
         
          
          int i= st.executeUpdate();
          System.out.println(i+"rows inserted");
 }
 static void DISPLAY()throws SQLException
 {
 	
 
 	String sql4="SELECT * from employee";
 			
 			

 	 
   	 Statement  st=c.createStatement();
   	 res=st.executeQuery(sql4);
        
   	 System.out.println("------------------------------------------------------");  
   	 while (res.next()) {
	        int idd = res.getInt("id");
	        String namee = res.getString("name");
	        String emaill = res.getString("email");
	        String deptt = res.getString("dept");
	        int salaryy = res.getInt("salary");
	        

	        System.out.printf("| %d | %-7s | %-19s | %-5s | %d |\n", idd, namee, emaill, deptt, salaryy);
	       
 }
   	 System.out.println("------------------------------------------------------");
}
}
