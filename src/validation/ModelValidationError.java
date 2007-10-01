package validation;

import message.MessageId;
import message.MessageRepository;


public class ModelValidationError extends Error {

	public ModelValidationError(String message) {
		super(message);
	}

	public ModelValidationError(MessageId errorMessageId, MessageId argument) {
		this(errorMessageId, new String[] {MessageRepository.instance().get(argument)});
	}

	public ModelValidationError(MessageId errorMessageId, String[] arguments) {
		super(MessageRepository.instance().get(errorMessageId, arguments));
	}

}
