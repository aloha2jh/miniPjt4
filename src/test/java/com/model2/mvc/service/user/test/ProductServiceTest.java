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
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.product.ProductService; 

 
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = { "classpath:config/commonservice.xml" })
public class ProductServiceTest {
 
	@Autowired
	@Qualifier("productServiceImpl")
	private ProductService productService;

	//@Test
	public void testAddProd() throws Exception { 
		Product prod = new Product(); 
		prod.setProdName("��"); 
		prod.setProdDetail("�̽��ѱ�"); 
		prod.setManuDay("200513"); //�̰� ������ Ÿ������ �ִ°� �˾Ƴ���???
		prod.setPrice(2000);   
	
		productService.addProduct(prod); //add ���ְ�
		
		prod = productService.getProduct(10060); //���add�Ѱ� �ް�. 
		Assert.assertEquals("��", prod.getProdName()); 
		Assert.assertEquals("�̽��ѱ�", prod.getProdDetail()); 
		Assert.assertEquals("200513", prod.getManuDay()); 
		Assert.assertEquals(2000, prod.getPrice());   
	}
	
	//@Test
	public void testGetProduct() throws Exception {
		Product prod = new Product(); 
		prod = productService.getProduct(10060);
	 
		System.out.println(prod); 
		 
		Assert.assertEquals("��", prod.getProdName()); 
		Assert.assertEquals("�̽��ѱ�", prod.getProdDetail()); 
		Assert.assertEquals("200513", prod.getManuDay()); 
		Assert.assertEquals(2000, prod.getPrice());    
		Assert.assertNotNull(productService.getProduct(10061) ); 
		Assert.assertNotNull(productService.getProduct(10062) ); 
	}

	//@Test
	 public void testUpdateProduct() throws Exception{
		 
		Product pd = productService.getProduct(10062); 
		Assert.assertNotNull(pd);
		
		Assert.assertEquals( 10062, pd.getProdNo() );
		//Assert.assertEquals("111-2222-3333", user.getPhone()); 
 
		pd.setProdName("����ٳ���");
		pd.setProdDetail("����츲���� �� �ٳ���");
		pd.setManuDay("200514");
		pd.setPrice(6000);
		
		productService.updateProduct(pd); 
			 
		pd = productService.getProduct(10062);
		//Assert.assertNotNull(user);
		
		//==> console Ȯ��
		System.out.println(pd);
			
		//==> API Ȯ�� 
		Assert.assertEquals("����ٳ���", pd.getProdName());
		Assert.assertEquals("����츲���� �� �ٳ���", pd.getProdDetail());
		Assert.assertEquals("200514", pd.getManuDay());
		Assert.assertEquals(6000, pd.getPrice()); 
	 }
	
	@Test
	public void testGetProductListAll() throws Exception{
		
		//��ġ�� �Խñ۳ѹ� 1~3����
	 	Search search = new Search();
	 	search.setCurrentPage(1);
	 	search.setPageSize(3);
	 	 
	 	Map<String,Object> map = productService.getProductList(search);
	 	List<Object> list = (List<Object>)map. get("list");
	 	 
	 	//����Ʈ������ 3�� ����?
	 	Assert.assertEquals(3, list.size());  
	 	System.out.println(list); ///// []
	 	
	 	Integer totalCount = (Integer)map.get("totalCount");
	 	System.out.println(totalCount); ///// []
	 	 
	 	search.setCurrentPage(1);
	 	search.setPageSize(3);
	 	search.setSearchCondition("0");
	 	search.setSearchKeyword("");
	 	map = productService.getProductList(search);
	 	
	 	list = (List<Object>)map.get("list");
	 	
	 	Assert.assertEquals(3, list.size()); 
	 	System.out.println( list.get(0) );		///// []
	 	
	 	totalCount = (Integer)map.get("totalCount");
	 	System.out.println( totalCount ); ///// []
	 	
	 }
	
	 
	
}