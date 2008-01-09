package model.receipt;

import java.util.Iterator;
import java.util.List;

import model.money.MoneyAmount;
import model.stock.Article;
import model.util.CollectionFactory;

public class BuyItems implements Iterable<BuyItem> {

	private List<BuyItem> items = CollectionFactory.newList();
	
	public void add(Article article, Double count, MoneyAmount value) {
		items.add(new BuyItem(article, count, value));
	}
	
	public void add(BuyItem item) {
		items.add(item);
	}
	
	public MoneyAmount total() {
		MoneyAmount total = MoneyAmount.newFor(0.0);
		for (BuyItem item : items) {
			total = total.plus(item.getValue().by(item.getCount()));
		}
		return total;
	}

	public void adjustTotal(MoneyAmount adjustedTotal) {
		MoneyAmount adjustCoefficient = adjustedTotal.dividedBy(total());
		
		for (BuyItem item : items) {
			MoneyAmount adjustedValue = item.getValue().by(adjustCoefficient);
			item.setValue(adjustedValue);
		}
	}

	public Object get(int index) {
		return items.get(index);
	}

	public boolean remove(Object object) {
		return items.remove(object);
	}

	public int size() {
		return items.size();
	}

	public Iterator iterator() {
		return items.iterator();
	}

}

