package com.inti.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Table
@Data

public class ChefO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numChef;
	private String nomChef;
	private String prenomChef;
	private LocalDate dateNaissanceChef;
	private String nationalite;
	private double cachetDemande;
	private String commentaires;
	
	@OneToMany(mappedBy = "chefo", targetEntity = Oeuvre.class)
	List<Oeuvre> listeOeuvres;

	public ChefO(String nomChef, String prenomChef, LocalDate dateNaissanceChef, String nationalite,
			double cachetDemande, String commentaires, List<Oeuvre> listeOeuvres) {
		super();
		this.nomChef = nomChef;
		this.prenomChef = prenomChef;
		this.dateNaissanceChef = dateNaissanceChef;
		this.nationalite = nationalite;
		this.cachetDemande = cachetDemande;
		this.commentaires = commentaires;
		this.listeOeuvres = listeOeuvres;
	}
	
	

}
