package model.commission;

import model.JuridicPerson;

import org.joda.time.ReadableInterval;

public interface CommisionsManager {

	public abstract CommissionSummary commissionAt(JuridicPerson vendor,
			ReadableInterval interval);

}