package com.kaczyn.springmongodbteste.service;

import java.util.List;
import java.util.OptionalDouble;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kaczyn.springmongodbteste.dto.CarDashboard;
import com.kaczyn.springmongodbteste.dto.CarDataDTO;
import com.kaczyn.springmongodbteste.entity.CarDataEntity;
import com.kaczyn.springmongodbteste.repository.CarDataRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CarDataService {
	
	private final CarDataRepository carDataRepository;
	private final ObjectMapper mapper;
	
	public void insert(CarDataDTO carDataDTO) {
		this.carDataRepository.save(mapper.convertValue(carDataDTO, CarDataEntity.class));
	}
	
	public List<CarDataDTO> findAll() {
		return this.carDataRepository.findAll().stream()
				.map(car -> this.mapper.convertValue(car, CarDataDTO.class))
				.toList();
	}
	
	public CarDashboard dashboard() {
		List<CarDataDTO> cars = this.findAll();
		
		OptionalDouble speed = cars.stream().mapToDouble(CarDataDTO::getSpeed).average();
		OptionalDouble rotation = cars.stream().mapToDouble(CarDataDTO::getRotation).average();
	
		CarDashboard carDashboard = new CarDashboard();
		carDashboard.setRotationMedia(rotation.getAsDouble());
		carDashboard.setSpeedMedia(speed.getAsDouble());
		carDashboard.setLectureQuantity(cars.size());
		return carDashboard;
	}
}
