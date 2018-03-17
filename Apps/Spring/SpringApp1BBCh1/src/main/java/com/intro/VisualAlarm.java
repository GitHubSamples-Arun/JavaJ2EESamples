package com.intro;

public class VisualAlarm implements Alarm{

	@Override
	public void activate() {
		System.out.println("visual alarm activated");
		
	}

	@Override
	public void deactivate() {
		System.out.println("visual alarm deactivated");
		
	}

}
