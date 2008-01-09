package ui.controller.manager;

import query.framework.query.SearchQuery;
import ui.controller.initializer.search.SearchDialogInitializer;

public interface UIModelManager {

	SearchDialogInitializer searchInitializer();

	SearchQuery stringSearchQuery();

}
