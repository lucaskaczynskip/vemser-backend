package com.kaczyn.springmongodbteste.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaczyn.springmongodbteste.dto.CarDashboard;
import com.kaczyn.springmongodbteste.dto.CarDataDTO;
import com.kaczyn.springmongodbteste.service.CarDataService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/car-data")
@RequiredArgsConstructor
public class CarDataController {
	
	private final CarDataService carDataService;
	
	@GetMapping
	public List<CarDataDTO> findAll() {
		return this.carDataService.findAll();
	}
	
	@GetMapping("/dashboard") 
	public CarDashboard dashboard() {
		return this.carDataService.dashboard();
	}
}
