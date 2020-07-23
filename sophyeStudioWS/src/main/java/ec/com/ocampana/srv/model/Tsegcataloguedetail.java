package main.java.ec.com.ocampana.srv.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tsegcataloguedetail database table.
 * 
 */
@Entity
@NamedQuery(name="Tsegcataloguedetail.findAll", query="SELECT t FROM Tsegcataloguedetail t")
public class Tsegcataloguedetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String description;

	private String name;

	private String value;

	//uni-directional many-to-one association to Tsegcatalogue
	@ManyToOne
	@JoinColumn(name="idcatalogue")
	private Tsegcatalogue tsegcatalogue;

	public Tsegcataloguedetail() {
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

	public Tsegcatalogue getTsegcatalogue() {
		return this.tsegcatalogue;
	}

	public void setTsegcatalogue(Tsegcatalogue tsegcatalogue) {
		this.tsegcatalogue = tsegcatalogue;
	}

}