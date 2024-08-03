package com.tool.rental;

import java.time.LocalDate;

public class ToolRentalApplicationTest {

	static ToolRentalApplication toolRentalApplication = new ToolRentalApplication();

	public static void main(String[] args) {

		toolRentalApplication.registerTool("CHNS", "Chainsaw", "Stihl", 1.49, true, false, true);
		toolRentalApplication.registerTool("LADW", "Ladder", "Werner", 1.99, true, true, false);
		toolRentalApplication.registerTool("JAKD", "Jackhammer", "DeWalt", 2.99, true, false, false);
		toolRentalApplication.registerTool("JAKR", "Jackhammer", "Ridgid", 2.99, true, false, false);

		checkoutTool("JAKR", 5, 101, LocalDate.of(2015, 9, 3));
		System.out.println("*************************");
		checkoutTool("LADW", 3, 10, LocalDate.of(2020, 7, 2));
		System.out.println("*************************");
		checkoutTool("CHNS", 5, 25, LocalDate.of(2015, 7, 2));
		System.out.println("*************************");
		checkoutTool("JAKD", 6, 0, LocalDate.of(2015, 9, 3));
		System.out.println("*************************");
		checkoutTool("JAKR", 9, 0, LocalDate.of(2015, 7, 2));
		System.out.println("*************************");
		checkoutTool("JAKR", 4, 50, LocalDate.of(2020, 7, 2));
		System.out.println("*************************");

	}

	private static void checkoutTool(String toolCode, int rentalDayCount, int discountPercentage, LocalDate checkoutDate) {
		try {
		toolRentalApplication.checkoutTool(toolCode, rentalDayCount, discountPercentage, checkoutDate);
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
