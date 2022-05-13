package com.ctlht.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity extends BaseEntity{
	
	@Column(name="password")
	private String password;
	
	@Column(name="name")
	private String name;
	
	@Column(name="phone")
	private String phone;

	@Column(name="image")
	private String image;

	@Column(name="email", unique= true)
	private String email;
	
	@ManyToOne
	@JoinColumn(name="roleid")
	private RoleEntity role;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<OrderEntity> orders;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<CartEntity> carts;
	
}
