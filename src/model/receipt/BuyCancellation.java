package model.receipt;

import org.joda.time.base.BaseDateTime;

public class BuyCancellation {

	private final Buy buy;
	private final BaseDateTime date;

	public BuyCancellation(Buy buy, BaseDateTime date) {
		this.buy = buy;
		this.date = date;
	}

	public Buy getBuy() {
		return buy;
	}

	public BaseDateTime getDate() {
		return date;
	}

}
