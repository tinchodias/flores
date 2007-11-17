package model.money;

import java.util.Collection;
import java.util.Iterator;

import model.util.CollectionFactory;

public class Payment implements Collection<PayMode> {

	Collection<PayMode> pays = CollectionFactory.newList();
	
	public MoneyAmount total() {
		MoneyAmount total = MoneyAmount.zero();
		for (PayMode pay : pays) {
			total = total.plus(pay.getValue());
		}
		return total;
	}

	public boolean add(PayMode arg0) {
		return pays.add(arg0);
	}

	public boolean addAll(Collection<? extends PayMode> arg0) {
		return pays.addAll(arg0);
	}

	public void clear() {
		pays.clear();
	}

	public boolean contains(Object arg0) {
		return pays.contains(arg0);
	}

	public boolean containsAll(Collection<?> arg0) {
		return pays.containsAll(arg0);
	}

	public boolean equals(Object arg0) {
		return pays.equals(arg0);
	}

	public int hashCode() {
		return pays.hashCode();
	}

	public boolean isEmpty() {
		return pays.isEmpty();
	}

	public Iterator<PayMode> iterator() {
		return pays.iterator();
	}

	public boolean remove(Object arg0) {
		return pays.remove(arg0);
	}

	public boolean removeAll(Collection<?> arg0) {
		return pays.removeAll(arg0);
	}

	public boolean retainAll(Collection<?> arg0) {
		return pays.retainAll(arg0);
	}

	public int size() {
		return pays.size();
	}

	public Object[] toArray() {
		return pays.toArray();
	}

	public <T> T[] toArray(T[] arg0) {
		return pays.toArray(arg0);
	}


}
