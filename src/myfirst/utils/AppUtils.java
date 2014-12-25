package myfirst.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;

import myfirst.domain.vo.WeatherVO;

public class AppUtils {

	public static WeatherVO getBaiduWeather(String location) {
		String pointcut = "http://api.map.baidu.com/telematics/v3/weather?output=json&ak=G0sQ26x75f4YRvex2lFTA8o3&location=";
		pointcut += location;
		WeatherVO weatherVO = new WeatherVO();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			URL url = new URL(pointcut);
			URLConnection connection = url.openConnection();
			connection.setConnectTimeout(500);
			InputStream in = connection.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			StringBuffer buffer = new StringBuffer();
			String s;
			while((s=reader.readLine())!=null){
				buffer.append(s);
			}
			System.out.println(buffer.toString());
			ObjectMapper objectMapper = new ObjectMapper();
			resultMap = objectMapper.readValue(buffer.toString(), Map.class);
			for(Map.Entry<String, Object> map:resultMap.entrySet()){
				System.out.println(map.getKey()+": "+map.getValue());
			}
			Map<String, Object> weatherInfoMap = (Map<String, Object>) ((List)(resultMap.get("results"))).get(0);
			List<Map<String, Object>> weatherInfoList = new ArrayList<Map<String,Object>>();
			weatherInfoList = (List<Map<String, Object>>) weatherInfoMap.get("index");
			weatherVO.setDate(resultMap.get("date").toString());
			weatherVO.setStatusCode(resultMap.get("error").toString());
			weatherVO.setCityName(weatherInfoMap.get("currentCity").toString());
			weatherVO.setWeatherInfo(weatherInfoList);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		System.out.println("12345");
		return weatherVO;
	}
	
	public static void main(String[] args) {
		getBaiduWeather("广州");
	}
}
