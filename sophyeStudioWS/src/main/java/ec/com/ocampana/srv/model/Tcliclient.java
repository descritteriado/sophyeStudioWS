package main.java.ec.com.ocampana.srv.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tcliclient database table.
 * 
 */
@Entity
@NamedQuery(name="Tcliclient.findAll", query="SELECT t FROM Tcliclient t")
public class Tcliclient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String address;

	@Temporal(TemporalType.DATE)
	private Date birthday;

	private Boolean deleted;

	private String document;

	private String email;

	private String lastnames;

	private String names;

	private String neighbourhood;

	private String phone1;

	private String phone2;

	private Boolean status;

	//uni-directional many-to-one association to Tsegcanton
	@ManyToOne
	@JoinColumn(name="canton")
	private Tsegcanton canton;

	//uni-directional many-to-one association to Tsegcataloguedetail
	@ManyToOne
	@JoinColumn(name="documenttype")
	private Tsegcataloguedetail documentType;

	//uni-directional many-to-one association to Tsegparroquia
	@ManyToOne
	@JoinColumn(name="parroquia")
	private Tsegparroquia parroquia;

	//uni-directional many-to-one association to Tsegprovince
	@ManyToOne
	@JoinColumn(name="province")
	private Tsegprovince province;

	public Tcliclient() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Boolean getDeleted() {
		return this.deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public String getDocument() {
		return this.document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLastnames() {
		return this.lastnames;
	}

	public void setLastnames(String lastnames) {
		this.lastnames = lastnames;
	}

	public String getNames() {
		return this.names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getNeighbourhood() {
		return this.neighbourhood;
	}

	public void setNeighbourhood(String neighbourhood) {
		this.neighbourhood = neighbourhood;
	}

	public String getPhone1() {
		return this.phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return this.phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Tsegcanton getCanton() {
		return this.canton;
	}

	public void setCanton(Tsegcanton canton) {
		this.canton = canton;
	}

	public Tsegcataloguedetail getDocumentType() {
		return this.documentType;
	}

	public void setDocumentType(Tsegcataloguedetail documentType) {
		this.documentType = documentType;
	}

	public Tsegparroquia getParroquia() {
		return this.parroquia;
	}

	public void setParroquia(Tsegparroquia parroquia) {
		this.parroquia = parroquia;
	}

	public Tsegprovince getProvince() {
		return this.province;
	}

	public void setProvince(Tsegprovince province) {
		this.province = province;
	}

}