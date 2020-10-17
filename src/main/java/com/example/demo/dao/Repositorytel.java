package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Model;

@org.springframework.stereotype.Repository
public interface Repositorytel extends JpaRepository<Model,Integer> {
	
	@Query("SELECT id FROM Model")
	List<Integer> getallId();

	List<Model> findBypourquoi(String pourquoi);
	Model findByid( Integer id);
	
	

}
