package br.com.utils;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private int id;
	private List<String> roles;
	

	
	
	public JwtResponse(String accessToken, int id,  List<String> roles) {
		this.token = accessToken;
		this.id = id;
		this.roles = roles;

	}
}
