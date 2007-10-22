package query.results;


import message.MessageId;
import model.clientMovements.ClientMovement;
import query.framework.results.LazySearchResultsSpecification;

public class ClientMovementSearchResultsSpecification extends LazySearchResultsSpecification {

	public ClientMovementSearchResultsSpecification() {
		add(MessageId.date);
		add(MessageId.clientMovement);
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
