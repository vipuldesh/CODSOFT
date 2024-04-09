package com.supre.Task4_CurrencyConverter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;


public class CurrencyConverter 
{
	private static final String BASEURL = "http://api.currencylayer.com/live";
	private static final String APIKEY = "c08df48d809442512150ac1bbde99784";
	
	public static void main(String[] args)
	{
		
		try {
			//Get User Input
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.print("Enter the source currency code: ");
			String sourceCurrency = reader.readLine().toUpperCase();
			
			System.out.print("Enter the target currency code: ");
			String targetCurrency = reader.readLine().toUpperCase();
			
			System.out.print("Enter the amount to convert: ");
			double amount = Double.parseDouble(reader.readLine());
			
			JSONObject exchangeRates = getExchangeRates(sourceCurrency);
			
			/*
			// Print the full JSON data in a printed format
			System.out.println("Full JSON Data:");
			System.out.println(exchangeRates.toString(4)); // 4 spaces for indentation
			*/
			
			System.out.println("\nLive Currency Conversion using Live Excahnge Rates: ");
			
			JSONObject jsonObject = exchangeRates.getJSONObject("quotes");
			
			String currencyPairKey = sourceCurrency + targetCurrency;
			
			if(jsonObject.has(currencyPairKey))
			{
				double rate = jsonObject.getDouble(currencyPairKey);
				
				double convertedAmount = amount * rate;
				
				System.out.println(amount + " " + sourceCurrency + " is equal to " + convertedAmount + " " + targetCurrency);
			}else {
				System.out.println("Currency Pair " + sourceCurrency + targetCurrency + " not found in the API Data." );
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	//Business method to get Exchange Rates using source currency from CurrencyLayer API
	private static JSONObject getExchangeRates(String sourceCurrency) throws IOException
	{
		URL url = new URL(BASEURL + "?access_key=" + APIKEY + "&source=" + sourceCurrency);
		HttpURLConnection con = (HttpURLConnection)url.openConnection();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
		try(reader)
		{
			StringBuilder res = new StringBuilder();
			String line;
			while((line = reader.readLine()) != null)
			{
				res.append(line);
			}
			return new JSONObject(res.toString());
		}finally {
			con.disconnect();
		}
	}
	

	
}
