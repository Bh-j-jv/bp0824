package com.tool.rental;

public class ToolType {

	private String toolName;
	private Double dailyCharge;
	private boolean isWeekdayChargeable;
	private boolean isWeekendChargeable;
	private boolean isHolidayChargeable;

	public ToolType(String toolName, Double dailyCharge, boolean isWeekdayChargeable, boolean isWeekendChargeable,
			boolean isHolidayChargeable) {
		super();
		this.toolName = toolName;
		this.dailyCharge = dailyCharge;
		this.isWeekdayChargeable = isWeekdayChargeable;
		this.isWeekendChargeable = isWeekendChargeable;
		this.isHolidayChargeable = isHolidayChargeable;
	}

	public String getToolName() {
		return toolName;
	}

	public void setToolName(String toolName) {
		this.toolName = toolName;
	}

	public Double getDailyCharge() {
		return dailyCharge;
	}

	public void setDailyCharge(Double dailyCharge) {
		this.dailyCharge = dailyCharge;
	}

	public boolean isWeekdayChargeable() {
		return isWeekdayChargeable;
	}

	public void setWeekdayChargeable(boolean isWeekdayChargeable) {
		this.isWeekdayChargeable = isWeekdayChargeable;
	}

	public boolean isWeekendChargeable() {
		return isWeekendChargeable;
	}

	public void setWeekendChargeable(boolean isWeekendChargeable) {
		this.isWeekendChargeable = isWeekendChargeable;
	}

	public boolean isHolidayChargeable() {
		return isHolidayChargeable;
	}

	public void setHolidayChargeable(boolean isHolidayChargeable) {
		this.isHolidayChargeable = isHolidayChargeable;
	}

}
