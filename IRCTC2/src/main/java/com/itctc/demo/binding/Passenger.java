package com.itctc.demo.binding;

import java.util.Date;

import lombok.Data;

@Data
public class Passenger {
    private String name;
    private String source;
    private String destination;
    private Date journeryDate;
    private Double fare;
    private Integer trainNum;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Date getJourneryDate() {
		return journeryDate;
	}
	public void setJourneryDate(Date journeryDate) {
		this.journeryDate = journeryDate;
	}
	public Double getFare() {
		return fare;
	}
	public void setFare(Double fare) {
		this.fare = fare;
	}
	public Integer getTrainNum() {
		return trainNum;
	}
	public void setTrainNum(Integer trainNum) {
		this.trainNum = trainNum;
	}
	@Override
	public String toString() {
		return "Passenger [name=" + name + ", source=" + source + ", destination=" + destination + ", journeryDate="
				+ journeryDate + ", fare=" + fare + ", trainNum=" + trainNum + "]";
	}
	
    
}
