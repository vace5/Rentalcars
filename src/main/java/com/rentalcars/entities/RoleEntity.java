package com.rentalcars.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "roles")
@NoArgsConstructor
public class RoleEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "role_id")
	private long id;

	@Column(name = "role_name")
	private String roleName;

	@JsonIgnore
	@ManyToMany(mappedBy = "roles")
	private Set<UserEntity> users = new HashSet<>();

	public RoleEntity(Long id, String roleName) {
		this.id = id;
		this.roleName = roleName;
	}

}
