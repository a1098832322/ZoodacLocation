package com.dsw.dao;

import com.dsw.constant.StatusCode;
import com.dsw.model.Alarm;

/**
 * 用于操作预警类数据库的dao
 * 
 * @author hlr
 *
 */
public interface AlarmDao {
	/**
	 * 检查当前alarm对象内容是否满足可插入数据库
	 * 
	 * @param alarm
	 * @return StatusCode
	 */
	StatusCode checkAlarm(Alarm alarm);

	/**
	 * 将预警对象中的内容插入数据库
	 * 
	 * @param alarm
	 * @return StatusCode
	 */
	StatusCode insertAlarm(Alarm alarm);
}
