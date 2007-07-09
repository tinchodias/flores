package util;

import org.joda.time.DateMidnight;
import org.joda.time.Days;
import org.joda.time.Interval;
import org.joda.time.ReadableDateTime;
import org.joda.time.ReadableInterval;
import org.joda.time.Years;

public class TimeUtils {

	public static ReadableInterval todayInterval() {
		return new Interval(new DateMidnight(), Days.ONE);
	}

	private static ReadableDateTime tomorrowMidnight() {
		return new DateMidnight().plus(Days.ONE);
	}
	
	//TODO test
	public static ReadableInterval recentDaysInterval(int dayCount) {
		return new Interval(Days.days(dayCount), tomorrowMidnight());
	}

	//TODO test
	public static ReadableInterval recentYearsInterval(int yearCount) {
		return new Interval(Years.years(yearCount), tomorrowMidnight());
	}
	
}
