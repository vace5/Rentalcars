package com.rentalcars.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "vehicles")
public class VehicleEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="vehicle_id") 
	private long id;

	@Column(name="vehicle_brand_name") 
	private String brandName;

	@Column(name="vehicle_rent_amount") 
	private int rentAmount;
	
	 // default fetch type for ManyToOne: EAGER
	@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id")
	private ModelEntity model;
    
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "vehicle")
    @Column(name="contract_vehicle_id")
	private Set<ContractEntity> contracts = new HashSet<>();
	
}
