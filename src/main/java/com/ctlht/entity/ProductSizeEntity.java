package com.ctlht.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="productsize", uniqueConstraints= @UniqueConstraint(columnNames= {"sizeid", "productid"}))
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductSizeEntity extends BaseEntity {
	
	@Column(name="quantity")
	private Integer quantity;
	
	@ManyToOne
	@JoinColumn(name="sizeid")
    private SizeEntity size;
	
	@ManyToOne
	@JoinColumn(name="productid")
    private ProductEntity product;

	@OneToMany(mappedBy = "productsize", cascade = CascadeType.ALL)
    private List<OrderDetailEntity> orderdetails;
	
	@OneToMany(mappedBy = "productsize", cascade = CascadeType.ALL)
    private List<CartEntity> carts;
}
