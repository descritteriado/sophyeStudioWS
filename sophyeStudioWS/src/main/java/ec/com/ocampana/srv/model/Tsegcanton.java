package main.java.ec.com.ocampana.srv.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tsegcanton database table.
 * 
 */
@Entity
@NamedQuery(name="Tsegcanton.findAll", query="SELECT t FROM Tsegcanton t")
public class Tsegcanton implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String name;

	//uni-directional many-to-one association to Tsegprovince
	@ManyToOne
	@JoinColumn(name="idprovince")
	private Tsegprovince province;

	public Tsegcanton() {
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

	public Tsegprovince getProvince() {
		return this.province;
	}

	public void setProvince(Tsegprovince province) {
		this.province = province;
	}

}