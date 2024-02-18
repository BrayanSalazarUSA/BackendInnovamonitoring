package com.innovamonitoring.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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

    @Column(name = "police_numer_case")
    private Long policeNumerCase;


	@Column(name = "security_guards_notified")
	private boolean securityGuardsNotified;

	@Column(name = "security_guards_scene")
	private boolean securityGuardsScene;

	@Column(name = "emailed_report", length = 45)
	private String emailedReport;

	@Column(name = "incident_date")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
	private Date incidentDate;

	@Column(name = "incident_start_time")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "HH:mm")
	@JsonFormat(pattern = "HH:mm")
	private Date incidentStartTime;

	@Column (name = "incident_end_time")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "HH:mm")
	@JsonFormat(pattern = "HH:mm")
	private Date incidentEndTime;

	@Column(name = "cameras_functioning")
	private boolean camerasFunctioning;

	@Column(name = "list_malfunctioning_cameras", length = 45)
	private String listMalfuncioningCameras;

	@Column(name = "observed_via_cameras")
	private boolean observerdViaCameras;
	@Column(name = "report_details", length = 3000)
	private String reportDetails;

	@Column(name = "form_notification_client", length = 45)
	private String formNotificationClient;


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

    public Long getPoliceNumerCase() {
		return policeNumerCase;
	}

	public void setPoliceNumerCase (Long policeNumerCase){
		this.policeNumerCase = policeNumerCase;
	}

	public boolean isSecurityGuardsNotified() {
		return securityGuardsNotified;
	}


	public void setSecurityGuardsNotified(boolean securityGuardsNotified) {
		this.securityGuardsNotified = securityGuardsNotified;
	}

	public boolean isSecurityGuardsScene() {
		return securityGuardsScene;
	}

	public void setSecurityGuardsScene(boolean securityGuardsScene) {
		this.securityGuardsScene = securityGuardsScene;
	}


	public String getEmailedReport(){
		return emailedReport;
	}

	public void setEmailedReport(String emailedReport) {
		this.emailedReport = emailedReport;
	}

	public Date getIncidentStartTime (){
		return incidentStartTime;
	}

	public void setIncidentStartTime(Date incidentStartTime) {
		this.incidentStartTime = incidentStartTime;
	}

	public Date getIncidentDate() {
		return incidentDate;
	}

	public void setIncidentDate(Date incidentDate) {
		this.incidentDate = incidentDate;
	}




	public Date getIncidentEndTime() {
		return incidentEndTime;
	}

	public void setIncidentEndTime(Date incidentEndTime) {
		this.incidentEndTime = incidentEndTime;
	}


	public boolean isCamerasFunctioning() {
		return camerasFunctioning;
	}

	public void setCamerasFunctioning(boolean camerasFunctioning) {
		this.camerasFunctioning = camerasFunctioning;
	}

	public String getlistMalfuncioningCameras() {
		return listMalfuncioningCameras;
	}

	public void setlistMalfuncioningCameras(String listMalfunctioningCameras) {
		this.listMalfuncioningCameras = listMalfunctioningCameras;
	}


	public boolean isObserverdViaCameras() {
		return observerdViaCameras;
	}

	public void setObserverdViaCameras(boolean observerdViaCameras) {
		this.observerdViaCameras = observerdViaCameras;
	}



	public List<Evidence> getEvidences() {
		return evidences;
	}

	public void setEvidences(List<Evidence> evidences) {
		this.evidences = evidences;
	}

	public String getreportDetails() {
		return  reportDetails;
	}

	public void setreportDetails(String reportDetails){
		this.reportDetails = reportDetails;
	}

	public  String getformNotificationClient(){
		return formNotificationClient;
	}

	public void setformNotificationClient(String formNotificationClient){
		this.formNotificationClient = formNotificationClient;
	}

}