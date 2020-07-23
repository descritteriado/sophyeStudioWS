package main.java.ec.com.ocampana.srv.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tsegprofile database table.
 * 
 */
@Entity
@NamedQuery(name="Tsegprofile.findAll", query="SELECT t FROM Tsegprofile t")
public class Tsegprofile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String coment;

	private String description;

	public Tsegprofile() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getComent() {
		return this.coment;
	}

	public void setComent(String coment) {
		this.coment = coment;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}