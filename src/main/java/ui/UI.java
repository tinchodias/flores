package ui;

import message.MessageId;
import message.MessageRepository;
import ui.controller.initializer.MainFrameInitializer;
import ui.view.component.MainUI;
import ui.view.swing.SwingUI;

public abstract class UI {

	public static UI instance() {
		return SwingUI.instance();
	}

	private MainUI mainUI;

	public abstract void showMessage(String message, String title);
	
	public abstract void showInfo(String message);

	public abstract void showError(String message);

	public void showInfo(MessageId messageId) {
		showInfo(MessageRepository.instance().get(messageId));
	}

	public void showError(MessageId messageId) {
		showError(MessageRepository.instance().get(messageId));
	}

	public MainUI mainUI() {
		if (mainUI == null) {
			mainUI = new MainFrameInitializer().frame();
		}
		return mainUI;
	}

	public abstract String chooseSaveFileName();
	
}
