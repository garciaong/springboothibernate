package com.springboot.hibernate.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Club {

//	@JsonIgnore
	@JsonProperty(value = "club-name")
	private String name;
	@JsonProperty(value = "club-player")
	@JsonInclude(Include.NON_NULL)
	private List<Player> players;
	
}
