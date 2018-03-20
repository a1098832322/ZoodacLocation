package com.dsw.thread;

/**
 * 这是控制WebSocket线程启停的类
 * 
 * @author 郑龙
 *
 */
public class SocketSwitchButton {
	private static String LOCK = "";// 锁
	private static WebSocketManager manager = WebSocketManager.getInstanceManager();

	/**
	 * 设置WebSocket线程启停 调用WebSocketManager内的启停方法 详细参考：
	 * 
	 * @see WebSocketManager
	 * 
	 * @param suspend
	 *            ; true(暂停)，false(开启)
	 * 
	 * 
	 */
	public void startOrSuspendWebSocketClient(boolean suspend) {
		/* 设置线程启停 */
		if (suspend) {
			synchronized (LOCK) {
				// 断开连接
				manager.stopWebSocket();
			}
		} else {
			// 重新连接
			manager.reStart();
		}
	}
}
