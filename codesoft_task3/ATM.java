package com.supre.Task3_ATM_Interface;

import java.util.ArrayList;
import java.util.Scanner;

public class ATM 
{
	static ArrayList<UserDetails> userList = UserData.getUserDataBase();

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Welcome To The ATM");
		
		boolean isValidAccount = false;
		System.out.println("\nEnter your AccNumber: ");
		int accNumber =Integer.parseInt(scan.nextLine());
		
		for(UserDetails user : userList)
		{
			if(accNumber == user.getAccNumber())
			{
				System.out.println("Enter your UserName: ");
				String userName = scan.nextLine();
				if(userName.equalsIgnoreCase(user.getUserName()))
				{
					isValidAccount = true;
				}
				else
				{
					System.err.println("Invalid UserName...Please Restart again...");
					break;
				}
			}
		}//end of for loop	
		
		if(!isValidAccount)
			System.out.println("Invalid Account Number...Please Restart again...");
		
		while(isValidAccount)
		{
			System.out.println("\n1.Main Menu"
				+ "\n2.Withdraw"
				+ "\n3.Deposit"
				+ "\n4.CheckBalance"
				+ "\n5.Exit"
				+ "\n\nEnter your option: ");
			switch(Integer.parseInt(scan.nextLine()))
			{
			case 1:
				break;
			case 2:
				System.out.println("Enter the amount to withdraw:");
				double amount =Double.parseDouble(scan.nextLine());
				withdraw(accNumber,amount);
				break;
			case 3:
				System.out.println("Enter the amount to deposit:");
				amount =Double.parseDouble(scan.nextLine());
				deposit(accNumber,amount);
				break;
			case 4:
				checkBalance(accNumber);
				break;
			case 5:
				System.out.println("Thank you using the ATM......Visit again...");
				System.exit(0);
			default:
				System.err.println("Invalid option...Please select the Valid option");
			}//end of switch
		}//end of while
		
		
		//close the Scanner 
		scan.close();
	}
	
	
	//business method for withdraw operation
	public static void withdraw(int accNumber,double amount)
	{
		for(UserDetails user : userList)
		{
			if(accNumber == user.getAccNumber())
			{
				if(user.getAccBalance() > amount)
				{
					user.setAccBalance(user.getAccBalance() - amount);
					System.out.println("Withdraw of amount (Rs."+amount+") Successfully...");
				}
				else
					System.err.println("Insufficient Balance to withdraw in Your Account");
			}
		}
	}
	
	
	//business method for deposit operation
	public static void deposit(int accNumber,double amount)
	{
		for(UserDetails user : userList)
		{
			if(accNumber == user.getAccNumber())
			{
				if(amount > 0)
				{
					user.setAccBalance(user.getAccBalance()+amount);
					System.out.println("Deposit Successful....New Balance: Rs."+user.getAccBalance());
				}
				else
				{
					System.err.println("Invalid amount...Please enter the positive amount.");
				}
			}
		}//end of for
	}
	
	//business method for check Balance operation
	public static void checkBalance(int accNumber)
	{
		for(UserDetails user : userList)
		{
			if(accNumber == user.getAccNumber())
			{
				System.out.println("Current Balance: Rs."+user.getAccBalance());
			}
		}
		
	}
	
	
}
