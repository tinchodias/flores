package security;

import message.MessageId;
import persistence.exception.MessageIdentifiedException;

public class ModelSecurityException extends MessageIdentifiedException {

	public ModelSecurityException(MessageId messageIdentifier) {
		super(messageIdentifier);
	}

}
