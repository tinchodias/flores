package model.util.time;

import java.util.Date;


//TODO Use Joda time library?

public interface Lapse {
	
	public Date getStart();
	
	public Date getFinish();
}
