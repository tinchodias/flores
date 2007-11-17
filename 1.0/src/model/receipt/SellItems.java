package model.receipt;

import java.util.Iterator;
import java.util.List;

import model.money.MoneyAmount;
import model.stock.Article;
import model.util.CollectionFactory;

public class SellItems implements Iterable<SellItem> {

	List<SellItem> items = CollectionFactory.newList();
	
	public void add(Article article, Double count, MoneyAmount sellValue, MoneyAmount costValue) {
		items.add(new SellItem(article, count, sellValue, costValue));
	}
	
	public void add(SellItem item) {
		items.add(item);
	}
	
	public MoneyAmount sellTotal() {
		MoneyAmount total = MoneyAmount.zero();
		for (SellItem item : items) {
			total = total.plus(item.getSellValue().by(item.getCount()));
		}
		return total;
	}

	public MoneyAmount costTotal() {
		MoneyAmount total = MoneyAmount.zero();
		for (SellItem item : items) {
			total = total.plus(item.getCostValue().by(item.getCount()));
		}
		return total;
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

	public void adjustTotal(MoneyAmount adjustedTotal) {
		double adjustCoefficient = adjustedTotal.dividedBy(sellTotal());
		
		for (SellItem item : items) {
			MoneyAmount adjustedValue = item.getSellValue().by(adjustCoefficient);
			item.setSellValue(adjustedValue);
		}
	}

	public Iterator<SellItem> iterator() {
		return items.iterator();
	}

}

