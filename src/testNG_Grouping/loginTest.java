package testNG_Grouping;

import org.testng.annotations.Test;

//Sanity
public class loginTest {
	
	@Test(priority=1, groups = {"sanity"})
	void loginByEmail()
	{
		System.out.println("Login by email....");
	}
	
	@Test(priority=2, groups = {"sanity"})
	void loginByFaceook()
	{
		System.out.println("Login by Facebook.....");
	}

	@Test(priority=3, groups = {"sanity"})
	void loginByTwitter()
	{
		System.out.println("Login by Twitter.....");
	}
}
