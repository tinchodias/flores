package query.framework.criteria;

import model.JuridicPerson;
import query.criteria.IntervalSearchCriteria;

public interface ClientMovementSearchCriteria extends IntervalSearchCriteria {

	JuridicPerson getClient();
	
}
