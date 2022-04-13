package com.kaczyn.springmongodbteste.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document("veiculo_consumidor")
public class CarDataEntity {

	@Id
	private String id;
	private Integer rotation;
	private Double speed;
	private boolean brakingSensor;
	private LocalDate lectureDate;
}
