package web;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Calendar;
import javax.persistence.*;
import java.io.Serializable;

import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.IndexColumn;

@Entity
@Table(name="CONTACT")
@NamedQueries({
	@NamedQuery(name="dump", query="from Contact as contact where fname.length() > 0 and lname.length() > 0"),
	@NamedQuery(name="filterByFname", query="from Contact as contact where fname = :fname")
	})

public class Contact  {
	@Id
	@Column(name="CONTACT_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Enumerated(EnumType.STRING)
	private Salutation salutation;

	@Column(nullable=false)
	private String fname;

	@Column(nullable=false)
	private String lname;

	private String street;
	private String city;
	private String state;  //have the setter check for format, etc.
	private String postalCode;  //have the setter check for format, etc.
	private String region;
	private String country;
	private String companyName;
	private String title;
	private String workPhone;
	private String workExt;
	private String cellPhone;
	private String homePhone;
	private String faxNbr;
	private String email;

	@Temporal(TemporalType.DATE)
	private Date lastMeetingDt;

	@Enumerated(EnumType.STRING)
	private ContactCategory contactCategory;

	private String referredBy;

	@Lob
	private String notes;

	private Integer importance; // must be 1-5

	@Temporal(TemporalType.DATE)  // bug with @javax.persistence.Temporal in regards to TIMESTAMP
	private Date lastUpdated;

	private String relationship;

	// set the 1-m relationship to the encounters
	@OneToMany(cascade=CascadeType.ALL)
//	@IndexColumn(name="TRANSACT_DT")
	@JoinColumn(name="CONTACT_ID", nullable=false)
	private List<Encounter> encounters;

	private Calendar cal = Calendar.getInstance();

	public Contact() {}

	public Contact(String fname, String lname) {
		this.fname = fname;
		this.lname = lname;
		this.lastUpdated = cal.getTime();
	}

	public Contact(Salutation salutation, String fname, String lname, String street, String city, String state, String postalCode, String region,
					String country, String companyName, String title, String workPhone, String workExt, String cellPhone, String homePhone, String faxNbr,
					String email, Date lastMeetingDt, ContactCategory contactCategory, String referredBy, String notes, Integer importance,
					Date lastUpdated, String relationship, List<Encounter> encounters) {
		this.salutation = salutation;
		this.fname = fname;
		this.lname = lname;
		this.street = street;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.region = region;
		this.country = country;
		this.companyName = companyName;
		this.title = title;
		this.workPhone = workPhone;
		this.workExt = workExt;
		this.cellPhone = cellPhone;
		this.homePhone = homePhone;
		this.faxNbr = faxNbr;
		this.email = email;
		this.lastMeetingDt = lastMeetingDt;
		this.contactCategory = contactCategory;
		this.referredBy = referredBy;
		this.notes = notes;
		this.importance = importance;
		this.lastUpdated = lastUpdated;
		this.relationship = relationship;
		this.encounters = encounters;
	}

	public Salutation getSalutation() { return this.salutation; }
	public void setSalutation(Salutation salutation) {
		try {
			this.salutation = salutation;
		} catch (Exception e)  {
			this.salutation = null;
		}
	}

	public String getFname() { return this.fname; }
	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() { return this.lname; }
	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getStreet() { return this.street; }
	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() { return this.city; }
	public void setCity(String city) {
		this.city = city;
	}

	public String getState() { return this.state; }
	public void setState(String state) {
		this.state = state.substring(0,2);
	}

	public String getPostalCode() { return this.postalCode; }
	public void setPostalCode(String postalCode) {
		if (postalCode.length() >= 9) {
			this.postalCode = postalCode.substring(0,5) + "-" + postalCode.substring(5,9);
		} else if (postalCode.length() >= 5)  {
			this.postalCode = postalCode.substring(0,5);
		} else {
			this.postalCode = "";
		}
	}

	public String getRegion() { return this.region; }
	public void setRegion(String region) {
		this.region = region;
	}

	public String getCountry() { return this.country; }
	public void setCountry(String country) {
		this.country = country;
	}

	public String getCompanyName() { return this.companyName; }
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getTitle() { return this.title; }
	public void setTitle(String title) {
		this.title = title;
	}

	public String getWorkPhone() { return this.workPhone; }
	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}

	public String getWorkExt() { return this.workExt; }
	public void setWorkExt(String workExt) {
		this.workExt = workExt;
	}

	public String getCellPhone() { return this.cellPhone; }
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getHomePhone() { return this.homePhone; }
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getFaxNbr() { return this.faxNbr; }
	public void setFaxNbr(String faxNbr) {
		this.faxNbr = faxNbr;
	}

	public String getEmail() { return this.email; }
	public void setEmail(String email) {
		this.email = email;
	}

	public Date getLastMeetingDt() { return this.lastMeetingDt; }
	public void setLastMeetingDt(Date lastMeetingDt) {
		try {
			this.lastMeetingDt = lastMeetingDt;
		} catch (Exception e)  {
			this.lastMeetingDt = new Date(0);
		}
	}

	public ContactCategory getContactCategory() { return this.contactCategory; }
	public void setContactCategory(ContactCategory contactCategory) {
		this.contactCategory = contactCategory;
	}

	public String getReferredBy() { return this.referredBy; }
	public void setReferredBy(String referredBy) {
		this.referredBy = referredBy;
	}

	public String getNotes() { return this.notes; }
	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Integer getImportance() { return this.importance; }
	public void setImportance(Integer importance) {
		if (importance > 5)  {
			importance = 5;
		} else if (importance < 1)  {
			importance = 1;
		}
		this.importance = importance;
	}

	public Date getLastUpdated() { return this.lastUpdated; }
	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public String getRelationship() { return this.relationship; }
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public List<Encounter> getEncounters() { return this.encounters; }
	public void setEncounters(List<Encounter> encounters) {
		this.encounters = encounters;
	}

	public String toString()  {
		StringBuffer buffer = new StringBuffer();
		buffer.append(this.getFname()).append(",").append(this.getLname()).append(",").append(this.getEmail());
		return buffer.toString();
	}
}
	
