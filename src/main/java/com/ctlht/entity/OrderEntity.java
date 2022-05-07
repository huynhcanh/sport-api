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
@Table(name="orderproduct")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity extends BaseEntity{

	@Column(name="totalmoney")
	private Float totalMoney;
	
	@Column(name="adddress")
	private String adddress;
	
	@ManyToOne
	@JoinColumn(name = "userid")
	private UserEntity user;
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderDetailEntity> orderdetails;
}
