package project;

import java.io.Serializable;
import java.util.Date;

public class RepairInfo implements Serializable{
	private int type; //1-fair, 2-used, 3-poor, 4-broken
	private String ticketNumber;
	private Date ticketDate;
	private String comments;
	private int assetStatusId;
	
	public RepairInfo(int type, String ticketNumber, Date ticketDate, String comments, int assetStatusId){
		this.type = type;
		this.ticketNumber = ticketNumber;
		this.ticketDate = ticketDate;
		this.comments = comments;
		this.assetStatusId = assetStatusId;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getTicketNumber() {
		return ticketNumber;
	}
	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	public Date getTicketDate() {
		return ticketDate;
	}
	public void setTicketDate(Date ticketDate) {
		this.ticketDate = ticketDate;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public int getAssetStatusId() {
		return assetStatusId;
	}
	public void setAssetStatusId(int assetStatusId) {
		this.assetStatusId = assetStatusId;
	}
}
