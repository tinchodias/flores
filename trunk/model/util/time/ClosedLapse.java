package model.util.time;

import java.util.Date;

public class ClosedLapse implements Lapse {

	private final Date start;
	private final Date finish;
	
	public ClosedLapse(Date start, Date finish) {
		this.start = start;
		this.finish = finish;
	}
	
	public Date getStart() {
		return start;
	}
	
	public Date getFinish() {
		return finish;
	}
}
