package QualityKioskTraining.BankAccount;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestingForSavingsAccount {
	SavingsAccount savAct;
	double Result;
	
	@BeforeClass
	public void Init()
	{
		System.out.println("I am in Before Class");
		savAct=new SavingsAccount(100);
	}
	
	@BeforeMethod
	public void ReinitialisedResult()
	{
		System.out.println("I am in Before Method");
		Result=0;
	}
	
	@AfterClass
	public void teardown()
	{
		System.out.println("I am in After Class");
	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("I am in After Method");
	}
	
	@BeforeGroups("RegressionTest")
	public void InitBeforeGroup() {
		System.out.println("I am in the Before group For Regression Test");
		savAct=new SavingsAccount(100);
	}
	
	@BeforeGroups("SmokeTest")
	public void InitBeforeSmoke() {
		System.out.println("I am in the Before group For Smoke Test");
		savAct=new SavingsAccount(100);
	}
	
	
	@Test(priority=1)
	public void testForDepositeFunction()
	{
		Result=savAct.DepositeAmount(3000);
		Assert.assertEquals(Result, 3000);
		System.out.println("Account Balance is:"+ Result);
		
	}
	
	@Test(priority=2)
	public void withdrawalFunctionTest()
	{
		System.out.println("Test 2");
		Result=savAct.WithdrawAmount(500);
		Assert.assertEquals(Result, 2500);
		
	}
	
	@Test(priority=3)
	public void withdrawalFunctionWithValueGreaterThanBalance()
	{
		System.out.println("Test 3");
		Result=savAct.WithdrawAmount(1200);
		Assert.assertEquals(Result, 1300);
		
	}
	
	@Test(priority=4)
	public void getBalance()
	{
	
		Result=savAct.GetBalance();
		Assert.assertEquals(Result, 1300);
		System.out.println("Updated Balance is: "+ Result);
	}
	
	@Test(priority=5,groups = { "Regression Test" })
	public void TestForRegression() 
	{
		System.out.println("I am doing test for regression");
		Assert.assertEquals(Result,0);
	}
	
	@Test(priority=6,groups = { "Smoke Test" })
	public void TestForSmoke() 
	{
		System.out.println("I am doing test for smoke");
		Assert.assertEquals(Result,0);
	}
	



}
