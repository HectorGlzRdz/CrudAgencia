package com.mx.AgenciaApi.Domain;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "MARCAS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Branches {

	@Id
	@Column(name="ID")
	private Long id;
	@Column(name="NOMBRE")
	private String name;
	@Column(name="Origen")
	private String origin;
	@Column(name="FECHA_CREACION")
	private Date createDate;
	
	@OneToMany(mappedBy = "branch", cascade = CascadeType.ALL)
	@JsonIgnore
	List<Models> models= new ArrayList<>();
}
