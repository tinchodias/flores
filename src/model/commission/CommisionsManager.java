package model.commission;

import model.JuridicPerson;

import org.joda.time.Interval;

public interface CommisionsManager {

	public abstract CommissionSummary commissionAt(JuridicPerson vendor,
			Interval lapse);

}