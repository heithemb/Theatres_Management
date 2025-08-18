package com.example.demo.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Spectacle;

public interface SpectacleRepository extends JpaRepository<Spectacle, Long> {
	@Query("SELECT s FROM Spectacle s WHERE FUNCTION('DATE', s.temps) = :specificDate ORDER BY s.temps")
    List<Spectacle> findSpectaclesByDate(@Param("specificDate") LocalDate specificDate);
	@Query("SELECT s FROM Spectacle s WHERE s.createur=?1")
	List<Spectacle> findSpectaclesByCreator(String c);
	@Query("select s from Spectacle s where  s.theatre.id=?1")
	List<Spectacle> findByIdTheatre(Long idT);
	@Query("select s from Spectacle s where  s.nom=?1")
	List<Spectacle> findByName(String name);

}
