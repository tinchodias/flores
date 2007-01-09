package model;

import java.util.Collection;
import java.util.HashSet;

public class Clients {

	private Collection<JuridicPerson> clients = new HashSet();
	
	public void add(JuridicPerson client) {
		clients.add(client);
	}
	
	public int size() {
		return clients.size();
	}

	public void remove(JuridicPerson client) {
		clients.remove(client);
	}

}
