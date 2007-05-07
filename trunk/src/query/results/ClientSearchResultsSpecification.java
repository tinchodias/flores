package query.results;


import persistence.ModelPersistence;
import query.framework.results.LazySearchResultsSpecification;
import message.MessageIdentifier;
import model.JuridicPerson;

public class ClientSearchResultsSpecification extends
		LazySearchResultsSpecification<JuridicPerson> {

	public ClientSearchResultsSpecification() {
		add(MessageIdentifier.CLIENT_NAME);
		add(MessageIdentifier.CLIENT_DEBT);
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
