package com.izibiz.training.service.base;

import java.util.List;
import java.util.Map;

import org.primefaces.model.SortOrder;
import org.springframework.stereotype.Service;

import com.izibiz.training.entity.Stock;
import com.izibiz.training.entity.dto.StockDTO;

public interface StockService {

	List<StockDTO> getStockDtos(int first, int pageSize, String sortField, SortOrder sortOrder,
			Map<String, Object> filters);

	long getStockDtoCount(Map<String, Object> filters);

	public void saveOrUpdate(Stock stock);

	public Stock findById(Long id);

}
