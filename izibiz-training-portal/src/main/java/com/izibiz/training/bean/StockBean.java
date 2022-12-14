package com.izibiz.training.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.izibiz.training.bean.base.GenericBean;
import com.izibiz.training.entity.Stock;
import com.izibiz.training.entity.dto.StockDTO;
import com.izibiz.training.lazy.model.StockDtoLazyModel;

@ManagedBean(name = "stockBean")
@SessionScoped
public class StockBean extends GenericBean<StockDTO> {

	private static final long serialVersionUID = 1L;
	private List<StockDTO> filteredStockList;
	private StockDTO stockDto;
	private StockDTO selectedStockDto;
	private StockDtoLazyModel stockDtoLazyModel;
	private Stock selectedStock;

	public boolean hasSelectedStock() {
		return this.selectedStockDto != null;
	}

	public void loadPage() {

		Map<String, Object> filter = new HashMap<String, Object>();
		filter.put("1", "1");
		stockDtoLazyModel = new StockDtoLazyModel(getRestTemplate());
		stockDtoLazyModel.setFiltermap(filter);
		filteredStockList = new ArrayList<>();
	}

	public void deleteStock() {
		getRestTemplate().delete("http://localhost:8085/rest/stock/" + selectedStockDto.getId());
		addInfoMessage("Silme işlemi başarılı");

	}

	public List<StockDTO> getFilteredStockList() {
		return filteredStockList;
	}

	public void setFilteredStockList(List<StockDTO> filteredStockList) {
		this.filteredStockList = filteredStockList;
	}

	public StockDTO getSelectedStockDto() {
		return selectedStockDto;
	}

	public void setSelectedStockDto(StockDTO selectedStockDto) {
		this.selectedStockDto = selectedStockDto;
	}

	public StockDtoLazyModel getStockDtoLazyModel() {
		return stockDtoLazyModel;
	}

	public void setStockDtoLazyModel(StockDtoLazyModel stockDtoLazyModel) {
		this.stockDtoLazyModel = stockDtoLazyModel;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public StockDTO getStockDto() {
		return stockDto;
	}

	public void setStockDto(StockDTO stockDto) {
		this.stockDto = stockDto;
	}

	public Stock getSelectedStock() {
		return selectedStock;
	}

	public void setSelectedStock(Stock selectedStock) {
		this.selectedStock = selectedStock;
	}

}
