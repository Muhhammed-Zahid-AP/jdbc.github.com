package com.tap;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

import java.util.Scanner;

public class program1 {
	
	






	public static void close(Connection c,Statement st,ResultSet res) {
		try {
			if(res != null)
			{
				res.close();
			}
		}
		 catch (SQLException e) {
	            e.printStackTrace();
	        }
		try {
			if(st != null)
			{
				st.close();
			}
		}
		 catch (SQLException e) {
	            e.printStackTrace();
	        }
		try {
			if(c != null)
			{
				c.close();
			}
		}
		 catch (SQLException e) {
	            e.printStackTrace();
	        }
		
			
		}
	
	public static void display(Connection c,Statement st,ResultSet res)throws SQLException
	{
		 String sql = "SELECT * from employee";
		    st = c.createStatement();
		    res = st.executeQuery(sql);
		    System.out.println("--------------------------------------------------");
		    while (res.next()) {
		        int id = res.getInt("id");
		        String name = res.getString("name");
		        String email = res.getString("email");
		        String dept = res.getString("dept");
		        int salary = res.getInt("salary");
		        

		        System.out.printf("| %d | %-7s | %-15s | %-5s | %d |\n", id, name, email, dept, salary);
		    }
		    System.out.println("--------------------------------------------------");
		}
	
	
	
	
	

    public static void main(String[] args) {

    	
    	Connection c=null;
    	Statement st=null;
    	ResultSet res=null;
    	
    	
    	
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String username = "root";
        String password = "root";
        

        try {
        c= DriverManager.getConnection(url, username, password); 
        display(c,st,res);
        
        
         
        	
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
        	close(c,st,res);
        }
        
        }
    }
