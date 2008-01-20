package model;

public interface VisitableOperation {

	void accept(OperationVisitor visitor);
	
}
