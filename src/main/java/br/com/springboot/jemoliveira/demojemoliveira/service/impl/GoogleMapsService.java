package br.com.springboot.jemoliveira.demojemoliveira.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.springboot.jemoliveira.demojemoliveira.service.IGoogleMapsService;

@Service
public class GoogleMapsService implements IGoogleMapsService {

	@Value("${googlemaps.api.key}")
	private String apiKey;

	@Value("${googlemaps.url}")
	private String url;

	@Override
	public String getInfosGoogleMap(double latitude, double longitude) {

		String line = "";

		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(url + latitude + "," + longitude +  "&key=" + apiKey);
		HttpResponse response;
		try {
			response = client.execute(request);
			BufferedReader rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));

			while ((line = rd.readLine()) != null) {
				if (line.contains("formatted_address")) {
					System.out.println(line);
					break;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return line;
	}
}