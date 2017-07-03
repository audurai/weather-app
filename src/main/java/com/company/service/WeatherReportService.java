package com.company.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.company.exception.CountryNotFoundException;
import com.company.exception.WeatherReportNotFoundException;
import com.company.model.Country;
import com.ws.DataSet;
import com.ws.Table;
import com.ws.WeatherReportClient;

@Service
public class WeatherReportService {

	public Country getCitiesByCountry(String countryName) throws CountryNotFoundException {
		Country country = null;
		WeatherReportClient objWeatherReportClient = new WeatherReportClient();
		DataSet dataSet = objWeatherReportClient.getCitiesByCountry(countryName);
		if (dataSet != null && dataSet.getList() != null) {
			country = new Country();
			List<String> cities = new ArrayList<String>();
			for (Table table : dataSet.getList()) {
				country.setName(table.getCountry());
				cities.add(table.getCity());
			}
			country.setCities(cities);
		} else {
			throw new CountryNotFoundException(countryName);
		}
		return country;
	}

	public DataSet getWeatherReport(String countryName, String cityName) throws WeatherReportNotFoundException {
		WeatherReportClient objWeatherReportClient = new WeatherReportClient();
		DataSet dataSet = objWeatherReportClient.getWeatherReport(countryName, cityName);
		if (dataSet != null) {
			System.out.println(dataSet);
		}
		return dataSet;
	}
}
