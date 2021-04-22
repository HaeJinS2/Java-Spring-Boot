package manager;

public class BasicSalesRatio implements SalesRatio{
	
	   // To-do  일반 회원인 경우 5만원 이하는 0%, 
	   //5만원에서 10만원 이하는 5%, 
	   //10만원에서 20만원 이하는 10% 20만원 초과는 20% 할인해줍니다.
	
	public double getSalesRatio(double price) {
		
	      double discount = 0;
	      
	      if(price <= 50000) 
	         discount =0;
	      
	      else if(price <= 100000) 
	         discount = 5;
	      
	      else if(price <= 200000) 
	         discount = 10;
	      
	      else if(price > 200000) 
	         discount = 20;
	      
	      return discount;
	   }

	}
