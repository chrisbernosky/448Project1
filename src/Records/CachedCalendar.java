package Records;

import java.util.Calendar;

public class CachedCalendar {
	
	private static CachedCalendar sInstance= null;
	
	/**
	 * values 0-11
	 */
	public int Month;
	/**
	 * values 1-31
	 */
	public int DayOfMonth;
	/**
	 * 2015,2016
	 */
	public int Year;
	
	private CachedCalendar(){
		Calendar cal = Calendar.getInstance();
		Month 		= cal.get(Calendar.MONTH);
		DayOfMonth 	= cal.get(Calendar.DAY_OF_MONTH);
		Year 		= cal.get(Calendar.YEAR);
	}
	/*
	 * Singleton
	 */
	public static CachedCalendar getInstance(){
		if(sInstance == null){
			sInstance = new CachedCalendar();
		}
		return sInstance;
		
	}

}
