package com.izibiz.training.bean;

import java.util.List;
import java.util.UUID;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.izibiz.training.bean.base.GenericBean;
import com.izibiz.training.entity.Stock;
import com.izibiz.training.entity.dto.StockDTO;
import com.izibiz.training.service.StockServiceImp;
import com.izibiz.training.service.base.StockService;

@ManagedBean
@SessionScoped
public class NewStockBean extends GenericBean<Stock> {

	private static final long serialVersionUID = 1L;
	private String identifier;
	private StockDTO stockDTO;
	private StockService stockService;
	private StockDTO selectedStock;
	private Stock newStock;
	private List<StockDTO> stockDTOs;

	public void loadPage() {
		stockService = new StockServiceImp();
	}

	public void clearNewStock() {
		newStock = new Stock();
		newStock.setUuid(UUID.randomUUID().toString());
	}

	public void saveStock() {

		getStockService().saveOrUpdate(newStock);
		clearNewStock();

		addInfoMessage("Ekleme işlemi başarılı");
		newStock = null;

	}

	public void createStock() {

		Stock stock = new Stock();

		stock.setEmail(newStock.getEmail());
		stock.setBrand(newStock.getBrand());
		stock.setId(newStock.getId());
		stock.setInventoryId(newStock.getInventoryId());
		stock.setName(newStock.getName());
		stock.setQuantity(newStock.getQuantity());
		stock.setUnitPrice(newStock.getUnitPrice());
		stock.setUuid(newStock.getUuid());

		getRestTemplate().postForLocation("http://localhost:8085/rest/stock", stock);
		addInfoMessage("Ekleme işlemi başarılı");

	}

	public StockDTO getStockDTO() {
		return stockDTO;
	}

	public void setStockDTO(StockDTO stockDTO) {
		this.stockDTO = stockDTO;
	}

	public void setStockService(StockService stockService) {
		this.stockService = stockService;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public StockDTO getSelectedStock() {
		return selectedStock;
	}

	public void setSelectedStock(StockDTO selectedStock) {
		this.selectedStock = selectedStock;
	}

	public StockService getStockService() {
		return stockService;
	}

	public Stock getNewStock() {
		return newStock;
	}

	public void setNewStock(Stock newStock) {
		this.newStock = newStock;
	}

	public List<StockDTO> getStockDTOs() {
		return stockDTOs;
	}

	public void setStockDTOs(List<StockDTO> stockDTOs) {
		this.stockDTOs = stockDTOs;
	}

}
