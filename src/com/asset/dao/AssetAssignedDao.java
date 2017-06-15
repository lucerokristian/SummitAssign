package com.asset.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.asset.model.Asset;
import com.asset.util.Database;
import com.asset.model.AssetAssigned;

public class AssetAssignedDao {
	 private Connection connection;

	    public  AssetAssignedDao() {
	        connection = Database.getConnection();
	    }

public List<Asset> AssetByUsername(String username) {
	List<Asset> assets = new ArrayList<Asset>();
		 try {
			
			 Statement statement = connection.createStatement();
			 System.out.println(username);
			 
	        /* ResultSet rs = statement.executeQuery("SELECT asset.branch,asset.asset_type,asset.model,asset.serial_number,asset.building,asset.location from asset INNER JOIN assetassigned ON asset.id=assetassigned.assetid where assetassigned.username='"+username+"'");*/
			 ResultSet rs = statement.executeQuery("SELECT asset.branch,asset.asset_type,asset.model,asset.serial_number,asset.building,asset.location "
	                                                +"from asset INNER JOIN assetassigned ON asset.id=assetassigned.assetid"
					                                 +" INNER  JOIN account on account.id=assetassigned.user_id"
	                                                +"where account.username='"+username+"'");
	         System.out.println("outside loop");
	         while (rs.next()) {
		         System.out.println("in loop");

	           Asset asset = new Asset();
	           
	             asset.setBranch(rs.getString("branch"));
	             asset.setAssetType(rs.getString("asset_type"));
	             asset.setModel(rs.getString("model"));
	             asset.setSerialNumber(rs.getString("serial_number"));
	             asset.setLocation(rs.getString("location"));
	             asset.setBuilding(rs.getString("building"));
	             
	             assets.add(asset);
	             System.out.println("in dao");
	         }

	     } catch (SQLException e) {
	         e.printStackTrace();
	     }
		 return assets;
}

public List<Asset> getReportByStatus(String status) {
	List<Asset> assets = new ArrayList<Asset>();
	 try {
		
		/* Statement statement = connection.createStatement();*/
		
		 
		 PreparedStatement preparedStatement = connection.prepareStatement("select branch,asset_type,model,serial_number,building,location from asset where status =?");
         preparedStatement.setString(1, status);
         ResultSet rs = preparedStatement.executeQuery();
         
         System.out.println("outside loop");
         System.out.println(rs);
         System.out.println("ughdbqhd");
         if (rs.next()) {
	         System.out.println("in loop");

           Asset asset = new Asset();
           
             asset.setBranch(rs.getString("branch"));
             asset.setAssetType(rs.getString("asset_type"));
             asset.setModel(rs.getString("model"));
             asset.setSerialNumber(rs.getString("serial_number"));
             asset.setBuilding(rs.getString("building"));
             asset.setLocation(rs.getString("location"));
            
             
             assets.add(asset);
            /* System.out.println("in dao");*/
         }

     } catch (SQLException e) {
         e.printStackTrace();
     }
	 return assets;
}




 
}

