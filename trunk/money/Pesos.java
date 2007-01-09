package model.money;

public class Pesos {

	private final Double value;

	public static Pesos newFor(Double d) {
		return new Pesos(d);
	}
	
	private Pesos(Double value) {
		this.value = value;
	}

	public String toString() {
		return "$ " + value();
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
}
