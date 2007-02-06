package model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class Vendors implements Collection<JuridicPerson> {

	private Collection<JuridicPerson> vendors = new HashSet<JuridicPerson>();
	
	public int size() {
		return vendors.size();
	}

	public void remove(JuridicPerson client) {
		vendors.remove(client);
	}

	public boolean add(JuridicPerson client) {
		return vendors.add(client);
	}

	public boolean addAll(Collection<? extends JuridicPerson> c) {
		return vendors.addAll(c);
	}

	public void clear() {
		vendors.clear();
	}

	public boolean contains(Object o) {
		return vendors.contains(o);
	}

	public boolean containsAll(Collection<?> c) {
		return vendors.containsAll(c);
	}

	public boolean equals(Object o) {
		return vendors.equals(o);
	}

	public int hashCode() {
		return vendors.hashCode();
	}

	public boolean isEmpty() {
		return vendors.isEmpty();
	}

	public Iterator<JuridicPerson> iterator() {
		return vendors.iterator();
	}

	public boolean remove(Object o) {
		return vendors.remove(o);
	}

	public boolean removeAll(Collection<?> c) {
		return vendors.removeAll(c);
	}

	public boolean retainAll(Collection<?> c) {
		return vendors.retainAll(c);
	}

	public Object[] toArray() {
		return vendors.toArray();
	}

	public <T> T[] toArray(T[] a) {
		return vendors.toArray(a);
	}
}
