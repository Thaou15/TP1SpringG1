package com.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inti.model.Concert;

@Repository
public interface IConcertRepository extends JpaRepository<Concert, Integer> {

	@Query(value = "select * from concert where id=:id", nativeQuery = true)
	public Concert trouverConcert(@Param("id") int id);
}
