package main.java.ec.com.ocampana.srv.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tsegcatalogue database table.
 * 
 */
@Entity
@NamedQuery(name="Tsegcatalogue.findAll", query="SELECT t FROM Tsegcatalogue t")
public class Tsegcatalogue implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String description;

	private String name;

	private String value;

	public Tsegcatalogue() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}