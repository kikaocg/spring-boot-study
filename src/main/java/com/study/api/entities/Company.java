package com.study.api.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "company")
public class Company implements Serializable {
	
	private static final long serialVersionUID = -8743661702156824608L;
	
	private Long id;
	private String name;
	private String cnpj;
	private Date dateCreation;
	private Date lasUpdate;
	private List<Employee> employees;
	
	public Company () {}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "cnpj", nullable = false)
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Column(name = "date_creation", nullable = false)
	public Date getDateOfCreation() {
		return dateCreation;
	}

	public void setDateOfCreation(Date dateOfCreation) {
		this.dateCreation = dateOfCreation;
	}

	@Column(name = "last_update", nullable = false)
	public Date getLasUpdate() {
		return lasUpdate;
	}

	public void setLasUpdate(Date lasUpdate) {
		this.lasUpdate = lasUpdate;
	}

	@OneToMany(mappedBy = "company", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@PreUpdate
	public void preUpdate() {
		lasUpdate = new Date();
	}

	@PrePersist
	public void prePersist() {
		final Date now = new Date();
		dateCreation = now;
		lasUpdate = now;
	}
	
	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", cnpj=" + cnpj + ", dateCreation=" + dateCreation
				+ ", lasUpdate=" + lasUpdate + "]";
	}
	
}
