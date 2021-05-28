package QualityKioskTraining.BankAccount;

public class SalaryAccount extends BankAccountEntity{

	public SalaryAccount(int AccountNo, double Bal) {
		super(AccountNo, Bal);
		
	}
	
	public SalaryAccount(int AccountNo) {
		super(AccountNo);
		
	}

	@Override
	public void closeAccount() {
		System.out.println("Thanks For being with us");
		System.out.println("Please withdraw all amount");
		System.out.println("Account closing will take 3 Days");
		
	}


}
