package com.example.demo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ImageModel;

@Repository
public interface RepoImage extends JpaRepository<ImageModel,Long >{

	Optional<ImageModel> findByName(String imageName);
	ImageModel findById(String imageName);
	void deleteByname(String name);
	
	
}
