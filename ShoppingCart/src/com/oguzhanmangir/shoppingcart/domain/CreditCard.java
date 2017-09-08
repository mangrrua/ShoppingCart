package com.oguzhanmangir.shoppingcart.domain;

import java.math.BigDecimal;


public class CreditCard implements IPayment{
	
	private String customerName;
	private String cardNumber;
	private int month;
	private int year;
	private String cvv;
	private String type;
	private BigDecimal amount;
	
	public CreditCard() { }
	
	public CreditCard(String customerName, String cardNumber, int month, int year, String cvv,
			String type) {
		this.customerName = customerName;
		this.cardNumber = cardNumber;
		this.month = month;
		this.year = year;
		this.cvv = cvv;
		this.type = type;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Override
	public BigDecimal getAmount() {
		return null;
	}

	@Override
	public String toString() {
		return "Payment [customerName=" + customerName + ", cardNumber="
				+ cardNumber + ", month=" + month + ", year=" + year + ", cvv=" + cvv + ", type=" + type + ", amount="
				+ amount + "]";
	}
}
