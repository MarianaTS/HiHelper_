package ua.com.hihelper.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Location {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String country;
	private String city;
	private String street;
	private String building;
	@OneToMany(mappedBy="location")
	private List<Work> works=new ArrayList<>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getBuilding() {
		return building;
	}
	public void setBuilding(String building) {
		this.building = building;
	}
	public List<Work> getWorks() {
		return works;
	}
	public void setWorks(List<Work> works) {
		this.works = works;
	}
	public Location(String country, String city, String street, String building) {
		super();
		this.country = country;
		this.city = city;
		this.street = street;
		this.building = building;
	}
	public Location() {
	
	}
	
	
}
