package model.commission;

import java.util.Map;

import model.JuridicPerson;
import model.money.Pesos;

import org.joda.time.Interval;

public class CommissionSummary {

	private final JuridicPerson vendor;
	private final Interval lapse;
	private final Map detail;
	private final Pesos total;
	
	public CommissionSummary(JuridicPerson vendor, Interval lapse, Map detail, Pesos total) {
		this.vendor = vendor;
		this.lapse = lapse;
		this.detail = detail;
		this.total = total;
	}

	public Map getDetail() {
		return detail;
	}

	public Interval getLapse() {
		return lapse;
	}

	public Pesos getTotal() {
		return total;
	}

	public JuridicPerson getVendor() {
		return vendor;
	}
}
