package query.results;


import message.MessageId;
import model.JuridicPerson;
import model.money.MoneyAmount;
import persistence.ModelPersistence;
import query.framework.results.LazySearchResultsSpecification;

public class ClientSearchResultsSpecification extends LazySearchResultsSpecification {

	public ClientSearchResultsSpecification() {
		add(MessageId.clientName);
		add(MessageId.address);
		add(MessageId.clientDebt, MoneyAmount.class);
	}
	
	public Object value(Object object, int columnIndex) {
		JuridicPerson client = (JuridicPerson) object;
		switch (columnIndex) {
		case 0:
			return client.getName();
		case 1:
			return client.getAddress();
		case 2:
			return ModelPersistence.instance().loadedModel().store().debts().debtOf(client);
		}
		return null;
	}

}
