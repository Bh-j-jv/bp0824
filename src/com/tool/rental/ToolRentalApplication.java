package com.tool.rental;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import com.tool.rental.exceptions.InvalidDiscountException;
import com.tool.rental.exceptions.InvalidRentalDaysException;

public class ToolRentalApplication {

	private WareHouse wareHouse;

	public ToolRentalApplication() {
		wareHouse = new WareHouse();
	}

	public RentalAgreement checkoutTool(String toolCode, int rentalDayCount, int discountPercentage, LocalDate checkoutDate)
			throws InvalidRentalDaysException, InvalidDiscountException {

		if (rentalDayCount <= 0) {
			throw new InvalidRentalDaysException("Invalid Rental Days: " + rentalDayCount);
		}

		if (discountPercentage < 0 || discountPercentage > 100) {
			throw new InvalidDiscountException("Invalid Discount Percentage: " + discountPercentage);
		}

		Tool tool = wareHouse.getTool(toolCode);
		ToolType toolType = tool.getToolType();

		int chargeableDays = countChargeableDays(toolType, rentalDayCount, checkoutDate);

		double preDiscountCharges = priceRoundedUp(chargeableDays * toolType.getDailyCharge());
		double discountAmount = 0;
		
		if(discountPercentage > 0) {
			discountAmount = (preDiscountCharges / 100) * discountPercentage;
			discountAmount = priceRoundedUp(discountAmount);
		}
		

		double finalCharges = preDiscountCharges - discountAmount;

		RentalAgreement rentalAgreement = new RentalAgreement.RentalAgreementBuilder()
				.setToolCode(toolCode)
				.setToolType(toolType.getToolName())
				.setToolBrand(tool.getBrand())
				.setRentalDays(rentalDayCount)
				.setCheckoutDate(checkoutDate)
				.setDueDate(checkoutDate.plusDays(rentalDayCount))
				.setDailyRentalCharge(toolType.getDailyCharge())
				.setChargeDays(chargeableDays)
				.setDiscountPercent(discountPercentage)
				.setPreDiscountCharge(preDiscountCharges)
				.setDiscountAmount(discountAmount)
				.setFinalCharge(finalCharges)
				.build();
		rentalAgreement.printRentalAggrement();
		return rentalAgreement;
	}
	
	private double priceRoundedUp(double price) {
		return BigDecimal.valueOf(price)
				.setScale(2, RoundingMode.HALF_UP)
				.doubleValue();
	}

	private int countChargeableDays(ToolType toolType, int rentalDayCount, LocalDate checkoutDate) {
		
		if (toolType.isWeekendChargeable() && toolType.isHolidayChargeable()) {
			return rentalDayCount;
		}
		int chargeableDays = rentalDayCount;

		for (int i = 0; i < rentalDayCount; i++) {
			//holiday chargeable?
			if(!toolType.isHolidayChargeable() && DayTypeUtil.isHoliday(checkoutDate)) {
				chargeableDays--;
			} else if(!toolType.isWeekendChargeable() && DayTypeUtil.isWeekend(checkoutDate)) {
				chargeableDays--;
			}
			checkoutDate = checkoutDate.plusDays(1);
		}
		
		return chargeableDays;
	}

	public void registerTool(String toolCode, String toolType, String brand, double chargePerDay,
			boolean isWeekdayChargeable, boolean isWeekendChargeable, boolean isHolidayChargeable) {
		wareHouse.registerTool(toolCode, toolType, brand, chargePerDay, isWeekdayChargeable, isWeekendChargeable,
				isHolidayChargeable);
	}
}
