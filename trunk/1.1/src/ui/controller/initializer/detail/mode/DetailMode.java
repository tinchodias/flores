package ui.controller.initializer.detail.mode;



public abstract class DetailMode {

	public abstract void applyTo(DetailModeVisitor visitor);
	
	public static final DetailMode CREATING = new DetailMode() {
		public void applyTo(DetailModeVisitor visitor) {
			visitor.setCreatingMode();
		}
	};
	
	public static final DetailMode MODIFYING = new DetailMode() {
		public void applyTo(DetailModeVisitor visitor) {
			visitor.setModifyingMode();
		}
	};
	
	public static final DetailMode VIEWING = new DetailMode() {
		public void applyTo(DetailModeVisitor visitor) {
			visitor.setViewingMode();
		}
	};
	
	
}
