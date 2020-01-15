package com.ilia.web;

public enum browsers {

	FIREFOX("firefox"), 
	IEXPLORER("internet explorer"), 
	CHROME("chrome");

	private String value;

	browsers(String value) //constructor of class 

	{
		this.setValue(value); // to invoke method or constructor for current object
	}
	

	public String getValue()
	{
	return value;
	}

	public void setValue(String value) 
	{
		this.value = value;
		
		

	}

}
