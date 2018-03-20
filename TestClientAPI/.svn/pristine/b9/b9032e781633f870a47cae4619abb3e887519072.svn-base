package com.dsw.httpclient;

import java.io.IOException;
import java.util.Properties;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dsw.util.DeJsonUtil;
import com.dsw.util.PropUtil;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;

/**
 * 使用OKHttp3的小客户端，主要用于开启警铃
 * 
 * @author 郑龙
 *
 */
public class OkhttpClient {
	private static boolean isSuccess = false;
	private static String json = null;

	/**
	 * 触发警铃方法
	 */
	public void triggerAlarm() {
		alarmOptions(PropUtil.getInstance().getProperty("OPEN_ALARM_URL"));
	}

	/**
	 * 停止警铃方法
	 */
	public void shutdownAlarm() {
		alarmOptions(PropUtil.getInstance().getProperty("OPEN_ALARM_URL"));
	}

	/**
	 * 查询房间信息（预留）
	 */
	public void checkRoomInfo() {
		roomOptions(PropUtil.getInstance().getProperty("ZOODAC_URL") + "/rest/zone.json");
	}

	/**
	 * 封装好的警铃状态操作
	 * 
	 * @param url
	 * @return 操作状态true,false
	 */
	private boolean alarmOptions(String url) {
		// 实例化网络请求客户端
		OkHttpClient mClient = new OkHttpClient();
		// 构建请求URL
		Request request = new Request.Builder().url(url).get().build();

		mClient.newCall(request).enqueue(new Callback() {

			@Override
			public void onResponse(Call arg0, Response arg1) throws IOException {
				System.out.println("成功！");
				isSuccess = true;
			}

			@Override
			public void onFailure(Call arg0, IOException arg1) {
				System.out.println("访问失败！");
				isSuccess = false;
			}
		});

		return isSuccess;
	}

	/**
	 * 请求智物达服务返回房间信息（预留）
	 * 
	 * @param url
	 * @return 房间的json信息
	 */
	private String roomOptions(String url) {
		// 实例化网络请求客户端
		OkHttpClient client = new OkHttpClient();
		// 构建URL
		Request request = new Request.Builder().url("http://192.168.0.18:8080/rest/zone.json?action=get.zones&planId=1")
				.get().build();

		client.newCall(request).enqueue(new Callback() {

			@Override
			public void onResponse(Call call, Response response) throws IOException {
				// TODO Auto-generated method stub
				String resultJson = response.body().string();
				try {
					json = DeJsonUtil.deRoomJson(resultJson);
					System.out.println(json);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("请求房间信息服务失败！");
				}	
			}

			@Override
			public void onFailure(Call call, IOException e) {
				// TODO Auto-generated method stub
				System.out.println("请求失败！");
			}
		});
		return json;
	}
}
