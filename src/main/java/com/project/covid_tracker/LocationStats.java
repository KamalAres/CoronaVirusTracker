package com.project.covid_tracker;

public class LocationStats {
	
	private String state;
	private String country;
	private String confirmedCase;
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getConfirmedCase() {
		return confirmedCase;
	}
	public void setConfirmedCase(String confirmedCase) {
		this.confirmedCase = confirmedCase;
	}
	@Override
	public String toString() {
		return "LocationStats [state=" + state + ", country=" + country + ", confirmedCase=" + confirmedCase + "]";
	}

}
