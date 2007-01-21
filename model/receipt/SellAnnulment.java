package model.receipt;

import java.util.Date;

public class SellAnnulment {

	private final Date date;
	private final Sell sell;

	public SellAnnulment(Sell sell, Date date) {
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
