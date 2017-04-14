package de.vogella.jersey.first.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AutomatedMsgVO {
	private int msg_id;
	private String msg_subject;
	private String msg_subtype;
	private String msg_from;
	private String msg_datetime;
	private String msg_roomno;
	private String msg_guestname;
	private String msg_messages;
	private String msg_status;
	public int getMsg_id() {
		return msg_id;
	}
	public void setMsg_id(int msgId) {
		msg_id = msgId;
	}
	public String getMsg_subject() {
		return msg_subject;
	}
	public void setMsg_subject(String msgSubject) {
		msg_subject = msgSubject;
	}
	public String getMsg_subtype() {
		return msg_subtype;
	}
	public void setMsg_subtype(String msgSubtype) {
		msg_subtype = msgSubtype;
	}
	public String getMsg_from() {
		return msg_from;
	}
	public void setMsg_from(String msgFrom) {
		msg_from = msgFrom;
	}
	public String getMsg_datetime() {
		return msg_datetime;
	}
	public void setMsg_datetime(String msgDatetime) {
		msg_datetime = msgDatetime;
	}
	public String getMsg_roomno() {
		return msg_roomno;
	}
	public void setMsg_roomno(String msgRoomno) {
		msg_roomno = msgRoomno;
	}
	public String getMsg_guestname() {
		return msg_guestname;
	}
	public void setMsg_guestname(String msgGuestname) {
		msg_guestname = msgGuestname;
	}
	public String getMsg_messages() {
		return msg_messages;
	}
	public void setMsg_messages(String msgMessages) {
		msg_messages = msgMessages;
	}
	public String getMsg_status() {
		return msg_status;
	}
	public void setMsg_status(String msgStatus) {
		msg_status = msgStatus;
	}	
}