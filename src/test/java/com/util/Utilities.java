package com.util;

public class Utilities {

	
	public boolean weatherComparator (float tempUI , float tempAPI, float variance) throws TemperatureOutsideRangeException {
		boolean result;
		
		try {
		float tempDiff = Math.abs(tempUI-tempAPI);
		
		if (tempDiff>variance) {
			throw new TemperatureOutsideRangeException("Temperature variation is outside the range");
			}
		
		else {
			result =true;
			System.out.println("Temperature Variance ( " +tempDiff + " )  is with in permissible range");
			return result;
		}
		
	}
		catch (TemperatureOutsideRangeException ex) {
	        result = false;
	      ex.printStackTrace();
	        return result;
	    }
	
	}
	
		
}
