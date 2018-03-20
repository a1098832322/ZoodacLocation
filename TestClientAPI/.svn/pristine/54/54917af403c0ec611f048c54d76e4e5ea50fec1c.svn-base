package com.dsw.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.dsw.constant.StatusCode;
import com.dsw.dao.impl.PeopleDaoImpl;
import com.dsw.model.People;

/**
 * 新开线程用于操作每个people对象关联数据库的操作
 * 
 * @author hlr
 *
 */
public class PeopleDaoThread extends Thread {
	private static Lock lock = new ReentrantLock();
	private People people;

	public PeopleDaoThread(People people) {
		this.people = people;
	}

	public PeopleDaoThread() {
	}

	/**
	 * lock用于同步，以免保证数据完整性
	 */
	@Override
	public void run() {
		lock.lock();// 得到锁

		try {
			// System.out.println(people.toString());
			PeopleDaoImpl pdi = PeopleDaoImpl.getInstance();
			if (pdi.checkPeopleStatus(people.getTagEuid())) {
				// System.out.println(pdi.checkFinalPeopleAddr(people.getTagEuid(),
				// people.getZoonName()));
				if (pdi.checkFinalPeopleAddr(people.getTagEuid(), people.getZoonName())) {
					System.out.println("编号：" + people.getTagEuid() + "\t在区域：" + people.getZoonName());
					if (!pdi.insertPeopleAddr(people).equals(StatusCode.SUCCESS)) {
						System.out.println("人员数据插入失败!");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();// 释放锁
		}
	}

}
