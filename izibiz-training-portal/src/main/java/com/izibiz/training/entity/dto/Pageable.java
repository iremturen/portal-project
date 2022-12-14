package com.izibiz.training.entity.dto;

public class Pageable {
	Sort SortObject;
	private int pageNumber;
	private int pageSize;
	private int offset;
	private boolean unpaged;
	private boolean paged;

	// Getter Methods

	public Sort getSort() {
		return SortObject;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getOffset() {
		return offset;
	}

	public boolean getUnpaged() {
		return unpaged;
	}

	public boolean getPaged() {
		return paged;
	}

	// Setter Methods

	public void setSort(Sort sortObject) {
		this.SortObject = sortObject;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public void setUnpaged(boolean unpaged) {
		this.unpaged = unpaged;
	}

	public void setPaged(boolean paged) {
		this.paged = paged;
	}
}
