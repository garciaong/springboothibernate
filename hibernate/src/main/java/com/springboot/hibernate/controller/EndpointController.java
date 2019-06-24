package com.springboot.hibernate.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.hibernate.model.Response;
import com.springboot.hibernate.service.ClubService;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class EndpointController {

	@Autowired
	private ClubService clubSerivce;
	
	@GetMapping(value="/all", produces = "application/json")
	public ResponseEntity<Response> all(@RequestParam("sortby") String sortBy, @RequestParam("direction") String direction){
		try {
			log.info("Invoking '/all?sortby="+sortBy+"&direction="+direction+"' endpoint");
			Response response = new Response();
			response.setClubs(clubSerivce.getAllClub(sortBy,direction));
			response.setMessage("Club Result");
			
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		} catch (Exception e) {
	        e.printStackTrace();
	        return new ResponseEntity<Response>(new Response("Endpoint invocation failed! Error : ["+e+"]"), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@GetMapping(value="/club/{id}", produces = "application/json")
	public ResponseEntity<Response> clubById(@PathVariable("id") String id){
		try {
			log.info("Invoking '/club/"+id+"' endpoint");
			Response response = new Response();
			response.setClub(clubSerivce.getClubById(id));
			response.setMessage("Club Result");
			
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		} catch (Exception e) {
	        e.printStackTrace();
	        return new ResponseEntity<Response>(new Response("Endpoint invocation failed! Error : ["+e+"]"), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@GetMapping(value="/club", produces = "application/json")
	public ResponseEntity<Response> club(@PathParam("name") String name){
		try {
			log.info("Invoking '/club?name="+name+"' endpoint");
			Response response = new Response();
			response.setClub(clubSerivce.getClub(name));
			response.setMessage("Club Result");
			
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		} catch (Exception e) {
	        e.printStackTrace();
	        return new ResponseEntity<Response>(new Response("Endpoint invocation failed! Error : ["+e+"]"), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@GetMapping(value="/club-n-player", produces = "application/json")
	public ResponseEntity<Response> clubAndPlayer(@PathParam("name") String name){
		try {
			log.info("Invoking '/club?name="+name+"' endpoint");
			Response response = new Response();
			response.setClub(clubSerivce.getClubAndPlayer(name));
			response.setMessage("Club Result");
			
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		} catch (Exception e) {
	        e.printStackTrace();
	        return new ResponseEntity<Response>(new Response("Endpoint invocation failed! Error : ["+e+"]"), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
}
