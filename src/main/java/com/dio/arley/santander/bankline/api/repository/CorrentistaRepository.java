package com.dio.arley.santander.bankline.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dio.arley.santander.bankline.api.model.Correntista;

@Repository
public interface CorrentistaRepository extends JpaRepository<Correntista, Integer>{

}
