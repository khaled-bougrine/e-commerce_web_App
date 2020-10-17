package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Accesoire;
import com.example.demo.model.Tissus;


@Repository
public interface RepoTissus  extends JpaRepository<Tissus,Integer> {

	List<Tissus> findBynbserie(String nbserie);

	List<Accesoire> findByfabric(String type);
	


}
