package model.receipt;

import org.joda.time.ReadableDateTime;

public class BuyCancellation {

	private final Buy buy;
	private final ReadableDateTime date;

	public BuyCancellation(Buy buy, ReadableDateTime date) {
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
