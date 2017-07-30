package com.melvin.tonia.hibernate.oneToMany;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Country {
	@Id	@GeneratedValue
	private int CountryId;
	private String CountryName;

	@OneToMany(mappedBy="country")
	//@JoinTable(joinColumns=@JoinColumn(name="Country_Id"), inverseJoinColumns = @JoinColumn(name="State_Id"))
	private Collection<State> state = new HashSet<State>();
	

	public Collection<State> getState() {
		return state;
	}

	public void setState(Collection<State> state) {
		this.state = state;
	}

	public int getCountryId() {
		return CountryId;
	}

	public void setCountryId(int countryId) {
		CountryId = countryId;
	}

	public String getCountryName() {
		return CountryName;
	}

	public void setCountryName(String countryName) {
		CountryName = countryName;
	}
	
	

}
