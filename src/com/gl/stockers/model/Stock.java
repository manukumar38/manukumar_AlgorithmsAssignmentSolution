package com.gl.stockers.model;

public class Stock {
	private int companyNo;
	private double stockprice;
	private boolean stockpricestatus;

	//Returns the company number
	public int getCompanyNo() {
		return companyNo;
	}

	//Returns the stock price value of the company
	public double getStockprice() {
		return this.stockprice;
	}

	//Returns the status of stock price
	public boolean isStockPriceStatus() {
		return stockpricestatus;
	}

	//Initialize each objecgt with values of company number, stock price , stock price status
	public Stock(int companyNo, double stockprice, boolean stockpricestatus) {
		this.companyNo = companyNo;
		this.stockprice = stockprice;
		this.stockpricestatus = stockpricestatus;
	}
}