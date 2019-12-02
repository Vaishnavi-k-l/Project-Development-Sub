package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "user")
@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User 
{
	@Id
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	
	
}
