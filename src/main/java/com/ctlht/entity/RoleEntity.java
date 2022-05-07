package com.ctlht.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="role")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleEntity extends BaseEntity{
	
	@Column(name="code")
	private String code;
	
	@Column(name="value")
	private String value;
	
	@OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
	private List<UserEntity> users;
}
