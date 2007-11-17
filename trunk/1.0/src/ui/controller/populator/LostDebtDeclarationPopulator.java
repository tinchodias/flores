package ui.controller.populator;

import model.debts.LostDebtDeclaration;

import org.joda.time.DateTime;

import persistence.ModelPersistence;
import ui.view.component.LostDebtDeclarationUI;

import com.db4o.foundation.NotSupportedException;

public class LostDebtDeclarationPopulator implements DetailPopulator<LostDebtDeclaration, LostDebtDeclarationUI>{

	public LostDebtDeclaration createFrom(LostDebtDeclarationUI ui) {
		LostDebtDeclaration declaration = new LostDebtDeclaration(ui.getClient(), ui.getAmount(), new DateTime());
		
		ModelPersistence.instance().loadedModel().store().debts().add(declaration);
		return declaration;
	}

	public void modifyFrom(LostDebtDeclarationUI ui, LostDebtDeclaration object) {
		throw new NotSupportedException();
	}

	public void showIn(LostDebtDeclarationUI ui, LostDebtDeclaration object) {
		throw new NotSupportedException();
	}

}
