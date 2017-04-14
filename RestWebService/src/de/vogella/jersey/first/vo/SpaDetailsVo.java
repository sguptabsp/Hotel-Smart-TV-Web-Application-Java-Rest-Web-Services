package de.vogella.jersey.first.vo;

public class SpaDetailsVo {
	private int spaId;
	private String spaDetails;
	private int price;
	private int duration;
	
	public int getSpaId() {
		return spaId;
	}
	public void setSpaId(int spaId) {
		this.spaId = spaId;
	}
	public String getSpaDetails() {
		return spaDetails;
	}
	public void setSpaDetails(String spaDetails) {
		this.spaDetails = spaDetails;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
}
