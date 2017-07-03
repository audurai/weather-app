package com.ws;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "NewDataSet")
public class DataSet {
	private List<Table> list;

	public List<Table> getList() {
		return list;
	}

	@XmlElement(name = "Table")
	public void setList(List<Table> list) {
		this.list = list;
	}
}
