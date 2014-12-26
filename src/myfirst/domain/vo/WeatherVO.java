package myfirst.domain.vo;

import java.util.List;
import java.util.Map;

public class WeatherVO {

	
	/**
	 * 城市
	 */
	private String cityName ;
	
	/**
	 * 状态码: 0-正常,其它-错误
	 */
	private String statusCode;
	
	/**
	 * 日期
	 */
	private String date;
	/**
	 * 
	 */
	private List<Map<String,Object>> weatherInfo;
	
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public List<Map<String, Object>> getWeatherInfo() {
		return weatherInfo;
	}
	public void setWeatherInfo(List<Map<String, Object>> weatherInfo) {
		this.weatherInfo = weatherInfo;
	}
	
}
