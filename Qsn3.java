
class BankAccount{
	private int accountNumber;
	private String accountHolder;
	private double balance;
	
	BankAccount(int accountNumber,String accountHolder,double balance){
		this.accountNumber=accountNumber;
		this.accountHolder=accountHolder;
		this.balance=balance;
	}
	
	int getAccountNumber(){
		return accountNumber;
	}
	
	String getAccountHolder(){
		return accountHolder;
	}
	
	double getBalance(){
		return balance;
	}
	
	public void setBlance(double balance){
		this.balance=balance;
	}
	
	public void withdraw(double amount)throws Exception{
		if(balance>0){
			balance=balance-amount;
		}
		else{
			throw new Exception("Insufficient balance");
		}
	}
	
	public void displayDetails(){
		System.out.println(accountNumber+"\t\t"+accountHolder+"\t\t"+balance);
	}
}

class Bank{
	private BankAccount[] bankaccounts;
	private int no_of_accounts;
	
	Bank(){
		this.bankaccounts=new BankAccount[5];
		this.no_of_accounts=0;
		
	}
	
	public void addBankAccount(BankAccount bankaccount){
		if(no_of_accounts<5){
			bankaccounts[no_of_accounts++]=bankaccount;
		}
		else{
			System.out.println("No of account holders are full.");
		}
	}
	
	public void withdrawMoney(int accountNumber,double amount){
		for(int i=0;i<no_of_accounts;i++){
			if(accountNumber==bankaccounts[i].getAccountNumber() && bankaccounts[i].getBalance()>0){
				double a=bankaccounts[i].getBalance()-amount;
				bankaccounts[i].getBalance()=a;
			}
			return;
		}
		System.out.println("No account found for acc no"+accountNumber);
	}
	
	public void displayAllDetails(){
		if(no_of_accounts==0){
			System.out.println("No accounts in the bank.");
		}
		else{
			for(int i=0;i<no_of_accounts;i++){
				bankaccounts[i].displayDetails();
			}
		}
	}
}

class Main{
	public static void main(String[] args){
		Bank b1=new Bank();
		b1.addBankAccount(new BankAccount(1001,"Alice",5000.00));
		b1.addBankAccount(new BankAccount(1002,"Bob",3000.00));
		b1.displayAllDetails();
	}
}
