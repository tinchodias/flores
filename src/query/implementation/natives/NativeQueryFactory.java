package query.implementation.natives;

import java.util.Collection;

import model.JuridicPerson;
import persistence.Model;
import persistence.ModelPersistence;
import query.QueryFactory;
import query.criteria.ClientSearchCriteria;
import query.framework.query.SearchQuery;
import query.framework.results.LazySearchResults;
import query.framework.results.SearchResults;
import query.results.ClientSearchResultsSpecification;

public class NativeQueryFactory extends QueryFactory {

	@Override
	public SearchQuery<JuridicPerson> clientSearchQuery(final ClientSearchCriteria criteria) {
		
		SearchQuery<JuridicPerson> query = new SearchQuery<JuridicPerson>() {
			private LazySearchResults<JuridicPerson> results;
			
			public SearchResults<JuridicPerson> results() {
				Model model = ModelPersistence.instance().loadedModel();
				Collection<JuridicPerson> clients = model.store().clients();
				//TODO Usar singleton en spec
				results = new LazySearchResults<JuridicPerson>(new ClientSearchResultsSpecification());
				
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
