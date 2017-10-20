package com.cmp494rest;

import java.util.ArrayList;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MedicationPlan {
	
	private Medication medication;
	private float dose;
	private String duration;
	private String StartDate;
	private String EndDate;

	private ArrayList<MedicationPlan> MedicationHistory = new ArrayList<MedicationPlan>();

	public float getDose() {
		return dose;
	}

	public void setDose(float dose) {
		this.dose = dose;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getStartDate() {
		return StartDate;
	}

	public void setStartDate(String startDate) {
		StartDate = startDate;
	}

	public String getEndDate() {
		return EndDate;
	}

	public void setEndDate(String endDate) {
		EndDate = endDate;
	}

	public ArrayList<MedicationPlan> getMedicationHistory() {
		return MedicationHistory;
	}

	public void setMedicationHistory(ArrayList<MedicationPlan> medicationHistory) {
		MedicationHistory = medicationHistory;
	}
	
	public void addMedicationHistory(MedicationPlan medicationHistory) {
		MedicationHistory.add(medicationHistory);
	}
	
	public long calDuration() {
		
		Date start = new Date();
		Date  end  = new Date();
		
		try {
           
            DateFormat df = new SimpleDateFormat("EEE MMM dd kk:mm:ss zzz yyyy");
             start =  df.parse(StartDate);
             end =  df.parse(EndDate);

        } catch (ParseException pe) {
            pe.printStackTrace();
        }
		
		return getDateDiff(end, start, TimeUnit.DAYS);
	}
	
	public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
	    long diffInMillies = date2.getTime() - date1.getTime();
	    return timeUnit.convert(diffInMillies,TimeUnit.DAYS);
	}

	public Medication getMedication() {
		return medication;
	}

	public void setMedication(Medication medication) {
		this.medication = medication;
	}
	
	

	





}