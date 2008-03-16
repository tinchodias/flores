package ui.view.swing.util;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager2;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class FixedBoxLayout implements LayoutManager2 {

	private BoxLayout boxLayout;
	private Dimension componentsSize;

	public FixedBoxLayout(JPanel buttonPanel, int page_axis, Dimension componentsSize) {
		this.componentsSize = componentsSize;
		boxLayout = new BoxLayout(buttonPanel, page_axis); 
	}

	public void addLayoutComponent(Component comp, Object constraints) {
		comp.setPreferredSize(getComponentsSize());
		comp.setMaximumSize(getComponentsSize());
		boxLayout.addLayoutComponent(comp, constraints);
	}

	public void addLayoutComponent(String name, Component comp) {
		boxLayout.addLayoutComponent(name, comp);
	}

	public float getLayoutAlignmentX(Container target) {
		return boxLayout.getLayoutAlignmentX(target);
	}

	public float getLayoutAlignmentY(Container target) {
		return boxLayout.getLayoutAlignmentY(target);
	}

	public void invalidateLayout(Container target) {
		boxLayout.invalidateLayout(target);
	}

	public void layoutContainer(Container target) {
		boxLayout.layoutContainer(target);
	}

	public Dimension maximumLayoutSize(Container target) {
		return boxLayout.maximumLayoutSize(target);
	}

	public Dimension minimumLayoutSize(Container target) {
		return boxLayout.minimumLayoutSize(target);
	}

	public Dimension preferredLayoutSize(Container target) {
		return boxLayout.preferredLayoutSize(target);
	}

	public void removeLayoutComponent(Component comp) {
		boxLayout.removeLayoutComponent(comp);
	}

	public Dimension getComponentsSize() {
		return componentsSize;
	}

	public void setComponentsSize(Dimension componentsSize) {
		this.componentsSize = componentsSize;
	}


}
