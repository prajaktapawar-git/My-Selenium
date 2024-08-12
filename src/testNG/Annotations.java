package testNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Annotations {
	
	@BeforeMethod
	void Login()
	{
		System.out.println("Login");
	}
	
	@Test
	void Search()
	{
		System.out.println("Serach");
	}

	@Test (priority=1)
	void AdvSerach()
	{
		System.out.println("Adv Search");
	}
	
	@AfterMethod
	void Logout()
	{
		System.out.println("Logout");
	}
}
