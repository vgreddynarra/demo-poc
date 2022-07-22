package com.sanelahealth.poc.entity;

import javax.persistence.Entity;
import javax.persistence.Id;


import lombok.Data;

@Entity
@Data
public class MovieCatalog {

	@Id
	String id;
	String movieName;

}
