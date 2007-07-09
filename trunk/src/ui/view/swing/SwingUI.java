package ui.view.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
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
import model.CashBookEntry;
import model.money.Pesos;

import org.joda.time.ReadableInstant;

import ui.UI;
import ui.view.swing.component.MainFrame;
import ui.view.swing.util.CashBookCellRenderer;
import ui.view.swing.util.LabeledPanel;
import ui.view.swing.util.PesosTableCellRenderer;
import ui.view.swing.util.ReadableInstantTableCellRenderer;

public class SwingUI extends UI {

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

	public JPanel label(Component component, MessageId messageId) {
		LabeledPanel labeledPanel = new LabeledPanel(component, MessageRepository.instance().get(messageId) + ":");

		//TODO hardcoded width
		Dimension size = labeledPanel.getPreferredSize();
		size.width = 200;
		labeledPanel.setPreferredSize(size);
		labeledPanel.setMinimumSize(size);
		
		return labeledPanel;
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
		JTable table = new JTable(tableModel);
		table.setGridColor(Color.LIGHT_GRAY);
		table.setFillsViewportHeight(true);
		table.setAutoCreateRowSorter(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setDefaultRenderer(Pesos.class, PesosTableCellRenderer.instance());
		table.setDefaultRenderer(ReadableInstant.class, ReadableInstantTableCellRenderer.instance());
		table.setDefaultRenderer(CashBookEntry.class, CashBookCellRenderer.instance());
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
		AbstractFormatter displayFormatter = new NumberFormatter(Pesos.format());
		AbstractFormatter editFormatter = new NumberFormatter(NumberFormat.getNumberInstance(Locale.ENGLISH));
		AbstractFormatterFactory formatterFactory = new DefaultFormatterFactory(displayFormatter, displayFormatter, editFormatter);

		JFormattedTextField formattedTextField = new JFormattedTextField(formatterFactory);
		formattedTextField.setHorizontalAlignment(SwingConstants.TRAILING);
		return formattedTextField;
	}

	public MainFrame mainUI() {
		return (MainFrame) super.mainUI();
	}

	public Pesos pesosFrom(JFormattedTextField field) {
		return Pesos.newFor(Double.valueOf(field.getValue().toString()));
	}

	public void setEnableRecursively(Container container, boolean enable) {
		for (int i = 0; i < container.getComponentCount(); i++) {
			Component component = container.getComponent(i);
			if (component instanceof Container) {
				Container container2 = (Container) component;
				setEnableRecursively(container2, enable);
			}
			if (!(component instanceof JLabel)) {
				component.setEnabled(enable);
			}
		}
	}
	
}
