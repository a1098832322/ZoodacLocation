package com.dsw.thread;

import com.dsw.constant.StatusCode;
import com.dsw.dao.impl.AlarmDaoImpl;
import com.dsw.hardware.ModbusUtil;
import com.dsw.model.Alarm;


/**
 * 一个警报器监听线程，专门用于触发警报
 * 
 * @author 郑龙
 *
 */
public class AlarmListener implements Runnable {
	private static volatile boolean THREAD_RUN_FLAG = true;// 线程启停标识
	private static int RUN_MODE = -1;// -1待命状态,0关闭警报,1打开警报
	private static volatile int LAST_RUN_MODE = -1;// 记录上次警报状态，防止重复发送请求导致继电器板拒绝连接
	private Object lock = "";// 锁
	private static volatile String ip;// 警报器ip
	private static volatile int port, idx;// 警报器端口和通道
	private static volatile Alarm mAlarm;

	@Override
	public void run() {
		while (true) {
			if (THREAD_RUN_FLAG) {
				try {
					// 为了防止继电器板又傲娇，所以延迟500毫秒先试试
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				switch (RUN_MODE) {
				case 0:
					// 执行关闭继电器请求
					System.out.println(ip + "\t" + port + "\t" + idx);
					try {
						ModbusUtil.writeDigitalOutput(ip, port, 254, idx, RUN_MODE);
					} catch (Exception e) {
						System.out.println("ModbusUtil 又双叒叕异常了！");
						e.printStackTrace();
					}

					System.out.println("关闭继电器");
					RUN_MODE = -1;// 重置线程为待命状态
					break;
				case 1:
					// 执行打开继电器请求
					System.out.println(ip + "\t" + port + "\t" + idx);
					try {
						ModbusUtil.writeDigitalOutput(ip, port, 254, idx, RUN_MODE);
					} catch (Exception e) {
						System.out.println("ModbusUtil 又双叒叕异常了！");
						e.printStackTrace();
					}

					System.out.println("打开继电器");
					RUN_MODE = -1;// 重置线程为待命状态
					break;
				default:
					// System.out.print("线程待命 ");
					break;
				}
			}
		}
	}

	/**
	 * 开启监听
	 */
	public void start() {
		// 初始化线程运行状态
		LAST_RUN_MODE = -1;
		RUN_MODE = -1;
		THREAD_RUN_FLAG = true;
		System.out.println("\nstart");
	}

	/**
	 * 暂停监听
	 */
	public void stop() {
		THREAD_RUN_FLAG = false;
		System.out.println("\nstop");
	}

	/**
	 * 向监听器发送指令重载了一些形参的方法，功能主要是String转换为int
	 * 
	 * @param ip
	 *            ip地址
	 * @param port
	 *            端口号
	 * @param idx
	 *            通道号
	 * @param type
	 *            触发警报模式
	 * @param doFilterCommend
	 *            是否启用重复指令判断
	 */
	public void sendMessage(String ip, String port, String idx, int type, boolean doFilterCommend) throws Exception {
		int integerPort = Integer.parseInt(port);
		int integerIdx = Integer.parseInt(idx);

		sendMessage(ip, integerPort, integerIdx, type, doFilterCommend);
	}

	/**
	 * 向监听器发送指令（有判段重复指令的方法，效率最高）
	 * 
	 * @param ip
	 *            ip地址
	 * @param port
	 *            端口号
	 * @param idx
	 *            通道号
	 * @param type
	 *            触发警报模式
	 * @param doFilterCommend
	 *            是否启用重复指令判断
	 */
	public void sendMessage(String ip, int port, int idx, int type, boolean doFilterCommend) {
		getLastRdmStatus(ip, port, idx);// 查询继电器的打开状态

		if (doFilterCommend) {
			if (LAST_RUN_MODE != type) {
				// 判断，发送的命令有无更改，如无更改则不发送新的命令
				RUN_MODE = type;// 修改线程运行状态
				setConnection(ip, port, idx);// 存储继电器板网口配置参数
				System.out.println("MODE:\t" + RUN_MODE);
			} else {
				System.out.println("status no change!");
			}
		} else {
			RUN_MODE = type;// 修改线程运行状态
			setConnection(ip, port, idx);// 存储继电器板网口配置参数
			System.out.println("MODE:\t" + RUN_MODE);
		}

	}

	/**
	 * 查询继电器打开状态
	 * 
	 * @param ip
	 * @param port
	 * @param idx
	 * @return 0 关闭 ， 1 打开
	 */
	private int getLastRdmStatus(String ip, int port, int idx) {
		try {
			Thread.sleep(500);// 线程睡0.5秒，防止查询时继电器抛异常
			LAST_RUN_MODE = ModbusUtil.readDigitalOutput(ip, port, 254, idx);
			System.out.println("status:\t" + LAST_RUN_MODE);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return LAST_RUN_MODE;
	}

	/**
	 * 设置连接属性
	 * 
	 * @param ip
	 * @param port
	 * @param idx
	 */
	private void setConnection(String ip, int port, int idx) {
		this.ip = ip;
		this.port = port;
		this.idx = idx;
	}

	/**
	 * 设置警报详情并写入警报表
	 * 
	 * @param Alarm
	 */
	public void setAlarmContent(Alarm alarm) {
		AlarmListener.mAlarm = alarm;
		if (AlarmDaoImpl.getInstance().checkAlarm(AlarmListener.mAlarm).equals(StatusCode.SUCCESS)) {
			if (AlarmDaoImpl.getInstance().insertAlarm(AlarmListener.mAlarm).equals(StatusCode.FAIl)) {
				System.out.println("人员预警数据插入失败!");
			}
		}
	}

}
