package model.operationSummary;


public class OperationSummary {

	private final Class<?> operationClass;
	private final String info;

	public OperationSummary(Class<?> operationClass, String info) {
		this.operationClass = operationClass;
		this.info = info;
	}

	public Class<?> getOperationClass() {
		return operationClass;
	}

	public String getInfo() {
		return info;
	}

}
