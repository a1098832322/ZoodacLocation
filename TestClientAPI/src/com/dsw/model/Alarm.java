package com.dsw.model;

import java.sql.Timestamp;

/**
 * 预警类
 * 
 * @param alarm_Type
 *            预警类型 1：电子围栏预警
 * @param alarm_Level
 *            预警登记 3：三级预警
 * @param tag_euid
 *            设备手环的euid
 * @param content
 *            预警内容
 * @param create_time
 *            创建时间
 * @author hlr
 *
 */
public class Alarm {
	private final String alarm_Type = "1", alarm_Level = "3";
	private String tag_euid, content;
	private Timestamp create_time;

	public String getTag_euid() {
		return tag_euid;
	}

	public void setTag_euid(String tag_euid) {
		this.tag_euid = tag_euid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAlarm_Type() {
		return alarm_Type;
	}

	public String getAlarm_Level() {
		return alarm_Level;
	}

	public Timestamp getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Timestamp create_time) {
		this.create_time = create_time;
	}



}
