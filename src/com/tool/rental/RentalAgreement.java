package com.tool.rental;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class RentalAgreement {

	private String toolCode;
	private String toolType;
	private String toolBrand;
	private int rentalDays;
	private LocalDate checkoutDate;
	private LocalDate dueDate;
	private double dailyRentalCharge;
	private int chargeDays;
	private double preDiscountCharge;
	private int discountPercent;
	private double discountAmount;
	private double finalCharge;

	private RentalAgreement(RentalAgreementBuilder builder) {
		this.toolCode = builder.toolCode;
		this.toolType = builder.toolType;
		this.toolBrand = builder.toolBrand;
		this.rentalDays = builder.rentalDays;
		this.checkoutDate = builder.checkoutDate;
		this.dueDate = builder.dueDate;
		this.dailyRentalCharge = builder.dailyRentalCharge;
		this.chargeDays = builder.chargeDays;
		this.preDiscountCharge = builder.preDiscountCharge;
		this.discountPercent = builder.discountPercent;
		this.discountAmount = builder.discountAmount;
		this.finalCharge = builder.finalCharge;
	}

	public static class RentalAgreementBuilder {
		private String toolCode;
		private String toolType;
		private String toolBrand;
		private int rentalDays;
		private LocalDate checkoutDate;
		private LocalDate dueDate;
		private double dailyRentalCharge;
		private int chargeDays;
		private double preDiscountCharge;
		private int discountPercent;
		private double discountAmount;
		private double finalCharge;

		public RentalAgreementBuilder setToolCode(String toolCode) {
			this.toolCode = toolCode;
			return this;
		}

		public RentalAgreementBuilder setToolType(String toolType) {
			this.toolType = toolType;
			return this;
		}

		public RentalAgreementBuilder setToolBrand(String toolBrand) {
			this.toolBrand = toolBrand;
			return this;
		}

		public RentalAgreementBuilder setRentalDays(int rentalDays) {
			this.rentalDays = rentalDays;
			return this;
		}

		public RentalAgreementBuilder setCheckoutDate(LocalDate checkoutDate) {
			this.checkoutDate = checkoutDate;
			return this;
		}

		public RentalAgreementBuilder setDueDate(LocalDate dueDate) {
			this.dueDate = dueDate;
			return this;
		}

		public RentalAgreementBuilder setDailyRentalCharge(double dailyRentalCharge) {
			this.dailyRentalCharge = dailyRentalCharge;
			return this;
		}

		public RentalAgreementBuilder setChargeDays(int chargeDays) {
			this.chargeDays = chargeDays;
			return this;
		}

		public RentalAgreementBuilder setPreDiscountCharge(double preDiscountCharge) {
			this.preDiscountCharge = preDiscountCharge;
			return this;
		}

		public RentalAgreementBuilder setDiscountPercent(int discountPercent) {
			this.discountPercent = discountPercent;
			return this;
		}

		public RentalAgreementBuilder setDiscountAmount(double discountAmount) {
			this.discountAmount = discountAmount;
			return this;
		}

		public RentalAgreementBuilder setFinalCharge(double finalCharge) {
			this.finalCharge = finalCharge;
			return this;
		}

		public RentalAgreement build() {
			return new RentalAgreement(this);
		}
	}

	// Getters
	public String getToolCode() {
		return toolCode;
	}

	public String getToolType() {
		return toolType;
	}

	public String getToolBrand() {
		return toolBrand;
	}

	public int getRentalDays() {
		return rentalDays;
	}

	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public double getDailyRentalCharge() {
		return dailyRentalCharge;
	}

	public int getChargeDays() {
		return chargeDays;
	}

	public double getPreDiscountCharge() {
		return preDiscountCharge;
	}

	public int getDiscountPercent() {
		return discountPercent;
	}

	public double getDiscountAmount() {
		return discountAmount;
	}

	public double getFinalCharge() {
		return finalCharge;
	}

	public void printRentalAggrement() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yy");
        DecimalFormat currencyFormat = new DecimalFormat("$#,##0.00");
        DecimalFormat percentFormat = new DecimalFormat("#0%");

        System.out.println("Tool code: " + toolCode);
        System.out.println("Tool type: " + toolType);
        System.out.println("Tool brand: " + toolBrand);
        System.out.println("Rental days: " + rentalDays);
        System.out.println("Check out date: " + formatter.format(checkoutDate));
        System.out.println("Due date: " + formatter.format(dueDate));
        System.out.println("Daily rental charge: " + currencyFormat.format(dailyRentalCharge));
        System.out.println("Charge days: " + chargeDays);
        System.out.println("Pre-discount charge: " + currencyFormat.format(preDiscountCharge));
        System.out.println("Discount percent: " + percentFormat.format(discountPercent / 100.0));
        System.out.println("Discount amount: " + currencyFormat.format(discountAmount));
        System.out.println("Final charge: " + currencyFormat.format(finalCharge));
	}
}
