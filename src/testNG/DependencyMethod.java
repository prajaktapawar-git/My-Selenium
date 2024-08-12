package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyMethod {
	
	@Test(priority=1)
	void openApp()
	{
		Assert.assertTrue(false);
	}
	
	@Test(priority=2, dependsOnMethods = {"openApp"}) //Login is depends on openApp, if openApp pass then only login execute else fail.
	void login()
	{
		Assert.assertTrue(true);
	}
	
	@Test(priority=3, dependsOnMethods = {"login"})
	void search()
	{
		Assert.assertTrue(true);
	}
	
	@Test(priority=4, dependsOnMethods = {"login"})
	void adSearch()
	{
		Assert.assertTrue(true);
	}
	
	@Test(priority=5, dependsOnMethods = {"login"})
	void logout()
	{
		Assert.assertTrue(true);
	}

}
