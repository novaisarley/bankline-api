package com.dio.arley.santander.bankline.api.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.arley.santander.bankline.api.dto.NovaMovimentacao;
import com.dio.arley.santander.bankline.api.model.Correntista;
import com.dio.arley.santander.bankline.api.model.Movimentacao;
import com.dio.arley.santander.bankline.api.model.MovimentacaoTipo;
import com.dio.arley.santander.bankline.api.repository.CorrentistaRepository;
import com.dio.arley.santander.bankline.api.repository.MovimentacaoRepository;

@Service
public class MovimentacaoService {
	
	@Autowired
	MovimentacaoRepository repositoryM;
	
	@Autowired
	CorrentistaRepository repositoryC;
	
	public void saveNovaMovimentacao(NovaMovimentacao nm) {
		Movimentacao movimentacao = new Movimentacao();
		
		Double valor = nm.getTipo() == MovimentacaoTipo.RECEITA ? nm.getValor() : nm.getValor() * -1;
		
		movimentacao.setDataHora(LocalDateTime.now());
		movimentacao.setDescricao(nm.getDescricao());
		movimentacao.setValor(valor);
		movimentacao.setIdConta(nm.getIdConta());
		movimentacao.setTipo(nm.getTipo());
		
		Correntista c = repositoryC.findById(nm.getIdConta()).orElse(null);
		if(c != null) {
			c.getConta().setSaldo(valor + c.getConta().getSaldo());
			repositoryC.save(c);
		}
		
		repositoryM.save(movimentacao);
	}
}
