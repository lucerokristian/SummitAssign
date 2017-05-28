package project;

import java.io.Serializable;

public class AssetStatus implements Serializable{
	private int id;
	private int status; //1-active, 2-inactive, 3-repair
	private int userId;
	private int assetId;
	
	public AssetStatus(int status, int userId, int assetId){
		this.status = status;
		this.userId = userId;
		this.assetId = assetId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
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
