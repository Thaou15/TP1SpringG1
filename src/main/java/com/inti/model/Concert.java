package com.inti.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
;

@Entity
@Table
@Data @NoArgsConstructor
public class Concert {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private LocalDate date;
	
	@OneToMany(mappedBy = "concert")
	List<Oeuvre> listOeuvres;
	
	@ManyToOne
	@JoinColumn(name = "idlieu")
	private Lieu lieu;

	public Concert(String nom, LocalDate date) {
		super();
		this.nom = nom;
		this.date = date;
	}
	
	
}
