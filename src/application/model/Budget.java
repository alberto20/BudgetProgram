/**
 * Budget class that reads in the data.csv file and parses and saves the information
 * into a Collection arraylist and calcultes the income, Expenses, and remaining funds
 * 
 * @author adalberto Ramirez
 */
package application.model;

import java.io.*;
import java.util.*;

import application.Main;

public class Budget extends Main {
	
	// collection arraylist
	Collection<String> list = new ArrayList<String>();
	// class variables
	private String date, type;
	private double amount;
	private double income, Expenses, Remaining;
	
	/**
	 * Constructor
	 */
	public Budget()
	{
		
	}
	
	/**
	 * Constructor for creating the class object
	 * @param date
	 * @param type
	 * @param amount
	 */
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
				// saves line read into a string variable line
				String line = scan.nextLine();
				// splits the line with , delimiter and saves it into a string array
				String[] output = line.split(",");
				// passes the first string that should be the date and converts the format
				String date = date(output[0]);
				// parses the string into a double
				double amounts = Double.parseDouble(output[2]);
				
				// adds the string to the list
				list.add(date + " " + output[1] + " " + amounts);
				
				// if statment that adds to either income or expense
				if(output[1].equalsIgnoreCase("Paycheck"))
				{
					this.income += amounts;
				}
				else
				{
					this.Expenses += amounts;
				}
				
			}
			// closes the read file scanner
			scan.close();
			//sets remaining variable with any income left not used for expenses
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
		
		// splits the input string from the - delimiter
		String[] DateSplit = date.split("-");
		
		// switch cases that determines the month name from the first numbers
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
		return this.date + " " + this.type + " " + this.amount;
	}
	/**
	 * Getter that returns the date
	 * @return date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Setter for date that sets date
	 * @param date
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * Getter for type string
	 * @return type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Seter for type
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Getter for amount variable
	 * @return amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * Setter for the amount 
	 * @param amount
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	/**
	 * Getter for income varable
	 * @return income
	 */
	public double getIncome() {
		return income;
	}

	/** 
	 * Setter for income
	 * @param income
	 */
	public void setIncome(double income) {
		this.income = income;
	}

	/**
	 * getter for exepenses
	 * @return Expenses
	 */
	public double getExpenses() {
		return Expenses;
	}

	/**
	 * Setter for Expenses
	 * @param expenses
	 */
	public void setExpenses(double expenses) {
		Expenses = expenses;
	}

	/**
	 * Getter for remaining
	 * @return Remaining
	 */
	public double getRemaining() {
		return Remaining;
	}

	/**
	 * setter for remaining
	 * @param remaining
	 */
	public void setRemaining(double remaining) {
		Remaining = remaining;
	}

	/**
	 * Getter for collection<string> list
	 * @return list
	 */
	public Collection<String> getList() {
		return list;
	}

	/**
	 * Setter list for collection<String> list
	 * @param list
	 */
	public void setList(Collection<String> list) {
		this.list = list;
	}
	
}
