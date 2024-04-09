package com.supre.Task3_ATM_Interface;

import java.util.ArrayList;

public class UserData {
	
	private static ArrayList<UserDetails> usersList  = new ArrayList<>();
	
	public static ArrayList<UserDetails> getUserDataBase()
	{
		UserDetails user1 = new UserDetails("Supreeth Aerra",1000.87);
		usersList.add(user1);
		UserDetails user2 = new UserDetails("Surya",500000.87);
		usersList.add(user2);
		UserDetails user3 = new UserDetails("Shravan Kumar",12000000.87);
		usersList.add(user3);
		UserDetails user4 = new UserDetails("Swapna",100000.87);
		usersList.add(user4);
		
		return usersList;
	}
}
