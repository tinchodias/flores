package persistence.exception;

import message.MessageId;
import message.MessageRepository;

public class MessageIdentifiedException extends Exception {

	private static final long serialVersionUID = 6795699466187375611L;

	public MessageIdentifiedException(MessageId messageIdentifier) {
		super(MessageRepository.instance().messageFor(messageIdentifier));
	}

}
