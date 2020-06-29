package com.hiberus.logistic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hiberus.commons.dto.LogisticDTO;
import com.hiberus.commons.dto.OrderResponseDTO;
import com.hiberus.logistic.service.LogisticService;

@RestController
public class LogisticController {

	@Autowired
	LogisticService logisticService;

	@PostMapping("logistic")
	public ResponseEntity<OrderResponseDTO> logistic(@RequestBody LogisticDTO logisticDTO) {
		return new ResponseEntity<>(logisticService.logistic(logisticDTO), HttpStatus.OK);
	}

}
