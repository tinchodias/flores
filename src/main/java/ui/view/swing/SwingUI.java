package ui.view.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
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
import model.util.Percentage;

import org.apache.commons.lang.math.NumberUtils;
import org.joda.time.ReadableInstant;
import org.joda.time.base.BaseDateTime;

import ui.UI;
import ui.view.swing.component.MainFrame;
import ui.view.swing.util.CashBookCellRenderer;
import ui.view.swing.util.DateTimePicker;
import ui.view.swing.util.IntervalPicker;
import ui.view.swing.util.LabeledPanel;
import ui.view.swing.util.ReadableInstantTableCellRenderer;
import ui.view.swing.util.RightAlignTableCellRenderer;
import ui.view.swing.util.actionadapter.ActionAdapter;
import ui.view.swing.util.objectpicker3.ObjectPicker3;

public class SwingUI extends UI {

	private static final int FOCUS_BORDER_THICKNESS = 3;
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
		JOptionPane.showMessageDialog(null, message, MessageRepository.instance().get(MessageId.infoTitle), JOptionPane.INFORMATION_MESSAGE);
	}

	public void showError(String message) {
		JOptionPane.showMessageDialog(null, message, MessageRepository.instance().get(MessageId.errorTitle), JOptionPane.ERROR_MESSAGE);		
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
	
	//TODO horrible!
	public JComponent decorated(final JComponent component) {
		if (component instanceof IntervalPicker) {
			return component; //Does nothing
		}
		FocusListener listener = focusEffectListenerFor(component);
		
		if (component instanceof ObjectPicker3) {
			ObjectPicker3 picker = (ObjectPicker3) component;
			picker.getField().addFocusListener(listener);
			picker.getButton().addFocusListener(listener);
		} else if (component instanceof DateTimePicker) {
			((DateTimePicker) component).getEditor().getTextField().addFocusListener(listener);
		} else if (component instanceof JScrollPane) {
			((JScrollPane) component).getViewport().getView().addFocusListener(listener);
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
		table.setDefaultRenderer(MoneyAmount.class, RightAlignTableCellRenderer.instance());
		table.setDefaultRenderer(Percentage.class, RightAlignTableCellRenderer.instance());
		table.setDefaultRenderer(ReadableInstant.class, ReadableInstantTableCellRenderer.instance());
		table.setDefaultRenderer(BaseDateTime.class, ReadableInstantTableCellRenderer.instance());
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

	public Percentage percentageFrom(JFormattedTextField field) {
		return Percentage.newFor(doubleFrom(field) / 100);
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

	public String chooseSaveFileName() {
		String title = MessageRepository.instance().get(MessageId.fileExistsConfirmTitle);
		String message = MessageRepository.instance().get(MessageId.fileExistsConfirmMessage);
		JFileChooser fc = new JFileChooser();
		int result = fc.showSaveDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			if (file.exists()) {
				int overwriteResult = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
				if (overwriteResult == JOptionPane.NO_OPTION) {
					return chooseSaveFileName();
				}
			}
			return file.toString();
		}
		return null;
	}

	public void putCloseAction(JRootPane rootPane, Action action) {
		rootPane.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke("ESCAPE"), "close");
		rootPane.getActionMap().put("close", action);		
	}
	
}
