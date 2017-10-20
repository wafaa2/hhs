package com.cmp494rest;

public class ImageRecord{
	
	private int imageNo;

	private String imageType;

	private String notes;
	
	private String link;
	
	private String date;
	
	
	public ImageRecord() {
	
	}
	

	public ImageRecord(int imageNo, String imageType, String notes, String link, String date) {
		super();
		this.imageNo = imageNo;
		this.imageType = imageType;
		this.notes = notes;
		this.link = link;
		this.date = date;
	}

	public int getImageNo() {
		return imageNo;
	}

	public void setImageNo(int imageNo) {
		this.imageNo = imageNo;
	}

	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	} 
	
	
	
	

	
	
}
