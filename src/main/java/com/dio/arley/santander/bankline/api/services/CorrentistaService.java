package com.dio.arley.santander.bankline.api.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.arley.santander.bankline.api.dto.NovoCorrentista;
import com.dio.arley.santander.bankline.api.model.Conta;
import com.dio.arley.santander.bankline.api.model.Correntista;
import com.dio.arley.santander.bankline.api.repository.CorrentistaRepository;

@Service
public class CorrentistaService {
	@Autowired
	private CorrentistaRepository repository;
	
	public void saveNovoCorrentista(NovoCorrentista novoCorrentista) {
		Correntista c = new Correntista();
		c.setNome(novoCorrentista.getNome());
		c.setCpf(novoCorrentista.getCpf());
		
		Conta conta = new Conta();
		conta.setSaldo(0.0);
		conta.setNumero(new Date().getTime());
		
		c.setConta(conta);
		
		repository.save(c);
		
		
	}
}
