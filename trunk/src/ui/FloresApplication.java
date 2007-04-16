package ui;

import javax.swing.JFrame;

import ui.initializer.AppFrameInitializer;

public class FloresApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AppFrameInitializer frameInitializer = new AppFrameInitializer();
		JFrame frame = frameInitializer.frame();
		frame.setVisible(true);
	}

}
