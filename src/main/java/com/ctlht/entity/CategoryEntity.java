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
@Table(name="category")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryEntity extends BaseEntity{

	@Column(name="code")
	private String code;

	@Column(name="value")
	private String value;
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private List<ProductEntity> products;
}
