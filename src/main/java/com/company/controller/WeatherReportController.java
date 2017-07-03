package com.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.exception.CountryNotFoundException;
import com.company.exception.WeatherReportNotFoundException;
import com.company.model.Country;
import com.company.service.WeatherReportService;
import com.ws.DataSet;

@Controller
@RequestMapping("/report")
public class WeatherReportController {

	@Autowired
	WeatherReportService weatherReportService;

	@RequestMapping(value = "/{country}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Country getCitiesByCountry(@PathVariable String country) throws CountryNotFoundException {
		Country result = weatherReportService.getCitiesByCountry(country);
		return result;
	}

	@RequestMapping(value = "/{country}/{city}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody DataSet getWeatherReport(@PathVariable String country, @PathVariable String city)
			throws WeatherReportNotFoundException {
		DataSet result = weatherReportService.getWeatherReport(country, city);
		return result;
	}
}
