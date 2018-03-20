package com.dsw.util;

import java.io.IOException;
import java.util.Properties;

import okhttp3.OkHttpClient;
/**
 * 配置文件封装类
 * @author hlr
 *
 */
public class PropUtil {
	private static Properties prop = new Properties();
	static{
		try {
			prop.load(OkHttpClient.class.getResourceAsStream("/default.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Properties getInstance(){
		return prop;
	}

}
