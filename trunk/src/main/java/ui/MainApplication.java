package ui;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import message.MessageId;
import persistence.ModelPersistence;
import ui.controller.action.ShowDialogAction;
import ui.controller.initializer.LoginDialogInitializer;

public class MainApplication {

	/**
	 * Main entry for the aplication.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
        		try {
        			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        		} catch (Exception e) {
        			System.out.println("Error setting native LAF: " + e);
        		}

        		try {
        			initPersistence();
        			UI.instance().mainUI().show();

        			new ShowDialogAction(new LoginDialogInitializer(), MessageId.loginDialogTitle).execute();

        		} catch (Exception e) {
        			UI.instance().showError(e.getMessage());
        			System.exit(0);
        		}
            }
		});
	}

	private static void initPersistence() {
		ModelPersistence.instance().open();
		ModelPersistence.instance().load();
	}

}
