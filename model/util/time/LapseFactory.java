package model.util.time;

import java.util.Date;

public class LapseFactory {

	public static Lapse toNow() {
		return new ClosedLapse(new Date(0), new Date());
	}

}
