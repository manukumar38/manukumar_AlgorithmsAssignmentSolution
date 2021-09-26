
package com.gl.stockers;

import com.gl.stockers.service.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;

import com.gl.stockers.model.*;

public class Driver {

	public static void main(String[] args) throws InputMismatchException {
		// TODO Auto-generated method stub
		// Get the user input for number of companies
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter the number of companies");
			int num_of_companies = sc.nextInt();
			// create Arraylist to store the set of objects of stock companies with its
			// corresponding values
			ArrayList<Stock> stocks = new ArrayList<Stock>();
			double stockPriceToday[] = new double[num_of_companies];
			// Get the stock price and true/false stock value for today compared to
			// yesterday for each company
			for (int i = 1; i <= num_of_companies; i++) {
				System.out.println("Please enter the Stock Price  of the company " + i);
				double stockprice = sc.nextDouble();
				System.out.println("Whether the current stock price rose today compared to yesterday :");
				boolean stockpricestatus = sc.nextBoolean();
				/*
				 * Initializing each stock object with company number,stock price of the
				 * company,status of stock value using parameterized constructor and adding all
				 * the objects in to the array list stocks
				 */
				stocks.add(new Stock(i, stockprice, stockpricestatus));
			}
			/*
			 * Getting stock price for all the companies using Stock class in the model
			 * package and storing it in an array stockPriceToday for sorting and searching
			 */
			for (int i = 0; i < num_of_companies; i++) {
				stockPriceToday[i] = stocks.get(i).getStockprice();
			}
			int option;
			// Create do while for atleast once user should get these options a
			do {
				System.out.println();
				System.out.println("----------------------------------------------------------------------------");
				System.out.println("Enter the operation you want to perform");
				System.out.println("1. Display the companies stock prices in ascending order");
				System.out.println("2. Display the companies stock prices in descending order");
				System.out.println("3. Display the total number of companies for which stock prices rose today");
				System.out.println("4. Display the total number of companies for which stock prices declined today");
				System.out.println("5. Search a specific stock price");
				System.out.println("6. Press 0 to exit");
				System.out.println("----------------------------------------------------------------------------");
				// Getting the user input for choosing the option and storing it in a variable
				// option
				option = sc.nextInt();
				/*
				 * Creating a object for StockPriceStatus to call the method which can check
				 * whether stock price rose or declined today compared to yesterday
				 */
				StockPriceStatus st = new StockPriceStatus();
				SortStockPrice ms = new SortStockPrice();
				// Count array used to store number of companies whose stock values is rose and
				// decline
				int count[] = st.findStockPriceRoseToday(stocks);
				// Storing the returned sorted values of stock price using merge sort in an
				// array variable
				double array[] = ms.implementationOfMergeSort(stockPriceToday);
				// Based on the option received from user, operation is being performed
				switch (option) {
				case 0:
					option = 0;
					break;
				case 1: {
					System.out.print("Stock prices in ascending order are : ");
					// Displaying the array of sorted values in ascending order
					for (int i = 0; i < array.length; i++) {
						System.out.print(array[i]);
						System.out.print("  ");
					}
					break;
				}
				case 2: {
					System.out.print("Stock prices in Descending order are : ");
					// Reversing the array to show the values in descending order
					for (int i = array.length - 1; i >= 0; i--) {
						System.out.print(array[i]);
						System.out.print("  ");
					}
					break;
				}
				// To show number of companies whose stock price rose
				case 3: {
					System.out.println("Total number of companies whose stock prices rose today");
					System.out.println(count[0]);
					break;
				}
				// To show number of companies whose stock price rose
				case 4: {
					System.out.println("Total number of companies whose stock prices declined today");
					System.out.println(count[1]);
					break;
				}
				/*
				 * To search specific stock price using binary search, call a method from
				 * SearchStockPrice class using an object
				 */
				case 5: {
					System.out.println("Search a specific stock price");
					double value = sc.nextDouble();
					SearchStockPrice ssp = new SearchStockPrice();
					ssp.implementationOfBinarySearch(array, value);
					break;
				}
				default:
					break;
				}
			} while (option != 0);
			System.out.println("Exited successfully");
			sc.close();

		}
		//Handle the exception for the user input 
		catch (InputMismatchException ex) {
			System.out.println("Please provide the right input value " + ex);
			return;
		}
	}
}