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
import jakarta.persistence.Column;

@Entity
@Table(name = "reports")
public class Report implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String company;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
	private Date dateOfReport;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "HH:mm")
	@JsonFormat(pattern = "HH:mm")
	private Date timeOfReport;

	private String level;

	private Long numerCase;

	private String pdf;

	private boolean verified;
	public Report() {
	}

	@ManyToOne()
	@JoinColumn(name = "role")
	private Agent agent;
	@ManyToOne()
	@JoinColumn(name = "caseType")
	private CaseType caseType;


	@ManyToOne()
	@JoinColumn(name = "property")
	@JsonIgnoreProperties({  "users", "reports" })
	private Property property;


	@Column(name = "police_first_responder_notified")
	private boolean policeFirstResponderNotified;

	@Column(name = "police_first_responder_scene", length = 50)
	private String policeFirstResponderScene;

	@Column(name = "security_guards_notified", length = 45)
	private String securityGuardsNotified;

	@Column(name = "security_guards_scene", length = 45)
	private String securityGuardsScene;

	@Column(name = "emailed_report", length = 45)
	private String emailedReport;

	/*
	@OneToMany(mappedBy = "report", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<IncidentTimeframe> incidentTimeframes;
	*/


/*
	public List<IncidentTimeframe> getIncidentTimeframes() {
		return incidentTimeframes;
	}

	public void setIncidentTimeframes(List<IncidentTimeframe> incidentTimeframes) {
		this.incidentTimeframes = incidentTimeframes;
	}
*/

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Evidence> evidences;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Date getDateOfReport() {
		return dateOfReport;
	}

	public void setDateOfReport(Date dateOfReport) {
		this.dateOfReport  = dateOfReport ;
	}

	public Date getTimeOfReport() {
		return timeOfReport;
	}

	public void setTimeOfReport(Date timeOfReport) {
		this.timeOfReport = timeOfReport;
	}

	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}

	public Long getNumerCase() {
		return numerCase;
	}

	public void setNumerCase(Long numerCase) {
		this.numerCase = numerCase;
	}

	public String getPdf() {
		return pdf;
	}

	public void setPdf(String pdf) {
		this.pdf = pdf;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public CaseType getCaseType() {
		return caseType;
	}

	public void setCaseType(CaseType caseType) {
		this.caseType = caseType;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public boolean isPoliceFirstResponderNotified() {
		return policeFirstResponderNotified;
	}

	public void setPoliceFirstResponderNotified(boolean policeFirstResponderNotified) {
		this.policeFirstResponderNotified = policeFirstResponderNotified;
	}

	public String getPoliceFirstResponderScene(){
		return  policeFirstResponderScene;
	}

	public void setPoliceFirstResponderScene(String policeFirstResponderScene) {
		this.policeFirstResponderScene = policeFirstResponderScene;
	}

	public String getSecurityGuardsNotified() {
		return securityGuardsNotified;
	}

	public void setSecurityGuardsNotified(String securityGuardsNotified){
		this.securityGuardsNotified = securityGuardsNotified;
	}

	public String getSecurityGuardsScene(){
		return securityGuardsScene;
	}

	public void setSecurityGuardsScene(String securityGuardsScene){
		this.securityGuardsScene = securityGuardsScene;
	}

	public String getEmailedReport(){
		return emailedReport;
	}

	public void setEmailedReport(String emailedReport) {
		this.emailedReport = emailedReport;
	}

	public List<Evidence> getEvidences() {
		return evidences;
	}

	public void setEvidences(List<Evidence> evidences) {
		this.evidences = evidences;
	}



}