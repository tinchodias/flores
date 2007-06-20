package query.results;


import message.MessageId;
import model.JuridicPerson;
import query.framework.results.LazySearchResultsSpecification;

public class SupplierSearchResultsSpecification extends LazySearchResultsSpecification {

	public SupplierSearchResultsSpecification() {
		add(MessageId.supplierName);
		add(MessageId.address);
	}
	
	public Object value(Object object, int columnIndex) {
		JuridicPerson client = (JuridicPerson) object;
		switch (columnIndex) {
		case 0:
			return client.getName();
		case 1:
			return client.getAddress();
		}
		return null;
	}

}
