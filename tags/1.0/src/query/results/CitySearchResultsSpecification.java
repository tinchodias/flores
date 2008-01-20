package query.results;


import message.MessageId;
import model.address.City;
import query.framework.results.LazySearchResultsSpecification;

public class CitySearchResultsSpecification extends LazySearchResultsSpecification {

	public CitySearchResultsSpecification() {
		add(MessageId.name);
		add(MessageId.province);
	}
	
	public Object value(Object object, int columnIndex) {
		City city = (City) object;
		switch (columnIndex) {
		case 0:
			return city.getName();
		case 1:
			return city.getProvince();
		}
		return null;
	}

}
