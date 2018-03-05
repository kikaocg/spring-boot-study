package com.study.api.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import enums.ProfileEnum;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {

	private static final long serialVersionUID = 6614682362268443186L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "cpf", nullable = false)
	private String cpf;
	
	@Column(name = "time_value", nullable = true)
	private BigDecimal timeValue;
	
	@Column(name = "hours_worked_day", nullable = true)
	private Float totalHoursWorkedDay;
	
	@Column(name = "hours_lunch_day", nullable = true)
	private Float totalHoursLunch;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "profile", nullable = false)
	private ProfileEnum profile;
	
	@Column(name = "date_creation", nullable = false)
	private Date dateCreation;
	
	@Column(name = "last_update", nullable = false)
	private Date lastUpdate;
	
    @ManyToOne(fetch = FetchType.EAGER)
	private Company company;
    
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Timeline> timeline;
	
	public Employee() { }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public BigDecimal getTimeValue() {
		return timeValue;
	}

	public void setTimeValue(BigDecimal timeValue) {
		this.timeValue = timeValue;
	}

	public Float getTotalHoursWorkedDay() {
		return totalHoursWorkedDay;
	}

	public void setTotalHoursWorkedDay(Float totalHoursWorkedDay) {
		this.totalHoursWorkedDay = totalHoursWorkedDay;
	}

	public Float getTotalHoursLunch() {
		return totalHoursLunch;
	}

	public void setTotalHoursLunch(Float totalHoursLunch) {
		this.totalHoursLunch = totalHoursLunch;
	}

	public ProfileEnum getProfile() {
		return profile;
	}

	public void setProfile(ProfileEnum profile) {
		this.profile = profile;
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

	public List<Timeline> getTimeline() {
		return timeline;
	}

	public void setTimeline(List<Timeline> timeline) {
		this.timeline = timeline;
	}


	@PreUpdate
	public void preUpdate() {
		lastUpdate = new Date();
	}

	@PrePersist
	public void prePersist() {
		final Date now = new Date();
		dateCreation = now;
		lastUpdate = now;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", cpf=" + cpf
				+ ", timeValue=" + timeValue + ", totalHoursWorkedDay=" + totalHoursWorkedDay + ", totalHoursLunch="
				+ totalHoursLunch + ", profile=" + profile + ", dateCreation=" + dateCreation + ", lastUpdate="
				+ lastUpdate + "]";
	}
	
}
