package ui.controller.action;

import query.QueryFactory;
import query.criteria.ClientSearchCriteria;
import query.framework.results.SearchResults;
import ui.view.component.SearchUI;

public class ClientSearchAction implements Action {

	private final SearchUI searchUI;

	public ClientSearchAction(SearchUI searchUI) {
		this.searchUI = searchUI;
	}

	public void execute() {
		ClientSearchCriteria criteria = 
			(ClientSearchCriteria) searchUI.criteria();
		
		SearchResults results = 
			QueryFactory.instance().clientSearchQuery(criteria).results();
		
		searchUI.setResults(results);

//		 TODO Usar mecanismo asincrónico como este?
//
//				ModelServices.instance().clientSearch(criteria, new Callback() {
//					public void onSuccess(Object result) {
//						Results results = (Results) result;
//						searchUI.setResults(results);
//					}
//				});
//				
	}

	public String getTitle() {
		return "Buscar clientes";
	}

}
