package com.mx.AgenciaApi.Domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="MODELOS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Models {

	@Id
	@Column(name="ID")
	private Long id;
	@Column(name="NOMBRE")
	private String name;
	@Column(name="TIPO")
	private String type;
	@Column(name="PRECIO")
	private Float price;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="ID_MARCA")
	private Branches branch;
	
}
