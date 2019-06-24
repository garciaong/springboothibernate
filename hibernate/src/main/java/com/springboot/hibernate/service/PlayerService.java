package com.springboot.hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.hibernate.entity.Player;
import com.springboot.hibernate.repository.PlayerRepository;

@Service
public class PlayerService {

	@Autowired
	private PlayerRepository repo;
	
	public Player getPlayerByName(String name) {
		return repo.findByName(name);
	}
	
	
}
