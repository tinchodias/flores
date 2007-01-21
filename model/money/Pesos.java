package model.money;

/* TODO La existencia de esta clase complica el código porque
 * no es polimórfico con Double, lo cual complica las operaciones.
 * Al menos debería encapsular en métodos a las operaciones comunes.
 */
/* TODO El modelo es bastante genérico salvo por esta clase.
 * Replantear el modelo de dinero. 
 */
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
