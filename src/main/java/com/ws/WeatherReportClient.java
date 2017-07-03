package com.ws;

import java.io.StringReader;
import java.rmi.RemoteException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.company.exception.CountryNotFoundException;
import com.company.exception.WeatherReportNotFoundException;

public class WeatherReportClient {
	public DataSet getCitiesByCountry(String country) throws CountryNotFoundException {
		DataSet dataSet = null;
		try {
			GlobalWeatherSoapProxy objGlobalWeatherSoapProxy = new GlobalWeatherSoapProxy();
			String cities = objGlobalWeatherSoapProxy.getCitiesByCountry(country);
			if (cities != null) {
				JAXBContext jaxbContext = JAXBContext.newInstance(DataSet.class);
				Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
				StringReader reader = new StringReader(cities);
				dataSet = (DataSet) unmarshaller.unmarshal(reader);				
			}else{
				throw new CountryNotFoundException(country);
			}
		} catch (RemoteException | JAXBException e) {
			// TODO Auto-generated catch block
			throw new CountryNotFoundException(country);
		}
		return dataSet;
	}

	public DataSet getWeatherReport(String country, String city) throws WeatherReportNotFoundException {
		DataSet dataSet = null;
		try {
			GlobalWeatherSoapProxy objGlobalWeatherSoapProxy = new GlobalWeatherSoapProxy();
			String report = objGlobalWeatherSoapProxy.getWeather(city, country);
			if (report != null && !report.equalsIgnoreCase("Data Not Found")) {
				JAXBContext jaxbContext = JAXBContext.newInstance(DataSet.class);
				Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
				StringReader reader = new StringReader(report);
				dataSet = (DataSet) unmarshaller.unmarshal(reader);
			} else {
				throw new WeatherReportNotFoundException(country + " " + city);
			}
		} catch (RemoteException | JAXBException e) {
			// TODO Auto-generated catch block
			throw new WeatherReportNotFoundException(country + city);
		}
		return dataSet;
	}
}
