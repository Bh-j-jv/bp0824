package com.tool.rental;

import java.util.HashMap;
import java.util.Map;

public class WareHouse {

	private Map<String, Tool> tools;

	public WareHouse() {
		super();
		tools = new HashMap<>();
	}

	public void registerTool(String toolCode, String toolName, String brand, double chargePerDay,
			boolean isWeekdayChargeable, boolean isWeekendChargeable, boolean isHolidayChargeable) {
		ToolType toolType = new ToolType(toolName, chargePerDay, isWeekdayChargeable, isWeekendChargeable, isHolidayChargeable);
		Tool tool = new Tool(toolCode, toolType, brand);
		tools.put(toolCode, tool);
	}

	public Tool getTool(String toolCode) {
		return tools.get(toolCode);
	}

}
