package query.results;


import message.MessageId;
import model.clientMovements.ClientMovement;

import org.joda.time.ReadableInstant;

import query.framework.results.LazySearchResultsSpecification;

public class ClientMovementSearchResultsSpecification extends LazySearchResultsSpecification {

	public ClientMovementSearchResultsSpecification() {
		add(MessageId.date, ReadableInstant.class);
		add(MessageId.clientMovement, ClientMovement.class);
	}
	
	public Object value(Object object, int columnIndex) {
		ClientMovement movement = (ClientMovement) object;
		switch (columnIndex) {
		case 0:
			return movement.getDate();
		case 1:
			return movement.getMovement();
		}
		return null;
	}

}
