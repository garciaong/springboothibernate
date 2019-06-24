package com.springboot.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.hibernate.entity.Club;
import com.springboot.hibernate.entity.Player;
import com.springboot.hibernate.repository.ClubRepository;
import com.springboot.hibernate.repository.PlayerRepository;

import lombok.extern.log4j.Log4j2;

@SpringBootApplication
@Log4j2
public class HibernateApplication implements CommandLineRunner{
	
	@Autowired
	private ClubRepository clubRepo;
	
	@Autowired
	private PlayerRepository playerRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(HibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Running this before Springboot run method completes...");
		List<Player> players = new ArrayList<Player>();
		
		Club ars = new Club();
		ars.setName("Arsenal FC");
		
		Player auba = new Player();
		auba.setName("Aubameyang");
		auba.setPosition("Forward");
		auba.setClub(ars);
		players.add(auba);
		Player laca = new Player();
		laca.setName("Lacazette");
		laca.setPosition("Forward");
		laca.setClub(ars);
		players.add(laca);
		Player ozil = new Player();
		ozil.setName("Ozil");
		ozil.setPosition("Midfield");
		ozil.setClub(ars);
		players.add(ozil);
		
		ars.setPlayers(players);
		
		clubRepo.saveAndFlush(ars);
		
		players = new ArrayList<Player>();
		
		Club man = new Club();
		man.setName("Manchester United");
		
		Player rashford = new Player();
		rashford.setName("Rashford");
		rashford.setPosition("Forward");
		rashford.setClub(man);
		players.add(rashford);
		Player martial = new Player();
		martial.setName("Lacazette");
		martial.setPosition("Forward");
		martial.setClub(man);
		players.add(martial);
		Player pogba = new Player();
		pogba.setName("Ozil");
		pogba.setPosition("Midfield");
		pogba.setClub(man);
		players.add(pogba);
		
		man.setPlayers(players);
		
		clubRepo.saveAndFlush(man);
		
		for(Player player:players) {
			playerRepo.saveAndFlush(player);
		}
	}
	
}
