package com.ctlht.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="orderdetail", uniqueConstraints= @UniqueConstraint(columnNames= {"orderid", "productsizeid"}))
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailEntity extends BaseEntity{
	
	@Column(name="quantity")
	private Integer quantity;
	
	@Column(name="totalmoney")
	private Float totalMoney;
	
	@ManyToOne
	@JoinColumn(name="orderid")
    private OrderEntity order;
	
	@ManyToOne
	@JoinColumn(name="productsizeid")
    private ProductSizeEntity productsize;
}
