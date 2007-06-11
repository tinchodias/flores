package ui.controller.action;

import message.MessageId;
import query.framework.query.SearchQuery;
import ui.view.component.SearchUI;

public class SearchAction implements Action {

	private final SearchUI searchUI;
	private final SearchQuery searchQuery;

	public SearchAction(SearchUI searchUI, SearchQuery searchQuery) {
		this.searchUI = searchUI;
		this.searchQuery = searchQuery;
	}

	public void execute() {
		searchQuery.setCriteria(searchUI.criteria());
		searchUI.setResults(searchQuery.results());

//		 TODO Usar mecanismo asincrónico como este?
//
//						ModelServices.instance().clientSearch(criteria, new Callback() {
//							public void onSuccess(Object result) {
//								Results results = (Results) result;
//								searchUI.setResults(results);
//							}
//						});
//						
	}

	public MessageId messageId() {
		return MessageId.search;
	}

}
