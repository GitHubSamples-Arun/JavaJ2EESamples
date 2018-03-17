package com.intro;

public class SoundAlarm implements Alarm{

	@Override
	public void activate() {
		System.out.println("soundalarm activated");
		
	}

	@Override
	public void deactivate() {
		System.out.println("soundalarm deactivated");
		
	}

}
