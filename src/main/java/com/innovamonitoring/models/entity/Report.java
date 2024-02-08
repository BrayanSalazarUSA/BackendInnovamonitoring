package com.innovamonitoring.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "reports")
public class Report implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long numerCase;

	private String company;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "HH:mm")
	@JsonFormat(pattern = "HH:mm")
	private Date time;

	@ManyToOne()
	@JoinColumn(name = "caseType")
	private CaseType caseType;

	private String level;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
	private Date date;

	private String pdf;

	@ManyToOne()
	@JoinColumn(name = "property")
	@JsonIgnoreProperties({  "users", "reports" })
	private Property property;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Evidence> evidences;


	@ManyToOne()
	@JoinColumn(name = "role")
	private Agent agent;

	private boolean verified;
	public Report() {

	}
/* */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumerCase() {
		return numerCase;
	}

	public void setNumerCase(Long numerCase) {
		this.numerCase = numerCase;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPdf() {
		return pdf;
	}

	public void setPdf(String pdf) {
		this.pdf = pdf;
	}



	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public CaseType getCaseType() {
		return caseType;
	}

	public void setCaseType(CaseType caseType) {
		this.caseType = caseType;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public List<Evidence> getEvidences() {
		return evidences;
	}

	public void setEvidences(List<Evidence> evidences) {
		this.evidences = evidences;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}



}