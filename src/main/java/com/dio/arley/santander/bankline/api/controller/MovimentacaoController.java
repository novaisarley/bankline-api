package com.dio.arley.santander.bankline.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dio.arley.santander.bankline.api.dto.NovaMovimentacao;
import com.dio.arley.santander.bankline.api.model.Movimentacao;
import com.dio.arley.santander.bankline.api.repository.MovimentacaoRepository;

import com.dio.arley.santander.bankline.api.services.MovimentacaoService;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {
	
	@Autowired
	private MovimentacaoRepository repository;
	
	@Autowired
	private MovimentacaoService service;
	
	@GetMapping
	public List<Movimentacao> findAll(){
		
		return repository.findAll();
		
	}
	
	@PostMapping
	public void saveNovaMovimentacao(@RequestBody NovaMovimentacao nm) {
		service.saveNovaMovimentacao(nm);
	}
}
