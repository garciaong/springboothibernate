package com.springboot.hibernate.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Player {

	@JsonProperty(value = "player-name")
	private String name;
	@JsonProperty(value = "playing-position")
	private String position;
	
}
