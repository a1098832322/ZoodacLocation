package com.dsw.test;

import com.dsw.thread.AlarmListener;
import com.dsw.thread.SocketSwitchButton;
import com.dsw.thread.WebSocketManager;

/**
 * 测试一些socket接口用的类
 * 
 * @author 郑龙
 *
 */
public class TestAPI {

	public static void main(String[] args) throws InterruptedException {
		AlarmListener alarmListener = new AlarmListener();
		new Thread(alarmListener).start();

		String url = "http://192.168.0.18:8080";
		WebSocketManager manager = WebSocketManager.getInstanceManager();// new一个新的manager对象
		manager.setUrl(url);

		MyLiveStreamListener listener = new MyLiveStreamListener();// new一个listener
		manager.setListener(listener);// 给manager设置client和listener
		manager.connectToServer();// 连接server

		Thread.sleep(10000);// 10秒后定位线程暂停
		SocketSwitchButton button = new SocketSwitchButton();
		// System.out.println("\n\n\n定位线程暂停！");
		button.startOrSuspendWebSocketClient(true);

		// for (int i = 0; i < 10; i++) {
		// Thread.sleep(10000);// 15秒后定位线程暂停
		// SocketSwitchButton button = new SocketSwitchButton();
		// // System.out.println("\n\n\n定位线程暂停！");
		// button.startOrSuspendWebSocketClient(true);
		//
		// // Thread.sleep(5000);// 10秒后线程重新启动
		// // button.startOrSuspendWebSocketClient(false);
		// }
	}

}
