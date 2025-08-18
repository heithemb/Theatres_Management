package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Reservation;

import jakarta.transaction.Transactional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long>{
	@Query("SELECT s FROM Reservation s WHERE s.client=?1")
	List<Reservation> findByClient(String client);
	@Query("SELECT s FROM Reservation s WHERE s.spectacle.id=?1")
	List<Reservation> findBySpectacle(Long idS);
	@Transactional
	@Modifying
	@Query("delete from Reservation o where o.id = ?1 and o.client= ?2")
	void deleteByIdAndClient(Long id, String client);

}
