package ui.view.viewmode;

import java.awt.Component;

public interface ViewMode {

	boolean isVisible(Component component);

	boolean isEnabled(Component component);

}
