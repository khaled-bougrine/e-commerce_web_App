package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Accesoire;


@Repository
public interface RepoAccesoire  extends JpaRepository<Accesoire,Integer> {

	List<Accesoire> findBytype(String type);

	List<Accesoire> findBynbserie(String nbserie);
	
	
	

}
