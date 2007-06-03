package ui;

import javax.swing.UIManager;

import persistence.ModelPersistence;
import persistence.exception.MessageIdentifiedException;
import ui.controller.action.ShowLoginDialogAction;

public class MainApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.out.println("Error setting native LAF: " + e);
		}

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
