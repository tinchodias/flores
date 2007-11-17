package ui.controller.populator;


public interface DetailPopulator <T, DetailType> {

	T createFrom(DetailType ui);
	
	void modifyFrom(DetailType ui, T object);
	
	void showIn(DetailType ui, T object);
	
}
