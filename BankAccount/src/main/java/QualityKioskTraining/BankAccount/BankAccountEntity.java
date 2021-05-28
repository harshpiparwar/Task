package QualityKioskTraining.BankAccount;


public abstract class BankAccountEntity {
	
	int AccountNo;
	double Balance;
	static final double InterestRate=10.00;
	
	public BankAccountEntity(int AccountNo)
	{
		
		this.AccountNo=AccountNo;
		this.Balance=0.0;	
	}
	
	
	public BankAccountEntity(int AccountNo,double Bal)
	{
		
		this.AccountNo=AccountNo;
		this.Balance=Bal;
	}
	
	public double DepositeAmount(double Amount)
	{
		Balance=Balance+Amount;
		return Balance;
	}
	
	public double WithdrawAmount(double Amount)
	{
		if(Balance<Amount)
		{
			System.out.println("Balance is less than required balance so deposite some money");
			return 0;
		}
			else if(Balance>Amount)
			{
			Balance=Balance-Amount;
			System.out.println("Your Balance After Withdrawl is: "+ Balance);
			
			}
		
		return Balance;
		
	}
	
	public double GetBalance()
	{
		return Balance;
	}
	
	
	public int GetAccountNo()
	{
		return AccountNo;
	}
	
	public void EarnInterest()
	{
		double InterestEarned=(Balance*InterestRate)/100;
		Balance=Balance+InterestEarned;

	}
	
	public abstract void closeAccount();
	
	
}

