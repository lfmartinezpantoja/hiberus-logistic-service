package com.hiberus.logistic.service.imp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiberus.commons.dto.LogisticDTO;
import com.hiberus.commons.dto.OrderResponseDTO;
import com.hiberus.logistic.service.LogisticService;

import lombok.extern.java.Log;

@Log
@Service
public class LogisticServiceImp implements LogisticService {

	@Autowired
	ModelMapper modelMapper;

	private static String ZONE = "America/Bogota";

	@Override
	public OrderResponseDTO logistic(LogisticDTO logisticDTO) {
		log.info("INPUT DATA REQUEST: " + logisticDTO);
		OrderResponseDTO orderResponseDTO = new OrderResponseDTO();
		modelMapper.map(logisticDTO, orderResponseDTO);
		LocalDate date = LocalDate.now(ZoneId.of(ZONE));
		LocalTime time = LocalTime.now(ZoneId.of(ZONE));
		orderResponseDTO.setDate(date);
		orderResponseDTO.setTime(time);
		String descriptionOrder = String.format(
				"Your order is in the process of enlistment. %s the invoice with order number %s the date %s at %s was successfully generated. Your order will be shipped to %s",
				orderResponseDTO.getClientName(), orderResponseDTO.getBillId(), orderResponseDTO.getDate(),
				orderResponseDTO.getTime(), orderResponseDTO.getAddress());
		orderResponseDTO.setDescription(descriptionOrder);
		log.info("OUTPUT DATA REQUEST: " + logisticDTO);
		return orderResponseDTO;
	}

}
