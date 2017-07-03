package com.ws;

import javax.xml.bind.annotation.XmlElement;

public class Table {

	private String country;

	private String city;

	public String getCountry() {
		return country;
	}

	@XmlElement(name = "Country")
	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	@XmlElement(name = "City")
	public void setCity(String city) {
		this.city = city;
	}
}
