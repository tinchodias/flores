package query.framework.results;

import model.receipt.SellItem;
import model.receipt.SellItems;
import query.results.SellItemResultsSpecification;


public class SellItemsLazySearchResults extends LazySearchResults {

	private SellItems sellItems = new SellItems();

	public SellItemsLazySearchResults() {
		super(new SellItemResultsSpecification());
	}
	
	public void add(Object object) {
		this.sellItems.add((SellItem) object);
	}

	public boolean remove(Object object) {
		return this.sellItems.remove(object);
	}
	
	public int getRowCount() {
		return sellItems.size();
	}

	public Object get(int index) {
		return sellItems.get(index);
	}

	public SellItems getSellItems() {
		return sellItems;
	}

}
