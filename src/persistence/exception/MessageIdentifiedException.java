package persistence.exception;

import message.MessageIdentifier;
import message.MessageRepository;

public class MessageIdentifiedException extends Exception {

	private static final long serialVersionUID = 6795699466187375611L;

	public MessageIdentifiedException(MessageIdentifier messageIdentifier) {
		MessageRepository.instance().messageFor(messageIdentifier);
	}

}
