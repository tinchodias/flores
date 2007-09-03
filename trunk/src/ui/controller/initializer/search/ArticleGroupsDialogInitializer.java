package ui.controller.initializer.search;

import message.MessageId;
import query.QueryFactory;
import query.framework.query.SearchQuery;
import ui.controller.initializer.detail.ArticleGroupDetailInitializer;
import ui.view.swing.component.search.ArticleGroupSearchPanel;
import ui.view.swing.component.search.StandardSearchDialog;
import ui.view.swing.component.search.StandardSearchPanel;

public class ArticleGroupsDialogInitializer extends StandardSearchDialogInitializer {

	protected void addActions(StandardSearchDialog searchDialog) {
		addShowCreatingAction(new ArticleGroupDetailInitializer(), searchDialog);
		addShowModifyingAction(new ArticleGroupDetailInitializer(), searchDialog);
	}

	protected StandardSearchPanel searchPanel() {
		return new ArticleGroupSearchPanel();
	}

	protected SearchQuery searchQuery() {
		return QueryFactory.instance().articleGroupSearchQuery();
	}

	protected MessageId titleMessageId() {
		return MessageId.articleGroup;
	}

}
