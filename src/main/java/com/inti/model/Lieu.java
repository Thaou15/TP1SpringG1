package com.inti.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data @NoArgsConstructor
public class Lieu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String adresse;
	private int nbFauteuils;
	
	@OneToMany(mappedBy = "lieu")
	private List<Concert> listConcerts;

	public Lieu(String nom, String adresse, int nbFauteuils) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.nbFauteuils = nbFauteuils;
	}
	
	
}
