package model.money;

import java.text.DecimalFormat;
import java.text.NumberFormat;

//TODO Think on a more abstract model for money?

public class Pesos {

	private static DecimalFormat format;
	private final Double value;

	public static Pesos newFor(Double d) {
		return new Pesos(d);
	}
	
	private Pesos(Double value) {
		this.value = value;
	}

	public String toString() {
		return "$ " + formatter().format(value());
	}

	private static NumberFormat formatter() {
		if (format == null) {
			format = new DecimalFormat();
			format.setMinimumFractionDigits(2);
			format.setMaximumFractionDigits(2);
		}
		return format;
	}

	public Double value() {
		return value;
	}
	
	public boolean equals(Object o) {
		boolean equals = false;
		if (o instanceof Pesos) {
			equals = ((Pesos) o).value().equals(this.value());
		}
		return equals;
	}

	public Pesos plus(Pesos pesos) {
		return Pesos.newFor(this.value() + pesos.value());
	}

	public Pesos minus(Pesos pesos) {
		return Pesos.newFor(this.value() - pesos.value());	
	}

	public Pesos by(double multiplier) {
		return Pesos.newFor(this.value() * multiplier);
	}
	
}