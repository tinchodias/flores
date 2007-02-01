package model.util;

import org.joda.time.DateMidnight;
import org.joda.time.Days;
import org.joda.time.Interval;

public class TimeUtils {

	public static Interval todayInterval() {
		return new Interval(new DateMidnight(), Days.ONE);
	}

}
