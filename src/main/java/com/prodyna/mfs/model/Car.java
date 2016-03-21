/**
 * 
 */
package com.prodyna.mfs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Peter Kurzok
 *
 */
@Entity
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;

	private String make;
	private String model;
	private String color;
	private int year;
	private int horsePower;

	@JsonIgnore
	@ManyToOne
	private Vendor vendor;

	public Car(String make, String model, String color, int year, int horsePower, Vendor vendor) {
		super();
		this.make = make;
		this.model = model;
		this.color = color;
		this.year = year;
		this.horsePower = horsePower;
		this.vendor = vendor;
	}

	public Car() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getHorsePower() {
		return horsePower;
	}

	public void setHorsePower(int horsePower) {
		this.horsePower = horsePower;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

}
