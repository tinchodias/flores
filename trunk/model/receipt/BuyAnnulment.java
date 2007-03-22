package model.receipt;

import org.joda.time.ReadableDateTime;

public class BuyAnnulment {

	private final Buy buy;
	private final ReadableDateTime date;

	public BuyAnnulment(Buy buy, ReadableDateTime date) {
		this.buy = buy;
		this.date = date;
	}

	public Buy getBuy() {
		return buy;
	}

	public ReadableDateTime getDate() {
		return date;
	}

}
