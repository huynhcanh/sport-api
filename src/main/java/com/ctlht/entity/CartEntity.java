package com.ctlht.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="cart", uniqueConstraints= @UniqueConstraint(columnNames= {"userid", "productsizeid"}))
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartEntity extends BaseEntity{
	
	@Column(name="quantity")
	private Integer quantity;
	
	@Column(name="totalmoney")
	private Float totalMoney;
	
	@ManyToOne
	@JoinColumn(name="userid")
    private UserEntity user;
	
	@ManyToOne
	@JoinColumn(name="productsizeid")
    private ProductSizeEntity productsize;
}
