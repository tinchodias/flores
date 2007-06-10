package ui;

import java.awt.Component;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import message.MessageId;
import message.MessageRepository;
import model.money.Pesos;

import org.joda.time.ReadableInstant;

import ui.controller.initializer.MainFrameInitializer;
import ui.view.component.MainUI;
import ui.view.swing.util.LabeledPanel;
import ui.view.swing.util.PesosTableCellRenderer;
import ui.view.swing.util.ReadableInstantTableCellRenderer;

public class UI {

	private static UI instance;

	public static UI instance() {
		if (instance == null) {
			instance = new UI();
		}
		return instance;
	}

	private MainUI mainUI;

	public void showInfo(String message) {
		JOptionPane.showMessageDialog(null, message, "", JOptionPane.INFORMATION_MESSAGE);
	}

	public void showError(String message) {
		JOptionPane.showMessageDialog(null, message, "", JOptionPane.ERROR_MESSAGE);		
	}

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

	public Component label(Component component, MessageId messageId) {
		return new LabeledPanel(component, MessageRepository.instance().get(messageId) + ":");
	}

	public JTable table(TableModel tableModel) {
		JTable table = new JTable(tableModel);
		table.setAutoCreateRowSorter(true);
		table.setDefaultRenderer(Pesos.class, PesosTableCellRenderer.instance());
		table.setDefaultRenderer(ReadableInstant.class, ReadableInstantTableCellRenderer.instance());
		return table;
	}
}
