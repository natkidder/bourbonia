package web;

import java.util.*;
import javax.persistence.*;
//import java.sql.Date;
import java.io.Serializable;
import java.text.SimpleDateFormat;

import org.hibernate.annotations.Index;

@Entity
@Table(name="ENCOUNTER")

public class Encounter {

	@Id
	@Column(name="ENCOUNTER_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Date transactDt;

	@Column(name="ENCOUNTER", nullable=false)
	private String encounter;

	@ManyToOne
	@JoinColumn(name="CONTACT_ID", insertable=false, updatable=false, nullable=false)
	private Contact contact;

	public Encounter() {}

	public Encounter(Date transactDt, String encounter) {
		this.transactDt = transactDt;
		this.encounter = encounter;
	}

	public Integer getId()  { return this.id; }
	public void setId(Integer value) {
		this.id = value;
	}

	public Date getTransactDt() { return this.transactDt; }
	public void setTransactDt() {
		Calendar cal = Calendar.getInstance();
		this.transactDt = (Date)cal.getTime();
	}
	public void setTransactDt(Date value) {
		try {
			this.transactDt = value;
		} catch (Exception e) {
			this.transactDt = new Date(0);
		}
	}

	public String getEncounter() { return this.encounter; }
	public void setEncounter(String value)  {
		this.encounter = value;
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(getTransactDt().toString()).append(",").append(getEncounter());
		return buffer.toString();
	}
}
