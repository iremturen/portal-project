package com.izibiz.training.service;

import java.util.List;
import java.util.Map;

import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.izibiz.training.dao.base.StockDao;
import com.izibiz.training.entity.Stock;
import com.izibiz.training.entity.dto.StockDTO;
import com.izibiz.training.service.base.StockService;

@Transactional
public class StockServiceImp implements StockService {

	@Autowired
	private StockDao stockDao;

	@Override
	public List<StockDTO> getStockDtos(int first, int pageSize, String sortField, SortOrder sortOrder,
			Map<String, Object> filters) {
		if (CollectionUtils.isEmpty(filters)) {
			throw new RuntimeException("filter must not empty");
		}
		return stockDao.getStockDtos(first, pageSize, sortField, sortOrder, filters);
	}

	@Override
	public long getStockDtoCount(Map<String, Object> filters) {
		return stockDao.getStockDtoCount(filters);
	}

	@Override
	public void saveOrUpdate(Stock stock) {
		stockDao.saveOrUpdate(stock);
	}

	@Override
	public Stock findById(Long id) {
		return stockDao.get(id);
	}

}
