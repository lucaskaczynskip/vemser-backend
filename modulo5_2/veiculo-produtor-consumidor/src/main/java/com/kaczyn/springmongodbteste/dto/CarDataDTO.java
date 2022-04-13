package com.kaczyn.springmongodbteste.dto;

import java.time.LocalDate;

import lombok.Data;

@Data 
public class CarDataDTO {
	
	private String id;
	private Integer rotation;
	private Double speed;
	private boolean brakingSensor;
	private final LocalDate lectureDate = LocalDate.now();
}
