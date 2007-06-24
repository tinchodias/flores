package query.framework.results;

import model.receipt.BuyItem;
import model.receipt.BuyItems;
import query.results.BuyItemResultsSpecification;


public class BuyItemsLazySearchResults extends LazySearchResults {

	private BuyItems buyItems = new BuyItems();

	public BuyItemsLazySearchResults() {
		super(new BuyItemResultsSpecification());
	}
	
	public void add(Object object) {
		this.buyItems.add((BuyItem) object);
	}

	public boolean remove(Object object) {
		return this.buyItems.remove(object);
	}
	
	public int getRowCount() {
		return buyItems.size();
	}

	public Object get(int index) {
		return buyItems.get(index);
	}

	public BuyItems getBuyItems() {
		return buyItems;
	}

}
