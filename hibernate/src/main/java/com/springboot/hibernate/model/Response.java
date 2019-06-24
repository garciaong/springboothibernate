package com.springboot.hibernate.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
public class Response {

	private String message;
	@JsonProperty(value = "club")
	@JsonInclude(Include.NON_NULL)
	private Club club;
	@JsonProperty(value = "clubs")
	@JsonInclude(Include.NON_NULL)
	private List<Club> clubs;
	
	public Response() {}
	public Response(String message) {
		this.message = message;
	}
}
