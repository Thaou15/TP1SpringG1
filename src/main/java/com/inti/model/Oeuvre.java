package com.inti.model;

import java.util.List; 

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.OneToMany;

import jakarta.persistence.ManyToOne;


import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Oeuvre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private int duree;
	
	@ManyToOne
	@JoinColumn(name="idChefO")
	private ChefO chefo;

	@OneToMany(mappedBy = "oeuvre" ,targetEntity = Soliste.class)
    
    private List<Soliste> listeSoliste;
	
	
}
