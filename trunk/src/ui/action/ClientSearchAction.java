package ui.action;

import query.QueryFactory;
import query.criteria.ClientSearchCriteria;
import query.framework.results.Results;
import ui.component.SearchUI;

public class ClientSearchAction implements Action {

	private final SearchUI clientSearchUI;

	public ClientSearchAction(SearchUI searchPanel) {
		this.clientSearchUI = searchPanel;
	}

	public void execute() {
		ClientSearchCriteria criteria = 
			(ClientSearchCriteria) clientSearchUI.criteria();
		
		Results results = 
			QueryFactory.instance().clientSearchQuery(criteria).results();
		
		clientSearchUI.setResults(results);

//		 TODO Usar mecanismo asincrónico como este?
//
//				ModelServices.instance().clientSearch(criteria, new Callback() {
//					public void onSuccess(Object result) {
//						Results results = (Results) result;
//						clientSearchUI.setResults(results);
//					}
//				});
//				
	}

	public String getTitle() {
		return "Buscar clientes";
	}

}
