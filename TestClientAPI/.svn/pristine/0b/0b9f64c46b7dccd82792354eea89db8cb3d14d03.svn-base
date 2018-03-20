package com.dsw.util;

import com.dsw.model.People;
import com.idolink.rtls.client.api.vo.LiveStreamPosition;
/**
 * 数据加工封装类
 * @author hlr
 *
 */
public class PackageUtil {
public static People getPeople(LiveStreamPosition paramLiveStreamPosition){
	People people = new People();
	people.setAddTime(paramLiveStreamPosition.getAddTime());
	people.setLocalX(paramLiveStreamPosition.getLocalX());
	people.setLocalY(paramLiveStreamPosition.getLocalY());
	people.setPlanMeter(paramLiveStreamPosition.getPlanMeter());
	people.setTagEuid(paramLiveStreamPosition.getTagEuid());
	people.setTagType(paramLiveStreamPosition.getTagType());
	people.setZoonName(paramLiveStreamPosition.getZoneName());
	people.setZoonId(paramLiveStreamPosition.getZoneId());
	return people;
}
}
