package com.model2.mvc.service.purchase;
 
import java.util.Map;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.Purchase;

public interface PurchaseService {
 
	public void addPurchase(Purchase purchase) throws Exception;

	public Product getPurchase(int purchaseNo) throws Exception;
	
	public Map<String, Object> getPurchaseList(Search svo) throws Exception;
		 
	public void updatePurchase(Purchase purchase ) throws Exception;
	 
}
