package com.dsw.thread;

import com.dsw.model.People;
import com.dsw.util.PropUtil;
/**
 * 警报触发线程
 * @author hlr
 *
 */
public class PeopleAlarmThread extends Thread {
	private People people;
	private static final String ALARM_ROOM_NAME = PropUtil.getInstance().getProperty("ALARM_ROOM");

	public PeopleAlarmThread() {
		// TODO Auto-generated constructor stub
	}

	public PeopleAlarmThread(People people) {
		// TODO Auto-generated constructor stub
		this.people = people;
	}
	private void updateAlarm(){
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
	}

}
