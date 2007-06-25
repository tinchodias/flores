package ui.view.swing.util.actionadapter;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Icon;

import message.IconRepository;
import message.MessageRepository;
import ui.controller.action.Action;

public class ActionAdapter extends AbstractAction {

	private final Action action;

	public ActionAdapter(Action action) {
		this.action = action;
		initName();
		initIcon();
		
		//TODO only for development time!
		putValue(SHORT_DESCRIPTION, action.messageId().toString());
	}

	public void actionPerformed(ActionEvent e) {
		action.execute();
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
