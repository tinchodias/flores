package ui.view.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFormattedTextField.AbstractFormatterFactory;
import javax.swing.border.Border;
import javax.swing.table.TableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

import message.MessageId;
import message.MessageRepository;
import model.cashBook.CashBookEntry;
import model.money.MoneyAmount;

import org.apache.commons.lang.math.NumberUtils;
import org.joda.time.ReadableInstant;

import ui.UI;
import ui.view.swing.component.MainFrame;
import ui.view.swing.util.CashBookCellRenderer;
import ui.view.swing.util.DateTimePicker;
import ui.view.swing.util.LabeledPanel;
import ui.view.swing.util.MoneyAmountTableCellRenderer;
import ui.view.swing.util.ReadableInstantTableCellRenderer;
import ui.view.swing.util.objectpicker3.ObjectPicker3;

public class SwingUI extends UI {

	private static final int FOCUS_BORDER_THICKNESS = 4;
	private static SwingUI instance;

	public static SwingUI instance() {
		if (instance == null) {
			instance = new SwingUI();
		}
		return instance;
	}
	
	public void showMessage(String message, String title) {
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.PLAIN_MESSAGE);
	}
	
	public void showInfo(String message) {
		JOptionPane.showMessageDialog(null, message, "", JOptionPane.INFORMATION_MESSAGE);
	}

	public void showError(String message) {
		JOptionPane.showMessageDialog(null, message, "", JOptionPane.ERROR_MESSAGE);		
	}

	public JPanel decorated(JComponent component, MessageId messageId) {
		LabeledPanel labeledPanel = new LabeledPanel(decorated(component), MessageRepository.instance().get(messageId) + ":");

		//TODO hardcoded width
		Dimension size = labeledPanel.getPreferredSize();
		size.width = 230;
		labeledPanel.setPreferredSize(size);
		labeledPanel.setMinimumSize(size);
		
		return labeledPanel;
	}
	
	public JComponent decorated(final JComponent component) {
		FocusListener listener = focusEffectListenerFor(component);
		
		//TODO horrible!
		if (component instanceof ObjectPicker3) {
			ObjectPicker3 picker = (ObjectPicker3) component;
			picker.getField().addFocusListener(listener);
			picker.getButton().addFocusListener(listener);
		} else if (component instanceof JScrollPane) {
			((JScrollPane) component).getViewport().getView().addFocusListener(listener);
		} else if (component instanceof DateTimePicker) {
			((DateTimePicker) component).getSpinner().getEditor().addFocusListener(listener);
			((DateTimePicker) component).getSpinner().addFocusListener(listener);
			((DateTimePicker) component).addFocusListener(listener);
		} else {
			component.addFocusListener(listener);
		}
		return component;
	}
	
	private FocusListener focusEffectListenerFor(final JComponent component) {
		Border originalBorder = component.getBorder();
		Border focusedInnerBorder = BorderFactory.createLineBorder(Color.ORANGE, FOCUS_BORDER_THICKNESS);
//		Border notFocusedInnerBorder = BorderFactory.createEmptyBorder(FOCUS_BORDER_THICKNESS, FOCUS_BORDER_THICKNESS, FOCUS_BORDER_THICKNESS, FOCUS_BORDER_THICKNESS);
		Border notFocusedInnerBorder = BorderFactory.createLineBorder(Color.LIGHT_GRAY, FOCUS_BORDER_THICKNESS);
		final Border focusedBorder = BorderFactory.createCompoundBorder(focusedInnerBorder, originalBorder);
		final Border notFocusedBorder = BorderFactory.createCompoundBorder(notFocusedInnerBorder, originalBorder);
		FocusListener listener = new FocusListener() {
			public void focusGained(FocusEvent e) {
				component.setBorder(focusedBorder);
			}
			public void focusLost(FocusEvent e) {
				component.setBorder(notFocusedBorder);				
			}
		};
		component.setBorder(notFocusedBorder);
		return listener;
	}

	public JPanel titledBorderPanel(Component component, MessageId messageId) {
		String title = MessageRepository.instance().get(messageId);
		Border titledBorder = BorderFactory.createTitledBorder(title);
		Border emptyBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		Border compoundBorder = BorderFactory.createCompoundBorder(titledBorder, emptyBorder);
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(compoundBorder);
		panel.add(component);
		return panel;
	}

	public JTable table(TableModel tableModel) {
		final JTable table = new JTable(tableModel);
		table.setGridColor(Color.LIGHT_GRAY);
		table.setFillsViewportHeight(true);
		table.setAutoCreateRowSorter(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		// Custom renderer instances
		table.setDefaultRenderer(MoneyAmount.class, MoneyAmountTableCellRenderer.instance());
		table.setDefaultRenderer(ReadableInstant.class, ReadableInstantTableCellRenderer.instance());
		table.setDefaultRenderer(CashBookEntry.class, CashBookCellRenderer.instance());
		
		// Custom transfer focus actions
		Action transferFocusAction = new AbstractAction() {
		    public void actionPerformed(ActionEvent e) {
		    	table.transferFocus();
		    }
		};
		Action transferFocusBackwardAction = new AbstractAction() {
		    public void actionPerformed(ActionEvent e) {
		    	table.transferFocusBackward();
		    }
		};
		table.getActionMap().put("transferFocus", transferFocusAction);
		table.getActionMap().put("transferFocusBackward", transferFocusBackwardAction);
		table.getInputMap().put(KeyStroke.getKeyStroke("TAB"), "transferFocus");
		table.getInputMap().put(KeyStroke.getKeyStroke("shift TAB"), "transferFocusBackward");
		
		return table;
	}

	public JFormattedTextField decimalField() {
		AbstractFormatter displayFormatter = new NumberFormatter(NumberFormat.getNumberInstance());
		AbstractFormatter editFormatter = new NumberFormatter(NumberFormat.getNumberInstance(Locale.ENGLISH));
		AbstractFormatterFactory formatterFactory = new DefaultFormatterFactory(displayFormatter, displayFormatter, editFormatter);

		JFormattedTextField formattedTextField = new JFormattedTextField(formatterFactory);
		formattedTextField.setHorizontalAlignment(SwingConstants.TRAILING);
		return formattedTextField;
	}
	
	public JFormattedTextField currencyField() {
		AbstractFormatter displayFormatter = new NumberFormatter(MoneyAmount.format());
		AbstractFormatter editFormatter = new NumberFormatter(NumberFormat.getNumberInstance(Locale.ENGLISH));
		AbstractFormatterFactory formatterFactory = new DefaultFormatterFactory(displayFormatter, displayFormatter, editFormatter);

		JFormattedTextField formattedTextField = new JFormattedTextField(formatterFactory);
		formattedTextField.setHorizontalAlignment(SwingConstants.TRAILING);
		return formattedTextField;
	}

	public MainFrame mainUI() {
		return (MainFrame) super.mainUI();
	}

	public MoneyAmount moneyAmountFrom(JFormattedTextField field) {
		return MoneyAmount.newFor(NumberUtils.toDouble(String.valueOf(field.getValue())));
	}

	public Double doubleFrom(JFormattedTextField field) {
		return NumberUtils.toDouble(String.valueOf(field.getValue()));
	}

	public void setEnableRecursively(Container container, boolean enable) {
		for (int i = 0; i < container.getComponentCount(); i++) {
			Component component = container.getComponent(i);
			if (component instanceof Container) {
				Container container2 = (Container) component;
				setEnableRecursively(container2, enable);
			}
			if (!(component instanceof JLabel) &&
				!(component instanceof JScrollBar)) {
				component.setEnabled(enable);
			}
		}
	}
	
}
