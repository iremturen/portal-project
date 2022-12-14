package com.izibiz.training.entity.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class StockDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String inventoryId;
	private String name;
	private String brand;
	private BigDecimal unitPrice;
	private BigDecimal quantity;
	private String uuid;
	private String email;

	public StockDTO(String uuid, Long id, String inventoryId, String name, String brand, BigDecimal unitPrice,
			BigDecimal quantity, String email) {

		this.uuid = uuid;
		this.id = id;
		this.inventoryId = inventoryId;
		this.name = name;
		this.brand = brand;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.email = email;
		// this.identifier=identifier;
	}

	public StockDTO() {
		// burada olması lazım
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(String inventoryId) {
		this.inventoryId = inventoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	

}