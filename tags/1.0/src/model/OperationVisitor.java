package model;

import model.receipt.Buy;
import model.receipt.Sell;

public interface OperationVisitor {

	void visit(Sell sell);

	void visit(Buy buy);

}
