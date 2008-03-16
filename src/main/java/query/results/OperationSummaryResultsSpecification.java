package query.results;


import message.MessageId;
import message.MessageRepository;
import model.operationSummary.OperationSummary;
import query.framework.results.LazySearchResultsSpecification;
import ui.controller.manager.ManagerFactory;

public class OperationSummaryResultsSpecification extends LazySearchResultsSpecification {

	public OperationSummaryResultsSpecification() {
		add(MessageId.name);
		add(MessageId.info);
	}
	
	public Object value(Object object, int columnIndex) {
		OperationSummary summary = (OperationSummary) object;
		switch (columnIndex) {
		case 0:
			MessageId messageId = ManagerFactory.instance().get(summary.getOperationClass()).pluralNameMessageId();
			return MessageRepository.instance().get(messageId);
		case 1:
			return summary.getInfo();
		}
		return null;
	}

}
