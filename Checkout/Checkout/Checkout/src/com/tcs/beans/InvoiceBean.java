package com.tcs.beans;

import java.util.Date;

public class InvoiceBean {
	
	private int regNo;
	private String Name;
	private int roomNo;
	private Date checkInDate;
	private Date checkOutDate;
	private double spaCharges;
	private double mealCharges;
	private double roomCharges;
	private double taxCharges;
	private double totalCharges;
	public int getRegNo() {
		return regNo;
	}
	public void setRegNo(int regNo) {
		this.regNo = regNo;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}
	public Date getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}
	public Date getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	public double getSpaCharges() {
		return spaCharges;
	}
	public void setSpaCharges(double spaCharges) {
		this.spaCharges = spaCharges;
	}
	public double getMealCharges() {
		return mealCharges;
	}
	public void setMealCharges(double mealCharges) {
		this.mealCharges = mealCharges;
	}
	public double getRoomCharges() {
		return roomCharges;
	}
	public void setRoomCharges(double roomCharges) {
		this.roomCharges = roomCharges;
	}
	public double getTaxCharges() {
		return taxCharges;
	}
	public void setTaxCharges(double taxCharges) {
		this.taxCharges = taxCharges;
	}
	public double getTotalCharges() {
		return totalCharges;
	}
	public void setTotalCharges(double totalCharges) {
		this.totalCharges = totalCharges;
	}
	
	
	

}
