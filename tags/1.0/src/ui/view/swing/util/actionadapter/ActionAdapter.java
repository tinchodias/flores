package ui.view.swing.util.actionadapter;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Icon;

import message.IconRepository;
import message.MessageRepository;
import ui.UI;
import ui.controller.action.Action;
import validation.ModelValidationError;

public class ActionAdapter extends AbstractAction {

	private final Action action;

	public ActionAdapter(Action action) {
		this.action = action;
		initName();
		initIcon();
		
		//TODO only for development time!
//		putValue(SHORT_DESCRIPTION, action.messageId().toString());
	}

	public void actionPerformed(ActionEvent e) {
		//TODO better descriptions for exceptions
		try {
			action.execute();
		} catch (ModelValidationError ex) {
			UI.instance().showInfo(ex.getMessage());
		} catch (Exception ex) {
			UI.instance().showError(ex.getMessage());
			ex.printStackTrace();
		}
	}
	
	private void initIcon() {
		Icon icon = IconRepository.instance().get(action.messageId());
		if (icon != null) {
			putValue(SMALL_ICON, icon);
		}
	}
	
	private void initName() {
		String name = MessageRepository.instance().get(action.messageId());
		putValue(NAME, name);
	}

	public Action getAction() {
		return action;
	}
	
}
