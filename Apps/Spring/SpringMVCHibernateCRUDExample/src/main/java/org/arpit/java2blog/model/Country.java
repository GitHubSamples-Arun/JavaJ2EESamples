package org.arpit.java2blog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/*
 * This is our model class and it corresponds to Country table in database
 */
@Entity
@Table(name="COUNTRY")
public class Country{
	
	@Id
	@Column(name="id")
/*	@GenericGenerator(name="sequence",strategy="sequence", parameters={
			@org.hibernate.annotations.Parameter(name="sequenceName",value="country_seq"),
			@org.hibernate.annotations.Parameter(name="allocationSize",value="1")
			}
			 )*/
	//@GeneratedValue(generator="sequence", strategy=GenerationType.SEQUENCE)
	//@GeneratedValue
	int id;
	
	@Column(name="countryName")
	String countryName;	
	
	@Column(name="population")
	long population;
	
	public Country() {
		super();
	}
	public Country(int i, String countryName,long population) {
		super();
		this.id = i;
		this.countryName = countryName;
		this.population=population;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public long getPopulation() {
		return population;
	}
	public void setPopulation(long population) {
		this.population = population;
	}	
	
}