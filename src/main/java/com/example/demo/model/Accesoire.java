package com.example.demo.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Accesoire {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id ;
	@Column(name = "name")
	private  String name;
	@Column(name = "type")
	private  String type;

	@Column(name = "nbserie")
	private  String nbserie;
	

	@Column(name = "colore")
	private String colore;
	@Column(name = "price")
	private double price;
	@Column(name = "isnew")
	private boolean isnew;
	@Column(name = "isbestsell")
	private boolean isbestsell;
	@Column(name = "solde")
	private Integer solde;
	@Column(name = "description")
	private String description;

	
	private ArrayList<String>   images;
	private  ArrayList<Integer>  idModels ;
	private String fournisseur;
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String getNbserie() {
		return nbserie;
	}
	public void setNbserie(String nbserie) {
		this.nbserie = nbserie;
	}
	
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getColore() {
		return colore;
	}
	public double getPrice() {
		return price;
	}
	public boolean isIsnew() {
		return isnew;
	}
	public boolean isIsbestsell() {
		return isbestsell;
	}
	public Integer getSolde() {
		return solde;
	}
	public String getDescription() {
		return description;
	}

	public ArrayList<String> getImages() {
		return images;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setColore(String colore) {
		this.colore = colore;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setIsnew(boolean isnew) {
		this.isnew = isnew;
	}
	public void setIsbestsell(boolean isbestsell) {
		this.isbestsell = isbestsell;
	}
	public void setSolde(Integer solde) {
		this.solde = solde;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public void setImages(ArrayList<String> images) {
		this.images = images;
	}

	@Override
	public String toString() {
		return "Accesoire [id=" + id + ", name=" + name + ", type=" + type + ", nbserie=" + nbserie + ", colore="
				+ colore + ", price=" + price + ", isnew=" + isnew + ", isbestsell=" + isbestsell + ", solde=" + solde
				+ ", description=" + description + ", images=" + images + ", idModels=" + idModels + ", fournisseur="
				+ fournisseur + "]";
	}
	public ArrayList<Integer> getIdModels() {
		return idModels;
	}
	public void setIdModels(ArrayList<Integer> idModels) {
		this.idModels = idModels;
	}
	public String getFournisseur() {
		return fournisseur;
	}
	public void setFournisseur(String fournisseur) {
		this.fournisseur = fournisseur;
	}
	

}
