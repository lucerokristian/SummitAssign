package com.asset.model;
import java.io.Serializable;
import java.util.Date;

public class Asset implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String branch;
	private String assetTag;
	private String status;
	private String assetType;
	private String model;
	private String serialNumber;
	private String purchaseOrder;
	private String unitCost;
	private String location;
	private String building;
	private String roomNumber;
	private boolean softwareOs;
	private String description;
	private Date scanDate;
	
	public Asset(){}
	public Asset(String branch, String assetTag, String status, String assetType){
		this.branch = branch;
		this.assetTag = assetTag;
		this.status = status;
		this.assetType = assetType;
	}
	
	public Asset(String branch, String assetTag, String status, String assetType, String model, String serialNumber, String purchaseOrder, String unitCost, String location, String building, String roomNumber, boolean softwareOs, String description, Date scanDate){
		this.branch = branch;
		this.assetTag = assetTag;
		this.status = status;
		this.assetType = assetType;
		this.model = model;
		this.serialNumber = serialNumber;
		this.purchaseOrder = purchaseOrder;
		this.unitCost = unitCost;
		this.location = location;
		this.building = building;
		this.roomNumber = roomNumber;
		this.softwareOs = softwareOs;
		this.description = description;
		this.scanDate = scanDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public boolean isSoftwareOs() {
		return softwareOs;
	}
	public void setSoftwareOs(boolean softwareOs) {
		this.softwareOs = softwareOs;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getScanDate() {
		return scanDate;
	}
	public void setScanDate(Date scanDate) {
		this.scanDate = scanDate;
	}
	

}
