package com.example.demo.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Model {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id ;
	@Column(name = "name")
	private  String name;
	@Column(name = "colore")
	private String colore;
	@Column(name = "pourquoi")
	private String pourquoi;
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
	@Column(name = "modele")
	private String modele;
	private ArrayList<String>   images;
	   

	
	
	private  ArrayList<Integer> length;
	
	@OneToMany(targetEntity = IdAndLength.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="cp_fk",referencedColumnName = "id")
	private  List<IdAndLength> composants;

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public Model() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getPourquoi() {
		return pourquoi;
	}

	public void setPourquoi(String pourquoi) {
		this.pourquoi = pourquoi;
	}

	@Override
	public String toString() {
		return "Model [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", isnew="
				+ isnew + ", isbestprice=" + isbestsell + ", solde=" + solde + ", composants=" + composants
				+ ", images=" + images + "colore:" + colore +modele+pourquoi+"]";
	}

	public boolean isIsnew() {
		return isnew;
	}



	public Integer getSolde() {
		return solde;
	}

	public List<IdAndLength>  getComposants() {
		return composants;
	}

	public List<String>  getImages() {
		return images;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public Model(Integer id, String name, String description, double d, boolean isnew, boolean isbestprice,
			Integer solde, ArrayList<IdAndLength>  composants, ArrayList<String>  images) {
		super();
		this.id = id;
		this.name = name;
		this.description= description;
		this.price = d;
		this.isnew = isnew;
		this.isbestsell = isbestprice;
		this.solde = solde;
		this.composants = composants;
		this.images = images;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPrice(Long price) {
		this.price = price;
	}



	public void setSolde(Integer solde) {
		this.solde = solde;
	}

	public void setComposants(List<IdAndLength>  composants) {
		this.composants = composants;
	}

	public void setImages(ArrayList<String> images) {
		this.images = images;
	}



	public boolean isIsbestsell() {
		return isbestsell;
	}

	public void setIsbestsell(boolean isbestsell) {
		this.isbestsell = isbestsell;
	}

	public String getColore() {
		return colore;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}

	public String getModle() {
		return modele;
	}

	public void setModle(String modle) {
		this.modele = modle;
	}

	public List<Integer> getLength() {
		return length;
	}

	public void setLength(ArrayList<Integer> length) {
		this.length = length;
	}
	

	
	

}
