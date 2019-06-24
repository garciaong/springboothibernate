package com.springboot.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.hibernate.entity.Player;

@Repository("playerRepository")
public interface PlayerRepository extends JpaRepository<Player, Integer>{

	@Query("FROM ClubPlayer WHERE name = ?1")
    public Player findByName(String name);
	
}
