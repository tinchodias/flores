package ui.controller.initializer;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import persistence.ModelPersistence;
import ui.view.component.MainUI;
import ui.view.swing.component.MainFrame;

public class MainFrameInitializer {

	public MainUI frame() {
		MainFrame mainFrame = new MainFrame();

		//TODO Temporal listener!
		mainFrame.addWindowListener(new WindowListener() {

			public void windowActivated(WindowEvent e) {
			}

			public void windowClosed(WindowEvent e) {
				System.out.println("Saving on close...");
				ModelPersistence instance = ModelPersistence.instance();
				instance.save(instance.loadedModel());
			}

			public void windowClosing(WindowEvent e) {
			}

			public void windowDeactivated(WindowEvent e) {
			}

			public void windowDeiconified(WindowEvent e) {
			}

			public void windowIconified(WindowEvent e) {
			}

			public void windowOpened(WindowEvent e) {
			}
			
		});
		
		return mainFrame;
	}

}
