package com.izibiz.training.entity.dto;

import java.util.ArrayList;
import java.util.List;

public class Root {
	
	List<StockDTO> content = new ArrayList<StockDTO>();
	Pageable pageable;
	private int totalElements;
	private int totalPages;
	private boolean last;
	private int size;
	private int number;
	Sort sort;
	private boolean first;
	private int numberOfElements;
	private boolean empty;

	// Getter Methods
	
	public Pageable getPageable() {
		return pageable;
	}

	public int getTotalElements() {
		return totalElements;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public boolean getLast() {
		return last;
	}

	public int getSize() {
		return size;
	}

	public int getNumber() {
		return number;
	}

	public Sort getSort() {
		return sort;
	}

	public boolean getFirst() {
		return first;
	}

	public int getNumberOfElements() {
		return numberOfElements;
	}

	public boolean getEmpty() {
		return empty;
	}

	// Setter Methods

	public void setPageable(Pageable pageableObject) {
		this.pageable = pageableObject;
	}

	public void setTotalElements(int totalElements) {
		this.totalElements = totalElements;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public void setLast(boolean last) {
		this.last = last;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setSort(Sort sortObject) {
		this.sort = sortObject;
	}

	public void setFirst(boolean first) {
		this.first = first;
	}

	public void setNumberOfElements(int numberOfElements) {
		this.numberOfElements = numberOfElements;
	}

	public void setEmpty(boolean empty) {
		this.empty = empty;
	}

	public List<StockDTO> getContent() {
		return content;
	}

	public void setContent(List<StockDTO> content) {
		this.content = content;
	}

	



}