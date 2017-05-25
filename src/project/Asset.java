package project;

import java.io.Serializable;

public class Asset implements Serializable {
	private String branch;
	private String assetTag;
	private int currentStatus; //1 - Active, 2 - Inactive, 3 - Repair
	private String assetType;
	private String model;
	private String serialNumber;
	private String purchaseOrder;
	private String unitCost;
	private String location;
	private String building;
	private String roomNumber;
	private boolean softwareOS;
	private String description;
	private int account_id;
	
	public Asset(){}
	public Asset(String branch, String assetTag, int currentStatus, String assetType){
		this.branch = branch;
		this.assetTag = assetTag;
		this.currentStatus = currentStatus;
		this.assetType = assetType;
	}
	
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getAssetTag() {
		return assetTag;
	}
	public void setAssetTag(String assetTag) {
		this.assetTag = assetTag;
	}
	public int getCurrentStatus() {
		return currentStatus;
	}
	public void setCurrentStatus(int currentStatus) {
		this.currentStatus = currentStatus;
	}
	public String getAssetType() {
		return assetType;
	}
	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getPurchaseOrder() {
		return purchaseOrder;
	}
	public void setPurchaseOrder(String purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}
	public String getUnitCost() {
		return unitCost;
	}
	public void setUnitCost(String unitCost) {
		this.unitCost = unitCost;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getBuilding() {
		return building;
	}
	public void setBuilding(String building) {
		this.building = building;
	}
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	public boolean isSoftwareOS() {
		return softwareOS;
	}
	public void setSoftwareOS(boolean softwareOS) {
		this.softwareOS = softwareOS;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
}
