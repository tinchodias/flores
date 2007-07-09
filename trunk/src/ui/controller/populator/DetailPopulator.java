package ui.controller.populator;

import util.ValueHolder;

public abstract class DetailPopulator <T, DetailType> implements ValueHolder<T> {

	private T value;

	public T getValue() {
		return value;
	}
	
	public void setValue(T value) {
		this.value = value;
	}

	public abstract void createFrom(DetailType ui);
	
	public abstract void modifyFrom(DetailType ui);
	
	public abstract void showIn(DetailType ui);
	
}
