package hemiy.qinghui.com.mytestdemo.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * json字符串转换工具类
 */
public class JsonUtil {
	public static Gson gson = new Gson();

	/*
	 * json字符串转为对象
	 */
	public static <T> T parseToObject(String jsonStr, Class<T> clazz) {
		T obj = null;
		try {
			obj = gson.fromJson(jsonStr, clazz);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	/*
	 * 对象转为json字符串
	 */
	public static String parseToJsonStr(Object o) {
		String json = "";
		try {
			Gson gson = new Gson();
			json = gson.toJson(o);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}

	/*
	 * json转map
	 */
	public static Map<String, Object> parseToMap(String jsonStr) {
		Map<String, Object> map = null;
		try {
			map = gson.fromJson(jsonStr, new TypeToken<Map<String, Object>>() {
			}.getType());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * 将jsons字符串转为List
	 * 
	 * @param 传入的json字符串
	 * @param clazz
	 * @return list
	 */
	// 例子
	// List<Product> list= JsonUtil.parseToArray(str, Product[].class)
	public static <T> List<T> parseToArray(String jsonStr, Class<T[]> clazz) {
		List<T> list = null;
		try {
			list = Arrays.asList(gson.fromJson(jsonStr, clazz));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// 将jsons字符串转为List ，下面的方法不适用，会报类型转化异常classCastException

	/*
	 * public static <T> List<T> parseToList(String jsonStr,Class<T> clazz) {
	 * List<T> list=null; try { list = gson.fromJson(jsonStr, new
	 * TypeToken<List<T>>() {}.getType()); } catch (Exception e) {
	 * LogUtils.v(e.getMessage(), e.getCause()); } return list; }
	 */

}
