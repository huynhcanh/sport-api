package com.ctlht.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="image")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageEntity extends BaseEntity{
	
	@Column(name="photo")
	private String photo;

	@ManyToOne
	@JoinColumn(name="productid")
	private ProductEntity product;
}
