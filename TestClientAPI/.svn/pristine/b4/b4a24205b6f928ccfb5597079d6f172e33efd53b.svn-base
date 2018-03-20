package com.dsw.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * json转换工具包
 * 
 * @author hlr
 *
 */
public class DeJsonUtil {
	/**
	 * 预留
	 * @param jsonStr
	 * @return
	 * @throws Exception
	 */
	public static String deRoomJson(String jsonStr) throws Exception {
		JSONObject json = JSONObject.parseObject(jsonStr);
		if ("success".equals(json.getString("result"))) {
			JSONArray jsonArray = json.getJSONArray("zones");
			return JSONArray.toJSONString(jsonArray);
		} else {
			throw new Exception();
		}
	}

}
