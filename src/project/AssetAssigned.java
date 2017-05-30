package project;

import java.io.Serializable;

public class AssetAssigned implements Serializable{
	private int id;
	private int userId;
	private int assetId;
	
	public AssetAssigned(){}
	public AssetAssigned(int userId, int assetId){
		this.userId = userId;
		this.assetId = assetId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getAssetId() {
		return assetId;
	}
	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}
}
