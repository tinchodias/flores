package model.receipt;

import org.joda.time.ReadableDateTime;


public class SellAnnulment {

	private final ReadableDateTime date;
	private final Sell sell;

	public SellAnnulment(Sell sell, ReadableDateTime date) {
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
