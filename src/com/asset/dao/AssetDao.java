package com.asset.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.asset.model.Account;
import com.asset.dao.*;
import com.asset.model.Asset;
import com.asset.util.Database;
public class AssetDao {
	  private Connection connection;

	    public AssetDao () {
	        connection = Database.getConnection();
	    }
	    public List<Asset> assetSearch( String assettype) {
	        List<Asset> assets = new ArrayList<Asset>();
	        try {
	        	
	            Statement statement = connection.createStatement();
	            ResultSet rs = statement.executeQuery("select * from asset where asset_type='"+assettype+"' ");
	            while (rs.next()) {
	                Asset asset = new Asset();
	                asset.setId(rs.getInt("id"));
	                asset.setBranch(rs.getString("branch"));
	                asset.setAssetTag(rs.getString("asset_tag"));
	                asset.setStatus(rs.getString("status"));
	                asset.setAssetType(rs.getString("asset_type"));
	                asset.setModel(rs.getString("model"));
	                asset.setSerialNumber(rs.getString("serial_number"));
	                asset.setPurchaseOrder(rs.getString("purchase_order"));
	                asset.setUnitCost(rs.getString("unit_cost"));
	                asset.setLocation(rs.getString("location"));
	                asset.setBuilding(rs.getString("building"));
	                asset.setRoomNumber(rs.getString("room_number"));
	                asset.setSoftwareOs(rs.getBoolean("software_os"));
	                asset.setDescription(rs.getString("description"));
	                asset.setScanDate(rs.getDate("scan_date"));
	                assets.add(asset);
	               /* System.out.println(asset);*/
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return assets;
	    }
		public List<Asset> getAsset() {
			{
			    List<Asset> assets = new ArrayList<Asset>();
			    try {
			    	
			        Statement statement = connection.createStatement();
			        ResultSet rs = statement.executeQuery("select branch,asset_type,model,status from asset");
			        /*System.out.println("out loop");*/
			        while (rs.next()) {
			        	
			            Asset acc = new Asset();
			            acc.setBranch(rs.getString("branch"));
			            acc.setAssetType(rs.getString("asset_type"));
			            acc.setModel(rs.getString("model"));
			            acc.setStatus(rs.getString("status"));
			           
			            assets.add(acc);
			           
			        }
			    } catch (SQLException e) {
			        e.printStackTrace();
			    }

			    return assets;
			}
		}
		
		public Asset getDataEdit(String assettype) {
			Asset asset = new Asset();
		     try {
		         PreparedStatement preparedStatement = connection.prepareStatement("select * from asset where asset_type='"+assettype+"'");
		        
		         ResultSet rs = preparedStatement.executeQuery();

		         if (rs.next()) {
		        	 asset.setAssetType(rs.getString("asset_type"));
		        	 asset.setStatus(rs.getString("status"));
		        	 
		         }
		     } catch (SQLException e) {
		         e.printStackTrace();
		     }

		     return asset;
		}
		public void checkAsset(Asset asset) {
			try {
				/*System.out.println(acc.getUsername());*/
		        PreparedStatement ps = connection.prepareStatement("select asset_type from asset where asset_type ='"+asset.getAssetType()+"'");
		       
		        ResultSet rs = ps.executeQuery();
		        System.out.println("inside check");
		        if (rs.next()) // found
		        {
		        	System.out.println("in checkaccount");
		            updateAsset(asset);
		        } 
		    } catch (Exception ex) {
		        System.out.println("Error in check() -->" + ex.getMessage());
		    } 
			
		}
		private void updateAsset(Asset asset) {
			System.out.println("enter into update");
			try {
		         PreparedStatement preparedStatement = connection.prepareStatement("update asset set  status=? where asset_type='"+asset.getAssetType()+"'");
		         preparedStatement.setString(1, asset.getStatus());
		         preparedStatement.executeUpdate();
		         System.out.println("inside update");
			 }
		 catch (SQLException e) {
		    e.printStackTrace();
		}
			
		}
		public void updateAssetRoom( String assetid, String finalroom) {
			 try {
				 System.out.println(assetid);
				 System.out.println(finalroom);
		            PreparedStatement preparedStatement = connection.prepareStatement("update asset set room_number='"+finalroom+"' where id ='"+assetid+"'");
		            preparedStatement.executeUpdate();
                    System.out.println("table updated");
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
			
		}
		
		
	    
	    
		
}
