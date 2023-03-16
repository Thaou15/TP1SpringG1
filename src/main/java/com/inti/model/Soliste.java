package com.inti.model;

import java.time.LocalDate;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "Soliste")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Soliste {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="nom")
	private String nomS;
	@Column(name="prenom")
	private String prenomS;
	@Column(name="dateNaissance")
	private LocalDate dateNaissance;
	@Column(name="nationalite")
	private String nationalite;
	
	@ManyToOne
    @JoinColumn(name="idO")
    private Oeuvre oeuvre;

	public Soliste(String nomS, String prenomS, LocalDate dateNaissance, String nationalite) {
		super();
		this.nomS = nomS;
		this.prenomS = prenomS;
		this.dateNaissance = dateNaissance;
		this.nationalite = nationalite;
	}
	
	
}
