package AccountSystem;
import AccountSystemExceptions.InsufficientBalanceException;
public abstract class Account
{
	private int AccountNo;
	protected double Balance;
	static final double InterestRate=10.00;	
	public Account(int ActNo)
	{
		AccountNo=ActNo;
		Balance=0.0;	
	}

	public Account(int AccountNo,double Bal)
	{
		this.AccountNo=AccountNo;
		Balance=Bal;
	}
	
	public void DepositeAmount(double Amount)
	{
		Balance=Balance+Amount;
	}
	public double GetBalance()
	{
		return Balance;
	}

	public void WithdrawAmount(double Amount)throws InsufficientBalanceException
	{
	
		/*
		if(Balance>=Amount)
			Balance=Balance-Amount;
		else
		{
			System.out.println("Sorry..You do not have sufficient balance");
		}
		*/
		if(Balance<Amount)
			throw new InsufficientBalanceException();
		Balance=Balance-Amount;
	}
	
	public int Get_AccountNo()
	{
		return AccountNo;
	}

	public void EarnInterest()
	{
		double InterestEarned=(Balance*InterestRate)/100;
		Balance=Balance+InterestEarned;

	}

	public final void CloseAccount()
	{
		System.out.println("Submit the application.");
		System.out.println("Withdraw the whole balance.");
		System.out.println("Closing of an account may take 2 working days");
	}

	public abstract void OpenAccount();

}