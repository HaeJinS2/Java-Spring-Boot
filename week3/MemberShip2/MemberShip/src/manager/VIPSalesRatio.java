package manager;

public class VIPSalesRatio implements SalesRatio {
	
	   //To-do VIP 회원의 경우 5만원 이하는 0%, 
	   //5만원에서 10만원 이하는 10%, 10만원에서 20만원 이하는 20%, 
	   //20만원 이상은 30%를 할인해 줍니다. 

	public double getSalesRatio(double price) { 
		
	      double discount = 0;
	      
	      if(price <= 50000) 
	         discount =0;
	      
	      else if(price <= 100000) 
	         discount = 10;
	      
	      else if(price <= 200000) 
	         discount = 20;
	      
	      else if(price > 200000) 
	         discount = 30;
	      
	      return discount;
	   }
	   
	}

