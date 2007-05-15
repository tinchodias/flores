package ui.controller.initializer;

import javax.swing.JFrame;

import ui.view.swing.component.MainFrame;

public class AppFrameInitializer {

	public MainFrame frame() {
		MainFrame frame = new MainFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return frame;
	}

}
