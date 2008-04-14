package model.money;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import message.MessageId;
import validation.ModelValidation;

public class MoneyAmount {

	//TODO Hardcoded pattern!
	private static final String MONEY_PATTERN = "$ #,##0.00;$ -#,##0.00";
	private static final MoneyAmount zero = MoneyAmount.newFor(0.0);
	private static NumberFormat format;
	private final Double value;

	public static MoneyAmount newFor(Double d) {
		return new MoneyAmount(d);
	}
	
	public static MoneyAmount zero() {
		return zero;
	}
	
	private MoneyAmount(Double value) {
		ModelValidation.instance().assertNotNull(value, MessageId.moneyAmount);
		this.value = value;
	}

	public String toString() {
		return format().format(value());
	}

	public static String pattern() {
		return MONEY_PATTERN;
	}
	
	public static NumberFormat format() {
		if (format == null) {
			format = new DecimalFormat(pattern());
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

	public MoneyAmount by(Double multiplier) {
		return MoneyAmount.newFor(this.value() * multiplier);
	}

	public Double dividedBy(MoneyAmount divisor) {
		return this.value() / divisor.value();
	}

	public MoneyAmount dividedBy(Double divisor) {
		return MoneyAmount.newFor(this.value() / divisor);
	}

}
