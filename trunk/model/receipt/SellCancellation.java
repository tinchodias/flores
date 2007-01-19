package model.receipt;

import java.util.Date;

public class SellCancellation {

	private final Date date;
	private final Sell sell;

	public SellCancellation(Sell sell, Date date) {
		this.sell = sell;
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public Sell getSell() {
		return sell;
	}

}
