package ui.view.swing;

import java.awt.Component;
import java.awt.Dimension;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFormattedTextField.AbstractFormatterFactory;
import javax.swing.table.TableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

import message.MessageId;
import message.MessageRepository;
import model.money.Pesos;

import org.joda.time.ReadableInstant;

import ui.UI;
import ui.view.swing.component.MainFrame;
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
	
	public void showInfo(String message) {
		JOptionPane.showMessageDialog(null, message, "", JOptionPane.INFORMATION_MESSAGE);
	}

	public void showError(String message) {
		JOptionPane.showMessageDialog(null, message, "", JOptionPane.ERROR_MESSAGE);		
	}

	public Component label(Component component, MessageId messageId) {
		LabeledPanel labeledPanel = new LabeledPanel(component, MessageRepository.instance().get(messageId) + ":");

		//TODO hardcoded width
		Dimension size = labeledPanel.getPreferredSize();
		size.width = 150;
		labeledPanel.setPreferredSize(size);
		
		return labeledPanel;
	}

	public JTable table(TableModel tableModel) {
		JTable table = new JTable(tableModel);
		table.setAutoCreateRowSorter(true);
		table.setDefaultRenderer(Pesos.class, PesosTableCellRenderer.instance());
		table.setDefaultRenderer(ReadableInstant.class, ReadableInstantTableCellRenderer.instance());
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
	
}
