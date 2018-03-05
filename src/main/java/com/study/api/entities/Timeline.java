package com.study.api.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import enums.TypeHourEnum;

@Entity
@Table(name = "timeline")
public class Timeline implements Serializable {

	private static final long serialVersionUID = 8246356766678938916L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date", nullable = false)
	private Date date;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "localization", nullable = false)
	private String localization;
	
	@Column(name = "date_creation", nullable = false)
	private Date dateCreation;
	
	@Column(name = "lastUpdate", nullable = false)
	private Date lastUpdate;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "type", nullable = false)
	private TypeHourEnum type;
	
    @ManyToOne(fetch = FetchType.EAGER)
	private Employee employee;
	
	public Timeline() { }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocalization() {
		return localization;
	}

	public void setLocalization(String localization) {
		this.localization = localization;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public TypeHourEnum getType() {
		return type;
	}

	public void setType(TypeHourEnum type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Timeline [id=" + id + ", description=" + description + ", localization=" + localization + ", type="
				+ type + "]";
	}
	
}
