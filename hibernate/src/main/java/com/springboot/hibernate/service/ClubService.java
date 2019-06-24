package com.springboot.hibernate.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springboot.hibernate.enums.SortUtil;
import com.springboot.hibernate.model.Club;
import com.springboot.hibernate.model.Player;
import com.springboot.hibernate.repository.ClubRepository;

@Service
public class ClubService {

	@Autowired
	private ClubRepository repo;
	
	public List<Club> getAllClub(String sortBy, String direction) {
		List<Club> result = new ArrayList<Club>();
		Club clubModel = null;
		Sort sort = new Sort(SortUtil.getDirection(direction), sortBy);
		List<com.springboot.hibernate.entity.Club> clubs = repo.findAllClub(sort);
		
		for(com.springboot.hibernate.entity.Club club:clubs) {
			clubModel = new Club();
			clubModel.setName(club.getName());
			result.add(clubModel);
		}
		
		return result;
	}
	
	public Club getClubById(String id) {
		Club clubModel = null;
		Optional<com.springboot.hibernate.entity.Club> result = repo.findById(Integer.parseInt(id));
		if(result.isPresent()) {
			clubModel = new Club();
			com.springboot.hibernate.entity.Club club = repo.findById(Integer.parseInt(id)).get();
			clubModel.setName(club.getName());
		}
		return clubModel;
	}
	
	public Club getClub(String name) {
		Club clubModel = new Club();
		com.springboot.hibernate.entity.Club club = repo.findByClubName(name);
		
		clubModel.setName(club.getName());
		
		return clubModel;
	}
	
	public Club getClubAndPlayer(String name) {
		Club clubModel = new Club();
		List<Player> players = new ArrayList<Player>();
		Player playerModel = null;
		
		com.springboot.hibernate.entity.Club club = repo.findByClubName(name);
		
		for(com.springboot.hibernate.entity.Player player:club.getPlayers()) {
			playerModel = new Player();
			playerModel.setName(player.getName());
			playerModel.setPosition(player.getPosition());
			players.add(playerModel);
		}
		clubModel.setName(club.getName());
		clubModel.setPlayers(players);
		return clubModel;
	}
	
}
