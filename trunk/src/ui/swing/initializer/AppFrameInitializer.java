package ui.swing.initializer;

import javax.swing.JFrame;

import ui.swing.component.MainFrame;

public class AppFrameInitializer {

	public MainFrame frame() {
		MainFrame frame = new MainFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return frame;
	}

}
