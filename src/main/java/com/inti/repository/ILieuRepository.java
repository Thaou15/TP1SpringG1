package com.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.model.Lieu;

@Repository
public interface ILieuRepository extends JpaRepository<Lieu, Integer> {

}
