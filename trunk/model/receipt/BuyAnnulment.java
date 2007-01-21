package model.receipt;

import java.util.Date;

public class BuyAnnulment {

	private final Buy buy;
	private final Date date;

	public BuyAnnulment(Buy buy, Date date) {
		this.buy = buy;
		this.date = date;
	}

	public Buy getBuy() {
		return buy;
	}

	public Date getDate() {
		return date;
	}

}
