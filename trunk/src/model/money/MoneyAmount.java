package model.money;

import java.text.NumberFormat;

import message.MessageId;
import validation.ModelValidation;

public class MoneyAmount {

	private static NumberFormat format;
	private final Double value;

	public static MoneyAmount newFor(Double d) {
		return new MoneyAmount(d);
	}
	
	private MoneyAmount(Double value) {
		ModelValidation.instance().assertNotNull(value, MessageId.moneyAmount);
		this.value = value;
	}

	public String toString() {
		return format().format(value());
	}

	public static NumberFormat format() {
		if (format == null) {
			format = NumberFormat.getCurrencyInstance();
//			format.setMinimumFractionDigits(2);
//			format.setMaximumFractionDigits(2);
		}
		return format;
	}

	public Double value() {
		return value;
	}
	
	public boolean equals(Object o) {
		boolean equals = false;
		if (o instanceof MoneyAmount) {
			equals = ((MoneyAmount) o).value().equals(this.value());
		}
		return equals;
	}

	public int hashCode() {
		return this.value().hashCode();
	}	
	
	public MoneyAmount plus(MoneyAmount moneyAmount) {
		return MoneyAmount.newFor(this.value() + moneyAmount.value());
	}

	public MoneyAmount minus(MoneyAmount moneyAmount) {
		return MoneyAmount.newFor(this.value() - moneyAmount.value());	
	}

	public MoneyAmount by(double multiplier) {
		return MoneyAmount.newFor(this.value() * multiplier);
	}

	public MoneyAmount by(MoneyAmount moneyAmount) {
		return MoneyAmount.newFor(this.value() * moneyAmount.value());
	}
	
	public MoneyAmount dividedBy(MoneyAmount moneyAmount) {
		return MoneyAmount.newFor(this.value() / moneyAmount.value());
	}

}
