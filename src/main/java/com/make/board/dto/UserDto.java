package com.make.board.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
	
	@NotNull
	@Size(min = 3, max = 50)
	private String username;
	
	@NotNull
	@Size(min = 8, max = 50)
	private String email;
	
	@NotNull
	@Size(min = 8, max = 50)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;

}
