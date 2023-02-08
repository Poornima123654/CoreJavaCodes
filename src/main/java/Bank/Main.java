package Bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
	
	static Account acc;
    static Scanner sc; 

	static
	{
		acc = new Account();
		sc = new Scanner(System.in);
	}
	
   static List<Account> L = new ArrayList<Account>();
   
	static void addAccount()
	{
		System.out.println("------Open Account------");
		
		System.out.println("Enter name");
		String name = sc.next();
		
		System.out.println("Enter amount");
		int amt = sc.nextInt();
		
		Account acc = new Account(name,amt);
		
		L.add(acc);
		
		System.out.println("Account opened successfuly...!!!");
	}
	
	 static void Deposit()
	{
		int amt,accno;
		String name;
		boolean found;
		
		System.out.println("-----------Account Deposit-----------");
		
		found = false;
		
		System.out.println("Enter Account number:");
		accno = sc.nextInt();
		
		for(Account ac: L)
		{
			if(accno == ac.getAccno())
			{
				found = true;
				
				System.out.println("Customer Name:"+ ac.getName());
				System.out.println("Customer Balance:"+ ac.getBal());
				
				System.out.println("\n Enter amount to deposit");
				amt = sc.nextInt();
				
				ac.setBal(ac.getBal()+amt);
				System.out.println("Deposit success......!!!!");
			}
		}
		if(!found)
		{
			System.out.println("Invalid Account Number......!!!!");
		}
	}
	
	static void Withdraw()
	{
		int amt,accno;
		String name;
		boolean found;
		
		System.out.println("---------Account Withdraw--------");
		
		found = false;
		
		System.out.println("Enter Account number");
		accno = sc.nextInt();
		
		for(Account ac: L)
		{
			if(accno == ac.getAccno())
			{
				found = true;
				
				System.out.println("Customer Name:"+ ac.getName());
				System.out.println("Customer Balance:"+ ac.getBal());
				
				System.out.println("\n Enter amount to withdraw");
				amt = sc.nextInt();
				
				if(amt<=ac.getBal())
				{
					ac.setBal(ac.getBal() - amt);
					System.out.println("Withdraw success.....!!");
				}
				else
				{
					System.out.println("Insufficient Balance.......!!");
				}
			}
		}
		if(!found)
		{
			System.out.println("Invalid Account Number.........");
		}
	}
	
	static void display()
	{
		L.forEach((m) -> { 
		
		System.out.printf("%-15d %-15s %-15d\n",m.getAccno(),m.getName(),m.getBal());
		
		});
		
	}
	
	static void search(int accno)
	{
		 acc =  L.stream().filter((m)->
		
						m.getAccno()== accno					
																 
						 ).findAny().orElse(null);
					
		System.out.println(acc);
		
	}
	
	static void delete()
	{	
		System.out.println("\nEnter Account Number to delete: ");
		int accno = sc.nextInt();
		search(accno);
		
		L.remove(acc);
	
		System.out.println("\nRecord is Deleted.....!!!!");														
	}
	
	static void update()
	{
		System.out.println("\nEnter Account Number: ");
		int accno = sc.nextInt();
		search(accno);
		
		System.out.println("\nEnter new Name for updating: ");
		String name1 = sc.next();
		
		/*System.out.println("\nEnter Account Number you want to update: ");
		int accno1 = sc.nextInt();*/
		
		L.forEach((m) -> {
							if(m.getAccno() == accno)
							{
								m.name = name1;
								//m.accno = accno1;
							}									
						});												
	}
	
	static void checkBalance()
	{
		boolean found;
		System.out.println("------------Account Balance Enquiry-----------");
		found = false;
		System.out.println("Enter Account number:");
		int accno = sc.nextInt();
		for(Account ac: L)
		{
			if(accno == ac.getAccno())
			{
				found = true;
				System.out.println("Account Holder Name:"+ ac.getName());
				System.out.println("Account Balance:"+ ac.getBal());
				break;
			}
		}	
		if(!found)
		{
			System.out.println("Invalid account number...!!!");
		}

	}
	public static void main(String... args)
	{
		ArrayList<Account> L = new ArrayList<Account>();
		
		String username, password;
		
		System.out.print("Enter Username:");
		username = sc.nextLine();
		
		System.out.print("Enter Password:");
		password = sc.nextLine();
		
		if(username.equals("admin") && password.equals("1234"))
		{
			System.out.println("................Authentication successful..............");
		}
		else
		{
			System.out.println("................Authentication Failed..............");
		}
		
		System.out.println("***************************************************");
		
		int ch;	
		String ans="";
		
		while(true)
		{
			Scanner sc = new Scanner(System.in);
			
			System.out.println("\t\t• Main Menu\n \t\t1:Add Account");
			System.out.println("\t\t2:Deposit\n\t\t3:Withdraw");
			System.out.println("\t\t4:display\n\t\t5:serach\n\t\t6:delete\n\t\t7:update\n\t\t8:checkBalance\n\t\t9:Exit\n");
			System.out.println("\t Enter your choice : ");
			ch = sc.nextInt();
			
			Main m = new Main();
			switch(ch)
			{
				case 1: addAccount();
				        break;
				case 2: Deposit();
				        break;
				case 3: Withdraw();
				        break;
				case 4: display();
				  		break;
				case 5: System.out.println("\nEnter Account Number to search: ");
				        int accno = sc.nextInt();
				        search(accno);
				        break;
				case 6: delete();
				        break;
				case 7: update();
				        break;
				case 8: checkBalance();
				        break;
				case 9: System.out.println("------Thank you------");
		        		System.exit(0);
				default: System.out.println("Invalid choice...!!!");
	        }
				System.out.println("\n\n\t Do  you want to continue [Y/N] : ");
				ans = sc.next();
				if(ans.equals("N") || ans.equals("n"))
						{
							try {
									Thread.sleep(1500);}catch(Exception e) {}
							System.out.println("Exit From a System ! ");
							System.exit(0);
						}
		    }
	     }
	}
