package main.java.ec.com.ocampana.srv.model;

import java.io.Serializable;
import javax.persistence.*;

import main.java.ec.com.ocampana.srv.utils.UtilsX;

import java.util.Date;


/**
 * The persistent class for the tseguser database table.
 * 
 */
@Entity
@NamedQuery(name="Tseguser.findAll", query="SELECT t FROM Tseguser t")
public class Tseguser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private Boolean deleted;

	@Temporal(TemporalType.DATE)
	private Date expirationdate;

	private Boolean istemporal;

	@Temporal(TemporalType.DATE)
	private Date lockdate;

	private byte[] password;

	private Boolean status;

	private String username;
	
	@Transient
	private String keyInCourse;

	//uni-directional many-to-one association to Tempemployment
	@ManyToOne
	@JoinColumn(name="idemployment")
	private Tempemployment employment;

	public Tseguser() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getDeleted() {
		return this.deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public Date getExpirationdate() {
		return this.expirationdate;
	}

	public void setExpirationdate(Date expirationdate) {
		this.expirationdate = expirationdate;
	}

	public Boolean getIstemporal() {
		return this.istemporal;
	}

	public void setIstemporal(Boolean istemporal) {
		this.istemporal = istemporal;
	}

	public Date getLockdate() {
		return this.lockdate;
	}

	public void setLockdate(Date lockdate) {
		this.lockdate = lockdate;
	}

	public byte[] getPassword() {
		return this.password;
	}

	public void setPassword(byte[] password) {
		this.password = password;
	}

	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Tempemployment getEmployment() {
		return this.employment;
	}

	public void setEmployment(Tempemployment employment) {
		this.employment = employment;
	}

	public String getKeyInCourse() {
		String val="";
		
		try {
			val = UtilsX.descifra(this.getPassword());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return val;
	}

	public void setKeyInCourse(String keyInCourse) {
		
		this.keyInCourse = keyInCourse;
		try {
			this.setPassword(UtilsX.cifra(keyInCourse));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}