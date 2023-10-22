package com.innovamonitoring.models.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
@Table(name = "properties")
public class Property implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "property_id")
	private Long id;
	private String name;
	private String direction;
	private String img;

	private String mapImg;

	/*@ManyToOne()
	@JoinColumn(name = "user")
	@JsonIgnoreProperties({ "user" })*/
	@ManyToMany(cascade ={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name="Property_Users",
			joinColumns=@JoinColumn(name="property_id"),
			inverseJoinColumns=@JoinColumn(name="user_id")
	)
	@JsonIgnoreProperties({"properties"})
	private Set<UserEntity> users = new HashSet<>();

	@OneToMany(mappedBy = "property", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnoreProperties("property")
	private List<Camera> cameras;

	//@JsonIgnore
	@OneToMany(mappedBy = "property", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Report> reports;

	public List<Camera> getCameras() {
		return cameras;
	}

	public void setCameras(List<Camera> cameras) {
		this.cameras = cameras;
	}

	public Property() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Report> getReports() {
		return reports;
	}

	public void setReports(List<Report> reports) {
		this.reports = reports;
	}

	public Set<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(Set<UserEntity> users) {
		this.users = users;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getMapImg() {
		return mapImg;
	}

	public void setMapImg(String mapImg) {
		this.mapImg = mapImg;
	}

	private static final long serialVersionUID = 1L;

}
