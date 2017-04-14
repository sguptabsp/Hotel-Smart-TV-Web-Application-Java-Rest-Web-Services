package de.vogella.jersey.first.vo;

public class ContactsVO {
	private String email="";
	private String FirstName="";
	private String LastName="";
	private String Date="";
	private String perms="";
	private int extn;
	private int RoomNo;
	private int guestId;
	
	public String getEmail() {
		return email;
	}
  
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String LastName) {
		this.LastName = LastName;
	}
	public int getRoomNo() {
		return RoomNo;
	}
	public void setRoomNo(int RoomNo) {
		this.RoomNo = RoomNo;
	}
	
	public void setChkOutDate(String date) {
		this.Date = date;
	}
	public String getChkOutDate() {
		return Date;
	}
	public void setPermission(String perms) {
		this.perms = perms;
	}
	public String getPermission() {
		return perms;
	}
	public void setExtn(int extn) {
		this.extn = extn;
	}
	public int getExtn() {
		return extn;
	}

	public int getGuestId() {
		return guestId;
	}

	public void setGuestId(int guestId) {
		this.guestId = guestId;
	}
	
}
