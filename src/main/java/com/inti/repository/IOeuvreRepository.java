package com.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.model.Oeuvre;

@Repository
public interface IOeuvreRepository extends JpaRepository<Oeuvre, Integer> {

}
