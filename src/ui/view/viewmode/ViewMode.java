package ui.view.viewmode;

import java.awt.Component;

//TODO quitar esta clase?

public interface ViewMode {

	boolean isVisible(Component component);

	boolean isEnabled(Component component);

}
