package ui.controller.initializer.detail.mode;



public abstract class DetailMode {

	public abstract void applyTo(DetailModeVisitor visitor);
	
	public static DetailMode CREATING = new DetailMode() {
		public void applyTo(DetailModeVisitor visitor) {
			visitor.setCreatingMode();
		}
	};
	
	public static DetailMode MODIFYING = new DetailMode() {
		public void applyTo(DetailModeVisitor visitor) {
			visitor.setModifyingMode();
		}
	};
	
	public static DetailMode VIEWING = new DetailMode() {
		public void applyTo(DetailModeVisitor visitor) {
			visitor.setViewingMode();
		}
	};
	
	
}
