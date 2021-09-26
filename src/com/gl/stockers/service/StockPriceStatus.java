package com.gl.stockers.service;

import java.util.ArrayList;
import java.util.Iterator;
import com.gl.stockers.model.Stock;

public class StockPriceStatus {
	/*
	 * Method to check for the number of companies whose stock price is rose or
	 * declined. It gets the array list of stocks as an argument from Driver class
	 */
	public int[] findStockPriceRoseToday(ArrayList<Stock> stocks) {
		// Iterator is used to iterate the array list
		Iterator<Stock> itr = stocks.iterator();
		// Storing true and false count in an array
		int count[] = new int[2];
		/*
		 * Loop checks for each company's stock status value and increase the count
		 * array value based on true or false
		 */
		while (itr.hasNext()) {
			Stock st = (Stock) itr.next();
			/*
			 * If true then storing it as counter array's first value and increment it for
			 * each company
			 */
			if (st.isStockPriceStatus() == true) {
				count[0]++;
				/*
				 * If false then storing it as counter array's second value and increment it for
				 * each company
				 */
			} else if (st.isStockPriceStatus() == false) {
				count[1]++;
			}
		}
		;
		// returns the count array to Driver class
		return count;
	}
}