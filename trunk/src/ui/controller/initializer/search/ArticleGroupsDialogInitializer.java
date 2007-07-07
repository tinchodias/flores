package ui.controller.initializer.search;

import message.MessageId;
import query.QueryFactory;
import query.framework.query.SearchQuery;
import ui.view.swing.component.ArticleGroupSearchPanel;
import ui.view.swing.component.StandardSearchDialog;
import ui.view.swing.component.StandardSearchPanel;

public class ArticleGroupsDialogInitializer extends StandardSearchDialogInitializer {

	protected void addActions(StandardSearchDialog searchDialog) {
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
