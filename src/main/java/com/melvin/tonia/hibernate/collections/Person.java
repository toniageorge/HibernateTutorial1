package com.melvin.tonia.hibernate.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
@Entity
public class Person {
	@Id
	@Column(name = "Person_Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int person_id;
	@Column(name = "Person_Name")
	private String personName;
	@ElementCollection
	@JoinTable(name = "PERSON_ADDRESS", joinColumns =@JoinColumn(name="PERSON_ID"))
	@GenericGenerator(name = "hilo-gen", strategy = "hilo")
	@CollectionId(columns = { @Column(name="Address_Id") }, generator = "hilo-gen", type = @Type(type="int"))
	private Collection<AddressDetails> listOfAddress = new ArrayList<AddressDetails>();
	
	public Collection<AddressDetails> getListOfAddress() {
		return listOfAddress;
	}

	public void setListOfAddress(Collection<AddressDetails> listOfAddress) {
		this.listOfAddress = listOfAddress;
	}
	/*@ElementCollection
	@JoinTable(name = "PERSON_ADDRESS", joinColumns =@JoinColumn(name="PERSON_ID"))
	private Set<AddressDetails> listOfAddress = new HashSet<AddressDetails>();
	
	public Set<AddressDetails> getListOfAddress() {
		return listOfAddress;
	}

	public void setListOfAddress(Set<AddressDetails> listOfAddress) {
		this.listOfAddress = listOfAddress;
	}*/

	public int getPerson_id() {
		return person_id;
	}

	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}
}
