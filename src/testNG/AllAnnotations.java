package testNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AllAnnotations {
	
	@BeforeSuite
	void a()
	{
		System.out.println("This is Beforesuite");
	}
	@AfterSuite
	void b()
	{
		System.out.println("This is Aftersuite");
	}

	@BeforeClass
	void c()
	{
		System.out.println("This is BeforeClass");
	}
	@AfterClass
	void d()
	{
		System.out.println("This is AfterClass");
	}
	
	@BeforeTest
	void e()
	{
		System.out.println("This is BeforeTest");
	}
	@AfterTest
	void f()
	{
		System.out.println("This is AfterTest");
	}
	
	@BeforeMethod
	void g()
	{
		System.out.println("This is BeforeMethod");
	}
	@AfterMethod
	void h()
	{
		System.out.println("This is AfterMethod");
	}
	
	@Test (priority=1)
	void test1()
	{
		System.out.println("This is test1");
	}
	@Test (priority=2)
	void test2()
	{
		System.out.println("This is test2");
	}
}
