package testNG_Grouping;

import org.testng.annotations.Test;

//Regression
public class SignUpTest {
	
	@Test(priority=1, groups = {"regression"})
	void signUpByEmail()
	{
		System.out.println("This is signUpByEmail....");
	}
	
	@Test(priority=2, groups = {"regression"})
	void signUpByFacebook()
	{
		System.out.println("This is signUpByFacebook....");
	}

	@Test(priority=3, groups = {"regression"})
	void signUpByTwitter()
	{
		System.out.println("This is signUpByTwitter....");
	}
}
