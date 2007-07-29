package model.receipt;

import org.joda.time.ReadableDateTime;


public class SellCancellation {

	private final ReadableDateTime date;
	private final Sell sell;

	public SellCancellation(Sell sell, ReadableDateTime date) {
		this.sell = sell;
		this.date = date;
	}

	public ReadableDateTime getDate() {
		return date;
	}

	public Sell getSell() {
		return sell;
	}

}
