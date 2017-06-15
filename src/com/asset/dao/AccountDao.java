package com.asset.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.asset.model.Account;
import com.asset.util.Database;

public class AccountDao {

		 private Connection connection;

		    public  AccountDao() {
		        connection = Database.getConnection();
		    }



public List<Account> getUsers() {
    List<Account> assets = new ArrayList<Account>();
    try {
    	
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select Empid,username,role,email from account");
        System.out.println("out loop");
        while (rs.next()) {
        	System.out.println("in loop");
            Account acc = new Account();
            acc.setId(rs.getInt("Empid"));
            acc.setUsername(rs.getString("username"));
            acc.setRole(rs.getString("role"));
            acc.setEmail(rs.getString("email"));
           
            assets.add(acc);
           
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return assets;
}



public void insertUser(String firstname, String lastname, String username, String password, String email, String role) {
	System.out.println("dcvgvh");
	
	try {
		PreparedStatement pt = connection.prepareStatement("insert into account(username,password,firstname,lastname,email,role) values ('"+username+"', '"+password+"', '"+firstname+"', '"+lastname+"','"+email+"','"+role+"' )");
		pt.executeUpdate();
		System.out.println(pt.executeUpdate());
	
	}
	catch(SQLException e) {
        e.printStackTrace();
    }
	
}



public Account getEmploye(String empid) {
	 Account acc = new Account();
     try {
         PreparedStatement preparedStatement = connection.prepareStatement("select * from account where id=?");
         preparedStatement.setString(1, empid);
         ResultSet rs = preparedStatement.executeQuery();

         if (rs.next()) {
        	 acc.setId(rs.getInt("Empid"));
             acc.setUsername(rs.getString("username"));
             acc.setRole(rs.getString("role"));
             acc.setEmail(rs.getString("email"));
         }
     } catch (SQLException e) {
         e.printStackTrace();
     }

     return acc;
 }



public void updateUser(Account acc2) {
	/*Account acc= new Account();*/

	 try {
         PreparedStatement preparedStatement = connection.prepareStatement("update account set  email=?, role=? where username='"+acc2.getUsername()+"'");
         preparedStatement.setString(1, acc2.getEmail());
         preparedStatement.setString(2, acc2.getRole());
         preparedStatement.executeUpdate();
         System.out.println("inside update");
         
	 }
 catch (SQLException e) {
    e.printStackTrace();
}

}



public void checkAccount(Account acc) {
	try {
		System.out.println(acc.getUsername());
        PreparedStatement ps = connection.prepareStatement("select username from account where username = ?");
        ps.setString(1, acc.getUsername());
        ResultSet rs = ps.executeQuery();
        if (rs.next()) // found
        {
        	System.out.println("in checkaccount");
            updateUser(acc);
        } 
    } catch (Exception ex) {
        System.out.println("Error in check() -->" + ex.getMessage());
    } 
}




}

