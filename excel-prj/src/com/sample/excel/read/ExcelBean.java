package com.sample.excel.read;

public class ExcelBean {
	
	private String strOne = "";
	private String strTwo = "";
	private String strThree = "";
	private String strFour = "";
	public String getStrOne() {
		return strOne;
	}
	public void setStrOne(String strOne) {
		this.strOne = strOne;
	}
	public String getStrTwo() {
		return strTwo;
	}
	public void setStrTwo(String strTwo) {
		this.strTwo = strTwo;
	}
	public String getStrThree() {
		return strThree;
	}
	public void setStrThree(String strThree) {
		this.strThree = strThree;
	}
	public String getStrFour() {
		return strFour;
	}
	public void setStrFour(String strFour) {
		this.strFour = strFour;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String objectStr = strOne +"\t"+ strTwo +"\t"+ strThree +"\t"+ strFour;
		return objectStr;
	}
	

}
