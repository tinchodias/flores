package model.commission;

import java.util.Collection;

import model.JuridicPerson;
import model.Store;
import model.receipt.Sell;

import org.joda.time.Interval;

public class Commissions {
	
	private final Store store;

	public Commissions(Store store) {
		this.store = store;
	}

	public CommissionSummary commissionAt(JuridicPerson vendor, Interval lapse) {

//		Collection<Sell> sells = store.sellsAt(vendor, lapse);
		
		return null;
	}

}
