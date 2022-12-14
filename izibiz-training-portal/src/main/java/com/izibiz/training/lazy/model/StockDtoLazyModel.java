package com.izibiz.training.lazy.model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.izibiz.training.entity.dto.Root;
import com.izibiz.training.entity.dto.StockDTO;
import com.izibiz.training.service.base.StockService;

public class StockDtoLazyModel extends LazyDataModel<StockDTO> {

	private static final long serialVersionUID = 12L;
	private List<StockDTO> stockDto;
	private Map<String, Object> filtermap;
	private StockService stockService;
	private RestTemplate restTemplate;	
	private Root root;

	public StockDtoLazyModel(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public StockDTO getRowData(String rowKey) {
		for (StockDTO stock : stockDto) {
			if (stock.getId().equals(Long.valueOf(rowKey)))
				return stock;
		}
		return null;
	}

	@Override
	public Object getRowKey(StockDTO stock) {
		return stock.getId();

	}

	@Override
	public List<StockDTO> load(int first, int pageSize, String sortField, SortOrder sortOrder,
			Map<String, Object> filters) {

		String url = "http://localhost:8085/rest/stock";

		if (filters.size() != 0) {
			for (Map.Entry<String, Object> entry : filters.entrySet()) {
				filters.put("sortField", sortField.toString());
				filters.put("sortOrder", sortOrder.toString());
				filters.put("first", String.valueOf(first / pageSize));
				filters.put("pageSize", String.valueOf(pageSize));
				UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url).queryParam("pageSize", pageSize)
						.queryParam("first", first / pageSize).queryParam("sortField", sortField)
						.queryParam("sortOrder", sortOrder.toString()).queryParam(entry.getKey(), entry.getValue());

				String bodyFilter = restTemplate
						.exchange(builder.buildAndExpand(filters).toUri(), HttpMethod.GET, null, String.class)
						.getBody();

				ObjectMapper mapper = new ObjectMapper();
				try {
					root = mapper.readValue(bodyFilter, Root.class);
					stockDto = root.getContent();
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}
			}
		} else if (sortField.isEmpty() == false) {
			filters.put("sortField", sortField.toString());
			filters.put("sortOrder", sortOrder.toString());
			filters.put("first", String.valueOf(first / pageSize));
			filters.put("pageSize", String.valueOf(pageSize));

			UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url).queryParam("sortField", sortField)
					.queryParam("sortOrder", sortOrder.toString()).queryParam("first", String.valueOf(first / pageSize))
					.queryParam("pageSize", String.valueOf(pageSize));

			String bodySort = restTemplate
					.exchange(builder.buildAndExpand(filters).toUri(), HttpMethod.GET, null, String.class).getBody(); // first=root.getPageable().getPageNumber();

			ObjectMapper mapper = new ObjectMapper();
			try {
				root = mapper.readValue(bodySort, Root.class);
				stockDto = root.getContent();
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}

		} else {
			String body = restTemplate.exchange("http://localhost:8085/rest/stocks", HttpMethod.GET, null, String.class)
					.getBody();
			ObjectMapper mapper = new ObjectMapper();
			try {
				root = mapper.readValue(body, Root.class);
				stockDto = root.getContent();
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
		return stockDto;
	}

	@Override
	public int getRowCount() {

		if (root == null) {
			return 0;
		}
		return root.getTotalElements();
	}

	public Map<String, Object> getFiltermap() {
		return filtermap;
	}

	public void setFiltermap(Map<String, Object> filtermap) {
		this.filtermap = filtermap;
	}

	public StockService getStockService() {
		return stockService;
	}

	public void setStockService(StockService stockService) {
		this.stockService = stockService;
	}

	

	
}
