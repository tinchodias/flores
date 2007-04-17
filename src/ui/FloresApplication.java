package ui;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import ui.initializer.AppFrameInitializer;

public class FloresApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
//		try {
//			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		AppFrameInitializer frameInitializer = new AppFrameInitializer();
		JFrame frame = frameInitializer.frame();
		frame.setVisible(true);
	}

}
