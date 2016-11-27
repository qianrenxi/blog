package org.qianrenxi.blog.entity;

import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class ReversionInfo {
	private Date date;
	private String number;
	private String remark;
	
	public ReversionInfo() {
	}

	public ReversionInfo(Date date, String number, String remark) {
		super();
		this.date = date;
		this.number = number;
		this.remark = remark;
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
