package ui;

import persistence.ModelPersistence;
import persistence.exception.MessageIdentifiedException;
import ui.controller.action.ShowLoginDialogAction;

public class MainApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			initPersistence();
			UI.instance().mainUI().show();

			new ShowLoginDialogAction().execute();
			
		} catch (Exception e) {
			UI.instance().showError(e.getMessage());
			System.exit(0);
		}
	}

	private static void initPersistence() throws MessageIdentifiedException {
		ModelPersistence.instance().open();
		ModelPersistence.instance().load();
	}

}
