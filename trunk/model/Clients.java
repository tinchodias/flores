package model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class Clients implements Collection<JuridicPerson> {

	private Collection<JuridicPerson> clients = new HashSet<JuridicPerson>();
	
	public int size() {
		return clients.size();
	}

	public void remove(JuridicPerson client) {
		clients.remove(client);
	}

	public boolean add(JuridicPerson client) {
		return clients.add(client);
	}

	public boolean addAll(Collection<? extends JuridicPerson> c) {
		return clients.addAll(c);
	}

	public void clear() {
		clients.clear();
	}

	public boolean contains(Object o) {
		return clients.contains(o);
	}

	public boolean containsAll(Collection<?> c) {
		return clients.containsAll(c);
	}

	public boolean equals(Object o) {
		return clients.equals(o);
	}

	public int hashCode() {
		return clients.hashCode();
	}

	public boolean isEmpty() {
		return clients.isEmpty();
	}

	public Iterator<JuridicPerson> iterator() {
		return clients.iterator();
	}

	public boolean remove(Object o) {
		return clients.remove(o);
	}

	public boolean removeAll(Collection<?> c) {
		return clients.removeAll(c);
	}

	public boolean retainAll(Collection<?> c) {
		return clients.retainAll(c);
	}

	public Object[] toArray() {
		return clients.toArray();
	}

	public <T> T[] toArray(T[] a) {
		return clients.toArray(a);
	}
}
