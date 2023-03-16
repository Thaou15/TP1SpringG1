package com.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.model.Soliste;


@Repository
public interface ISolisteRepository extends JpaRepository<Soliste, Integer> {

}
