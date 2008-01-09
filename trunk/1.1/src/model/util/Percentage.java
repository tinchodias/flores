package model.util;

import java.text.NumberFormat;

import model.money.MoneyAmount;

public class Percentage {

	private static NumberFormat format;
	private final Double ratio;

	public static Percentage newFor(Double ratio) {
		return new Percentage(ratio);
	}	
	
	private Percentage(Double ratio) {
		this.ratio = ratio;
	}

	public String toString() {
		return format().format(value());
	}

	public static NumberFormat format() {
		if (format == null) {
			format = NumberFormat.getPercentInstance();
			format.setMinimumFractionDigits(2);
			format.setMaximumFractionDigits(2);
		}
		return format;
	}

	public Double value() {
		return ratio;
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

}
