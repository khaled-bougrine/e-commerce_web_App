package com.example.demo.model;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity 
public class IdAndLength {
	@Id
	@GeneratedValue
	private Integer id ;
	
	private Integer idModel;
	private Integer length;
	private String composant;
	private Integer nbserie;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
	public Integer getIdModel() {
		return idModel;
	}
	public void setIdModel(Integer idModel) {
		this.idModel = idModel;
	}

	@Override
	public String toString() {
		return "IdAndLength [id=" + id + ", idModel=" + idModel + ", length=" + length + ", composant=" + composant
				+ "]";
	}
	public String getComposant() {
		return composant;
	}
	public void setComposant(String composant) {
		this.composant = composant;
	}
	public Integer getNbserie() {
		return nbserie;
	}
	public void setNbserie(Integer nbserie) {
		this.nbserie = nbserie;
	}
	

}
