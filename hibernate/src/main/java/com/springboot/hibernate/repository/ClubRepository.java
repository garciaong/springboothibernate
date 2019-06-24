package com.springboot.hibernate.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.hibernate.entity.Club;

@Repository("clubRepository")
public interface ClubRepository  extends JpaRepository<Club, Integer>{

	@Query("FROM Club")
    public List<Club> findAllClub(Sort sort);
	
	@Query("FROM Club WHERE name = ?1")
    public Club findByClubName(String name);
	
}
