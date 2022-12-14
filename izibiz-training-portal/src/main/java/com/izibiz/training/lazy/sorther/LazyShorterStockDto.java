package com.izibiz.training.lazy.sorther;

import java.util.Comparator;
import org.primefaces.model.SortOrder;

import com.izibiz.training.entity.dto.ArchiveGDTO;
import com.izibiz.training.entity.dto.StockDTO;

public class LazyShorterStockDto  implements  Comparator<StockDTO>{

	private static final long serialVersionUID = 1L;	
	

    private String sortField;
    private SortOrder sortOrder;
    
    public LazyShorterStockDto(String sortField, SortOrder sortOrder) {
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }
    
	@Override
	public int compare(StockDTO stk1, StockDTO stk2) {
		 try {
	            Object value1 = StockDTO.class.getField(this.sortField).get(stk1);
	            Object value2 = StockDTO.class.getField(this.sortField).get(stk2);
	 
	         int value = ((Comparable)value1).compareTo(value2);
	             
	            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
	        }
	        catch(Exception e) {
	            throw new RuntimeException();
	        }
	    }
	
	
}
