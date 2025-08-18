package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Theatre;

import jakarta.transaction.Transactional;

public interface TheatreRepository extends JpaRepository<Theatre, Long> {
@Query("select o from Theatre o where o.nom = ?1")
List<Theatre> findByName(String name);
@Query("select o from Theatre o where  o.address= ?1 ")
List<Theatre> findByAddress(String address);
@Transactional
@Modifying
@Query("delete from Theatre o where o.nom = ?1 and o.address= ?2")
void deleteNameAndAddress(String name, String address);
@Query("select o from Theatre o where  o.nom= ?1 and o.address=?2")
List<Theatre> findByNameAndAddress(String name, String address);

}
