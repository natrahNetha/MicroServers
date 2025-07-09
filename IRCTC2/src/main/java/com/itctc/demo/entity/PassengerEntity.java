package com.itctc.demo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Passenger_Details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassengerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer pid;
    private String name;
    private String source;
    private String destination;
    private Date journeryDate;
    private Double fare;
    private Integer trainNum;
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
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
		return "PassengerEntity [pid=" + pid + ", name=" + name + ", source=" + source + ", destination=" + destination
				+ ", journeryDate=" + journeryDate + ", fare=" + fare + ", trainNum=" + trainNum + "]";
	}
	
}
