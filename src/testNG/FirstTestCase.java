package testNG;

import org.testng.annotations.Test;

public class FirstTestCase {
	
	//open app
	//login
	//logout
	@Test(priority=1)
	void apple()
	{
		System.out.println("Opening Application");
		
	}
	
	@Test(priority=2)
	void Login()
	{
		System.out.println("Login");
	}
	
	@Test(priority=3)
	void Logout()
	{
		System.out.println("Logout");
		
	}
	
	

}
