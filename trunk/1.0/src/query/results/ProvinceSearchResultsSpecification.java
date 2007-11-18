package query.results;


import message.MessageId;
import model.address.Province;
import query.framework.results.LazySearchResultsSpecification;

public class ProvinceSearchResultsSpecification extends LazySearchResultsSpecification {

	public ProvinceSearchResultsSpecification() {
		add(MessageId.name);
	}
	
	public Object value(Object object, int columnIndex) {
		Province province = (Province) object;
		switch (columnIndex) {
		case 0:
			return province.getName();
		}
		return null;
	}

}
