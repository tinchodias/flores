package model.receipt;

import org.joda.time.base.BaseDateTime;


public class SellCancellation {

	private final BaseDateTime date;
	private final Sell sell;

	public SellCancellation(Sell sell, BaseDateTime date) {
		this.sell = sell;
		this.date = date;
	}

	public BaseDateTime getDate() {
		return date;
	}

	public Sell getSell() {
		return sell;
	}

}
