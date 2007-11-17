package model.clientMovements;

import model.JuridicPerson;

import org.joda.time.base.BaseDateTime;

public class ClientMovement {

	private final BaseDateTime date;
	private final Object movement;
	private final JuridicPerson client;

	public ClientMovement(BaseDateTime date, JuridicPerson client, Object movement) {
		this.date = date;
		this.client = client;
		this.movement = movement;
	}

	public BaseDateTime getDate() {
		return date;
	}

	public JuridicPerson getClient() {
		return client;
	}

	public Object getMovement() {
		return movement;
	}

}
