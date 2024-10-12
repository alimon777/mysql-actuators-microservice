package com.ust.client.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	private long id;
	private String brand;
	private String description;
	private int quantity;
	private int price;
}