package com.izibiz.training.entity.dto;

import org.springframework.data.domain.Page;

public class PagingResponse {
	
	private Page<StockDTO> list ;

	public PagingResponse(Page<StockDTO> list) {
		this.list = list;
	}

	public PagingResponse() {
		
	}
	public Page<StockDTO> getList() {
		return list;
	}

	public void setList(Page<StockDTO> list) {
		this.list = list;
	}

	

}
