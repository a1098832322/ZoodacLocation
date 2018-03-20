package com.dsw.test;

import java.security.Timestamp;
import java.sql.Time;
import java.util.Date;

import com.dsw.dao.impl.RoomDaoImpl;
import com.dsw.hardware.ModbusUtil;
import com.dsw.httpclient.OkhttpClient;
import com.dsw.thread.SocketSwitchButton;
import com.mysql.fabric.xmlrpc.base.Data;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		timeStampTest();
	}

	private static void timeStampTest() {
		java.sql.Timestamp ts1 = new java.sql.Timestamp(new Date().getTime());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Timestamp ts2 = new java.sql.Timestamp(new Date().getTime());
		long ts3 = (ts2.getTime() - ts1.getTime()) / 1000;
		System.out.println(ts3);
	}

	private static void relayTest() {
		for (int i = 0; i < 10; i++) {
			System.out.println("第" + (i + 1) + "次的状态" + ModbusUtil.readDigitalOutput("192.168.1.200", 10000, 254, 1));
			try {
				ModbusUtil.writeDigitalOutput("192.168.1.200", 10000, 254, 1, 1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("第" + (i + 2) + "次的状态" + ModbusUtil.readDigitalOutput("192.168.1.200", 10000, 254, 1));
			try {
				ModbusUtil.writeDigitalOutput("192.168.1.200", 10000, 254, 1, 0);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
