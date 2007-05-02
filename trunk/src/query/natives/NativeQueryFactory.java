package query.natives;

import java.util.Collection;
import java.util.HashSet;

import model.JuridicPerson;
import persistence.Model;
import persistence.ModelPersistence;
import query.Query;
import query.QueryFactory;
import query.criteria.ClientSearchCriteria;
import query.results.Results;

public class NativeQueryFactory extends QueryFactory {

	@Override
	public Query clientSearchQuery(final ClientSearchCriteria criteria) {
		
		//TODO
		Query query = new Query() {
			public Results results() {
				Model model = ModelPersistence.instance().loadedModel();
				Collection<JuridicPerson> clients = model.getStore().clients();
				Collection<JuridicPerson> results = new HashSet<JuridicPerson>();
				
				for (JuridicPerson client : clients) {
					if (client.getNombre().indexOf(criteria.getClientName()) >= 0) {
						results.add(client);
					}
				}
				
				return results;
			}
		};
		
		return query;
	}

}
