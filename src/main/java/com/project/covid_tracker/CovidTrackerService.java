package com.project.covid_tracker;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class CovidTrackerService {
	
	List<LocationStats> allStats = new ArrayList<LocationStats>();
	private String VirusDataUrl = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_daily_reports/12-28-2020.csv";
	@PostConstruct
	public void fetchVirusData() throws ClientProtocolException, IOException {
		List<LocationStats> newStats = new ArrayList<LocationStats>();
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(VirusDataUrl);
		HttpResponse response = client.execute(request);
		BufferedReader in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
		for (CSVRecord record : records) {
			LocationStats locationStats = new LocationStats();
		    locationStats.setState(record.get("Province_State"));
		    locationStats.setCountry(record.get("Country_Region"));
		    locationStats.setConfirmedCase(record.get("Confirmed"));
		    newStats.add(locationStats);
		}
		this.allStats = newStats;
		   
		
	}

}
