package com.dio.arley.santander.bankline.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dio.arley.santander.bankline.api.dto.NovoCorrentista;
import com.dio.arley.santander.bankline.api.model.Correntista;
import com.dio.arley.santander.bankline.api.repository.CorrentistaRepository;
import com.dio.arley.santander.bankline.api.services.CorrentistaService;

@RestController
@RequestMapping("/correntistas")
public class CorrentistaController {
	
	@Autowired
	private CorrentistaRepository repository;
	
	@Autowired
	private CorrentistaService service;
	
	@GetMapping
	public List<Correntista> findAll(){
		
		return repository.findAll();
		
	}
	
	@PostMapping
	public void saveNovoCorrentista(@RequestBody NovoCorrentista c) {
		service.saveNovoCorrentista(c);
	}
}
