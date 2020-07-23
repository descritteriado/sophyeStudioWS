package main.java.ec.com.ocampana.srv.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tsegtransaction database table.
 * 
 */
@Entity
@NamedQuery(name="Tsegtransaction.findAll", query="SELECT t FROM Tsegtransaction t")
public class Tsegtransaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String coment;

	private String description;

	private Integer orderval;

	private String url;

	//uni-directional many-to-one association to Tsegmodule
	@ManyToOne
	@JoinColumn(name="idmodule")
	private Tsegmodule tsegmodule;

	public Tsegtransaction() {
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

	public Integer getOrderval() {
		return this.orderval;
	}

	public void setOrderval(Integer orderval) {
		this.orderval = orderval;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Tsegmodule getTsegmodule() {
		return this.tsegmodule;
	}

	public void setTsegmodule(Tsegmodule tsegmodule) {
		this.tsegmodule = tsegmodule;
	}

}