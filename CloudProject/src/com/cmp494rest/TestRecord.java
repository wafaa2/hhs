package com.cmp494rest;

public class TestRecord {
	
	private int testNo;

	private String link;

	private String notes;
	
	private String date;

	public int getTestNo() {
		return testNo;
	}

	public void setTestNo(int testNo) {
		this.testNo = testNo;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public TestRecord(int testNo, String link, String notes, String date) {
		super();
		this.testNo = testNo;
		this.link = link;
		this.notes = notes;
		this.date = date;
	} 
	
	
	
	
}
