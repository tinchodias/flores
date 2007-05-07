package query.results;


import message.MessageId;
import model.JuridicPerson;
import model.money.Pesos;
import persistence.ModelPersistence;
import query.framework.results.LazySearchResultsSpecification;

public class ClientSearchResultsSpecification extends
		LazySearchResultsSpecification<JuridicPerson> {

	public ClientSearchResultsSpecification() {
		add(MessageId.clientName);
		add(MessageId.clientDebt, Pesos.class);
	}
	
	public Object value(JuridicPerson client, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return client.getNombre();
		case 1:
			return ModelPersistence.instance().loadedModel().store().debts().debtOf(client);
		}
		return null;
	}

}
