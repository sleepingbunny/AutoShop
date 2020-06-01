package autoShop;

public enum ServiceList {
	OIL_CHANGE(9.99),
	LUBE_JOB(15.99),
	TIRE_ROTATION(10.99),
	WHEEL_ALLIGNMENT(12.99),
	BRAKE_FLUID(19.99),
	BATTERY_CHANGE(16.99);	
	
	private double price;
	
	private ServiceList(double price) {
		this.price = price;
	}

	public double getPrice() {
		return price;
	}
}
