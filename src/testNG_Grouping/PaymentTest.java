package testNG_Grouping;

import org.testng.annotations.Test;

//Sanity & Regression (Functional) 
public class PaymentTest {
	
	@Test(priority=1, groups= {"sanity", "regression"})
	void paymentInRupees()
	{
		System.out.println("Payment in Rupees....");
	}
	
	@Test(priority=2, groups= {"sanity", "regression"})
	void paymentInDollers()
	{
		System.out.println("Payment in Dollers....");
	}

}
