package ui.controller.manager;

import message.MessageId;
import query.framework.query.SearchQuery;
import ui.controller.initializer.search.SearchDialogInitializer;

public interface UIModelManager {

	SearchDialogInitializer searchInitializer();

	SearchQuery stringSearchQuery();

	MessageId pluralNameMessageId();

}
