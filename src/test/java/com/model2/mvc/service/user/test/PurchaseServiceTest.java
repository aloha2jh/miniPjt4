package com.model2.mvc.service.user.test;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.purchase.PurchaseService; 

 
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = { "classpath:config/commonservice.xml" })
public class PurchaseServiceTest {
 
	@Autowired
	@Qualifier("purchaseServiceImpl")
	private PurchaseService purchaseService;

	@Test
	public void testAddPurchase() throws Exception { 
		Purchase ps = new Purchase();
		User user = new User();
		Product pd = new Product();
		
		user.setUserId("user01");

		pd.setProdNo(10062);
		  
		ps.setBuyer(user);
		ps.setDivyAddr("sweethome");
		ps.setDivyDate("20-05-14");
		ps.setDivyRequest("√÷¥Î«—ª°∏Æ");
		//
		ps.setPaymentOption("1");
		ps.setPurchaseProd(pd);
//
		ps.setReceiverName("¿Ã¡§«œ");
		ps.setReceiverPhone("010-4036-8132");
		ps.setTranCode("000");
		 
		  
		
		purchaseService.addPurchase(ps); 
//		
//		prod = productService.getProduct(10060); //πÊ±›add«—∞≈ πﬁ∞Ì. 
//		Assert.assertEquals("±÷", prod.getProdName()); 
//		Assert.assertEquals("ΩÃΩÃ«—±÷", prod.getProdDetail()); 
//		Assert.assertEquals("200513", prod.getManuDay()); 
//		Assert.assertEquals(2000, prod.getPrice());   
//		
//		
//		insert into transaction 
//		(buyer_id, DEMAILADDR, dlvy_date, dlvy_request, ORDER_DATA, payment_option, prod_no, receiver_name, receiver_phone, tran_status_code, tran_no) 
//		values ( 'user01', 'sweethome', ('20-01-01'), 'ª°∏Æø‰', sysdate, 1, 10000, 'ljh','8132','001', seq_transaction_tran_no.NEXTVAL );
		
	}
	
	 
	
}