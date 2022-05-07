package com.ctlht.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity extends BaseEntity{

	@Column(name="name")
	private String name;

	@Column(name="unitprice")
	private Float unitPrice;
	
	@Column(name="saleprice")
	private Float salePrice;

	@Column(name="discount")
	private Float discount;

	@Column(name="description")
	private String description;

	@ManyToOne
	@JoinColumn(name="categoryid")
	private CategoryEntity category;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<ProductSizeEntity> productsize;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<ImageEntity> images;
}
