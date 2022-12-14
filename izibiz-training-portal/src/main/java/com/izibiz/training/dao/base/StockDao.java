package com.izibiz.training.dao.base;

import java.util.List;
import java.util.Map;

import org.primefaces.model.SortOrder;

import com.izibiz.training.dao.common.GenericDao;
import com.izibiz.training.entity.Stock;
import com.izibiz.training.entity.dto.StockDTO;

public interface StockDao extends GenericDao<Stock> {

	List<StockDTO> getStockDtos(int first, int pageSize, String sortField, SortOrder sortOrder,
			Map<String, Object> filters);

	long getStockDtoCount(Map<String, Object> filters);

}
