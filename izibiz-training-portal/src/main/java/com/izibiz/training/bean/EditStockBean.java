package com.izibiz.training.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.izibiz.training.bean.base.GenericBean;
import com.izibiz.training.entity.Stock;
import com.izibiz.training.entity.dto.StockDTO;
import com.izibiz.training.service.base.StockService;

@ManagedBean
@SessionScoped
public class EditStockBean extends GenericBean<Stock> {

	private static final long serialVersionUID = 1L;
	private StockService service;
	private StockDTO stockDTO;
	private Stock stock;
	private List<Stock> stocks;
	private StockDTO selectedStockDto;
	private String identifier;
	private Stock selectedStock;

	public void openPage() {
	}

	public void editStock() {

		Stock stockEntity = getStockService().findById(selectedStockDto.getId());

		stockEntity.setBrand(selectedStockDto.getBrand());
		stockEntity.setInventoryId(selectedStockDto.getInventoryId());
		stockEntity.setName(selectedStockDto.getName());
		stockEntity.setQuantity(selectedStockDto.getQuantity());
		stockEntity.setUnitPrice(selectedStockDto.getUnitPrice());
		stockEntity.setEmail(selectedStockDto.getEmail());

		getStockService().saveOrUpdate(stockEntity);
		openPage();
		addInfoMessage("Düzenleme işlemi başarılı.");
	}

	public void editStockWithRest() {

		Stock stock = new Stock();
		stock.setEmail(selectedStockDto.getEmail());
		stock.setBrand(selectedStockDto.getBrand());
		stock.setId(selectedStockDto.getId());
		stock.setInventoryId(selectedStockDto.getInventoryId());
		stock.setName(selectedStockDto.getName());
		stock.setQuantity(selectedStockDto.getQuantity());
		stock.setUnitPrice(selectedStockDto.getUnitPrice());
		stock.setUuid(selectedStockDto.getUuid());

		getRestTemplate().put("http://localhost:8085/rest/stock/" + selectedStockDto.getId(), stock);
		addInfoMessage("Düzenleme işlemi başarılı");

	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public StockDTO getSelectedStockDto() {
		return selectedStockDto;
	}

	public void setSelectedStockDto(StockDTO selectedStockDto) {
		this.selectedStockDto = selectedStockDto;
	}

	public Stock getSelectedStock() {
		return selectedStock;
	}

	public void setSelectedStock(Stock selectedStock) {
		this.selectedStock = selectedStock;
	}

	public StockService getService() {
		return service;
	}

	public void setService(StockService service) {
		this.service = service;
	}

	public StockDTO getStockDTO() {
		return stockDTO;
	}

	public void setStockDTO(StockDTO stockDTO) {
		this.stockDTO = stockDTO;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public List<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}

}
