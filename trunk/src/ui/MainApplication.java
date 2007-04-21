package ui;

import persistence.ModelPersistence;
import persistence.exception.MessageIdentifiedException;

public class MainApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			initPersistence();
			UI.instance().mainUI().show();
			
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
