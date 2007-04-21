package ui;

import javax.swing.JFrame;

import persistence.ModelPersistence;
import persistence.exception.MessageIdentifiedException;
import ui.swing.initializer.AppFrameInitializer;

public class FloresApplication {

	private static JFrame frame;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			AppFrameInitializer frameInitializer = new AppFrameInitializer();
			frame = frameInitializer.frame();

			initPersistence();

			frame.setVisible(true);
			
		} catch (Exception e) {
			UI.instance().showError(null, e.getMessage());
			System.exit(0);
		}
	}

	private static void initPersistence() throws MessageIdentifiedException {
		ModelPersistence.instance().open();
		ModelPersistence.instance().load();
	}

}
