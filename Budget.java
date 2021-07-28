package application.model;

import java.io.*;
import java.util.*;

public class Budget {
	
	ArrayList<Budget> transactions = new ArrayList<Budget>();
	
	private String date, type;
	private double amount;
	private double income, Expenses, Remaining;
	
	// constructor for methods to be called
	public Budget()
	{
		
	}
	
	// constructor for saving a class object into the arraylist data structure
	public Budget(String date, String type, Double amount)
	{
		
	}
	
	/**
	 * method that reads in the data.cvs file and add a budget data into the array
	 */
	public void ReadFile()
	{
		File file = new File("data.csv");
		
		//try catch to read in the file
		try{
			Scanner scan  = new Scanner(file);
			while(scan.hasNextLine())
			{
				String line = scan.nextLine();
				String[] output = line.split(",");
				String date = date(output[0]);
				double amounts = Double.parseDouble(output[2]);
				
				//System.out.println(date + " " + output[1] + " " + (amounts + 10));
				
				transactions.add(new Budget(date, output[1], amounts));
				
				if(output[1].equalsIgnoreCase("Paycheck"))
				{
					this.income += amounts;
				}
				else
				{
					this.Expenses += amounts;
				}
				
			}
			scan.close();
			this.Remaining = income - Expenses;
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method that recieves a date parameter and sets the date into a month name
	 * day and year format from xx-xx-xxxx format
	 * @param date
	 * @return date new formated date returned
	 */
	public String date(String date) {
		
		String[] DateSplit = date.split("-");
		
		switch (DateSplit[0])
		{
		case "01":
			date = "Janurary " + DateSplit[1] + ", " + DateSplit[2];
			break;
		case "02":
			date = "Feburary " + DateSplit[1] + ", " + DateSplit[2];
			break;
		case "03":
			date = "March " + DateSplit[1] + ", " + DateSplit[2];
			break;
		case "04":
			date = "April " + DateSplit[1] + ", " + DateSplit[2];
			break;
		case "05":
			date = "May " + DateSplit[1] + ", " + DateSplit[2];
			break;
		case "06":
			date = "June " + DateSplit[1] + ", " + DateSplit[2];
			break;
		case "07":
			date = "July " + DateSplit[1] + ", " + DateSplit[2];
			break;
		case "08":
			date = "August " + DateSplit[1] + ", " + DateSplit[2];
			break;
		case "09":
			date = "September " + DateSplit[1] + ", " + DateSplit[2];
			break;
		case "10":
			date = "October " + DateSplit[1] + ", " + DateSplit[2];
			break;
		case "11":
			date = "November " + DateSplit[1] + ", " + DateSplit[2];
			break;
		case "12":
			date = "December " + DateSplit[1] + ", " + DateSplit[2];
			break;
		}
		return date;
	}
	/**
	 * to string for printing the information of the object
	 */
	public String toString()
	{
		return this.date+ " " + this.type + " " + this.amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	public double getExpenses() {
		return Expenses;
	}

	public void setExpenses(double expenses) {
		Expenses = expenses;
	}

	public double getRemaining() {
		return Remaining;
	}

	public void setRemaining(double remaining) {
		Remaining = remaining;
	}

	public ArrayList<Budget> getTransactions() {
		return transactions;
	}

	public void setTransactions(ArrayList<Budget> transactions) {
		this.transactions = transactions;
	}
	
	
}
