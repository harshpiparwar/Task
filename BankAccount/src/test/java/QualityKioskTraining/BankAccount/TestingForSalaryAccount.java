package QualityKioskTraining.BankAccount;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestingForSalaryAccount {
	SalaryAccount salAct;
	double Result;
	
	@BeforeClass
	public void Init()
	{
		System.out.println("I am in Before Class");
		salAct=new SalaryAccount(200);
	}
	
	@BeforeMethod
	public void ReinitialisedResult()
	{
		System.out.println("I am in Before Method");
		Result=0;
	}
	
	
	
	@Test(priority=1,dataProvider="provideDepositeAmount")
	public void testDepositeFunctionWithDataProvider(double amount,double expectedResult)
	{
		System.out.println("Data provider for deposite 0f money");
		Result=salAct.DepositeAmount(amount);
		Assert.assertEquals(Result, expectedResult,"Deposite function does not work");
	}
	
	@DataProvider
	public Object[][] provideDepositeAmount()
	{
		
		Object[][] setOfValues=new Object[2][2];
		
		setOfValues[0][0]=1000;//Deposit amount
		setOfValues[0][1]=1000;
		
		setOfValues[1][0]=2000;
		setOfValues[1][1]=3000;//total amount
		
		return setOfValues;
	}
	
	
	@Test(priority=2,dataProvider="provideWithdrawAmount")
	public void testWithdrawFunctionWithDataProvider(double amount,double expectedResult)
	{
		System.out.println("Data provider for withdraw of money");
		Result=salAct.WithdrawAmount(amount);
		Assert.assertEquals(Result, expectedResult,"Withdraw function does not work");
	}

	@DataProvider
	public Object[][] provideWithdrawAmount()
	{
		
		Object[][] setOfValues=new Object[2][2];
		
		setOfValues[0][0]=1000;//withdraw amount
		setOfValues[0][1]=2000;//updated balance
		
		setOfValues[1][0]=500;
		setOfValues[1][1]=1500;
		
		return setOfValues;
	}
	
	@BeforeSuite
	@Parameters({ "RequestID" })
	public void createResultFolder(String resultDirName) {
		System.out.println("I am in the Before suite");
		try {
			Files.createDirectories(Paths.get(".\\" + resultDirName));
		} catch (IOException e) {
			System.out.println("Problem while creating directory");
		}
	}

	@AfterSuite
	@Parameters({ "RequestID" })
	public void copyResultFile(String resultDirName) {
		System.out.println("I am in the After suite");
		try {
			Files.copy(Paths.get(
					"C:\\Users\\ASUS\\eclipse-workspace\\BankAccount\\test-output\\emailable-report.html"),
					Paths.get(".\\" + resultDirName + "\\Result.html"), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			System.out.println("Problem while copying File");
		}
	}
	
}
