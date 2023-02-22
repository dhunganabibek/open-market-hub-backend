package com.openmarkethub.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDTO {

	private Integer id;
	
	private String name;

	private String email;

	private String password;

	private String about;
}
