import javax.swing.plaf.synth.SynthOptionPaneUI;
import java .sql.SQLOutput;
import java.util.*;
class BankAccount{
	static void registerUser(){
		Scanner sc=new Scanner(System.in);
		System.out.println(" ENTER THE ACCOUNT HOLDER NAME :- ");
		ATM.name = sc.nextLine();
		System.out.println(" ENTER THE ACCOUNT NUMBER :-  ");
		String accountnumber=sc.nextLine(); 
		System.out.println(" ENTER THE PIN :-");
		String pin=sc.nextLine();
		System.out.println(" REGISTRATION COMPLETED ");
		System.out.println("************************************** ");
		ATM.popup();
		while(true){
			display(ATM.name);
			int choice=sc.nextInt();
			if(choice==1){
				login(accountnumber,pin);
				break;
			}
			else{
				if(choice==2)
				{
					System.exit(0);
				}
				else 
				{
					System.out.println("SORRY!! YOU HAVE ENTERED WRONG NUMBER" +" ENTER AGAIN TO CONTINUE ");
				}
			}
		}
	}

static void display(String name){}
static void login(String accountnumber,String pin){}
}
class Transaction{
	static void withdraw(){
	 Scanner sc=new Scanner(System.in);
	 System.out.println("ENTER THE AMOUNT TO WITHDRAW :- ");
	 int w_cash=sc.nextInt();
	 if(w_cash<ATM.balance){
	 	ATM.balance=ATM.balance-w_cash;
	 	ATM.history.add(Integer.toString(w_cash) );
	 	ATM.history.add("WITHDRAW");
	 	System.out.println("WITHDRAW OF "+ w_cash +" AMOUNT IS  SUCCESSFULL ");
	 	System.out.println("PLEASE COLLECT YOUR MONEY");
	 	System.out.println("**********************************************************");
	 }
   else 
   {
   	System.out.println("SORRY!! INSUFFICIENT BALANCE");
   	System.out.println("***********************************************************");
   }
   ATM.popup();
	}
	static void deposit(){
		Scanner sc=new Scanner(System.in);
		System.out.println("ENTER THE AMOUNT TO DEPOSIT ");
	  int d_amt=sc.nextInt();
	  ATM.updatebalance(d_amt);
	  ATM.history.add(Integer.toString(d_amt));
	  ATM.history.add("DEPOSIT");
	  System.out.println(d_amt + " RUPEES IS DEPOSITED SUCCESSFULLY " );
	  System.out.println("****************************************************************");
	  ATM.popup();

	}
static void transfer(){
	Scanner sc=new Scanner(System.in);
	System.out.println("ENTER THE RECIVER NAME");
	String t_name=sc.nextLine();
	System.out.println("ENTER THE RECIVER ACCOUNT NUMBER");
	int t_acc_no=sc.nextInt();
	System.out.println("ENTER THE AMOUNT TO TRANSFER");
	int  t_amt=sc.nextInt();
	if(t_amt < ATM.balance){
		ATM.balance-=t_amt;
		ATM.history.add(Integer.toString(t_amt));
		ATM.history.add("TRANSFERED TO "+t_name);
		System.out.println(" AMOUNT OF  "   +  t_amt   + "   IS TRANSFERED SUCCESSFULLY TO  "  + t_name );
		System.out.println("***************************************************************");
	}
	else 
	{
		System.out.println("SORRY!! INSUFFICIENT BALANCE");
		System.out.println("****************************************************************");
	}
 ATM.popup();
 }
}
class check_balance{
	static void checkbalance(){
		System.out.println("***************************************************************");
		System.out.println("AVAILABLE BALANCE IS = ");
		ATM.showbalance();
		System.out.println("****************************************************************");
		ATM.popup();
	}
}
class view{
static void transaction_history(){
	System.out.println("******************************************************************");
	System.out.println("TRANSACTION HISTORY");
	int k=0;
	if(ATM.balance>0){
		for(int i=0;i<(ATM.history.size()/2);i++)
		{
			for(int j=0;j<2;j++)
			{
				System.out.println(ATM.history.get(k)+"");
				k++;
			}
			System.out.println("**************************************************************");
		}
	}
	else 
	{
		System.out.println("AVAILABLE BALANCE IS 0.00 RUPEES");
	}

	ATM.popup();
 }
}
public class ATM{
	public static String name;
	public static int balance=0;
	public static String accountnumber;
	public static ArrayList<String>history=new ArrayList<String>();


	static void updatebalance(int d_amt){balance+=d_amt;}
	static void showbalance(){System.out.println(balance);}
	public static void home(){
		Scanner sc=new Scanner(System.in);
		System.out.println("WELCOME TO SBI ATM SERVICE");
		System.out.println("*********************************************************************");
		System.out.println("SELECT THE OPTION TO CONTINUE \n 1 TO REGISTER \n 2 TO EXIT ");
		int choice=sc.nextInt();
		if(choice==1)
		{
			BankAccount.registerUser();
		}
		else 
		{
			if(choice==2)
			{
				System.exit(0);
			}
			else 
			{
				System.out.println("SELECT THE VALID OPTION ONLY");
				home();
			}
		}
		
}
static void popup(){
	Scanner sc=new Scanner(System.in);
	System.out.println("WELCOME    " +    ATM.name +" !! " );
	System.out.println("*****************************************************************");
	System.out.println("  SELECT THE OPTION TO CONTINUE");
	System.out.println("  ENTER 1. TO WITHDRAW ");
  System.out.println("  ENTER 2. TO DEPOSIT");
  System.out.println("  ENTER 3. TO TRANSFER");
  System.out.println("  ENTER 4. TO CHECK BALANCE");
  System.out.println("  ENTER 5. TO CHECK TRANSACTION HISTORY");
  System.out.println("  ENTER 6. TO EXIT ");
  System.out.println("  ENTER YOUR CHOICE :- ");
  int choice=sc.nextInt();
  switch(choice)
  {
  case(1):
  	Transaction.withdraw();
  	break;
  case(2):
  	Transaction.deposit();
  	break;
  case(3):
  	Transaction.transfer();
  	break;
  case(4):
  	check_balance.checkbalance();
  	break;
  case(5):
  	view.transaction_history();
  	break;
  case(6):
  	{
  	 System.out.println("THANK YOU!! VISIT AGAIN");
  	System.exit(0);

  	}
  }
}
public static void main(String[]args){
	home();
  }
}