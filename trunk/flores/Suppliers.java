package flores;

import java.util.Collection;
import java.util.HashSet;

public class Suppliers {

	private Collection<JuridicPerson> suppliers = new HashSet();
	
	public void add(JuridicPerson client) {
		suppliers.add(client);
	}
	
	public int size() {
		return suppliers.size();
	}

}
