package main.java.ec.com.ocampana.srv.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tsegparroquia database table.
 * 
 */
@Entity
@NamedQuery(name="Tsegparroquia.findAll", query="SELECT t FROM Tsegparroquia t")
public class Tsegparroquia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String name;

	//uni-directional many-to-one association to Tsegcanton
	@ManyToOne
	@JoinColumn(name="idcanton")
	private Tsegcanton canton;

	public Tsegparroquia() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Tsegcanton getCanton() {
		return this.canton;
	}

	public void setCanton(Tsegcanton canton) {
		this.canton = canton;
	}

}