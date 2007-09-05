package validation;

import message.MessageId;

import org.apache.commons.lang.StringUtils;

public class ModelValidation {

	private static ModelValidation instance;

	public static ModelValidation instance() {
		if (instance == null) {
			instance = new ModelValidation();
		}
		return instance;
	}

	public void assertNotBlank(String field, MessageId fieldMessageId) {
		if (StringUtils.isBlank(field)) {
			throw new ModelValidationError(fieldMessageId + " no puede ser vacío.");
		}
	}

	public void assertNotNull(Object field, MessageId fieldMessageId) {
		if (field == null) {
			throw new ModelValidationError(fieldMessageId + "debe tener algo.");
		}
	}

	
}
