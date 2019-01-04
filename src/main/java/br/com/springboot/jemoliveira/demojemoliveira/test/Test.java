package br.com.springboot.jemoliveira.demojemoliveira.test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class Test {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet("https://maps.googleapis.com/maps/api/geocode/json?latlng=-23.6130343,-46.6799467&key=AIzaSyDdXLUyZosLC8fQftguJ-F953J_ANTQQ5A");
		HttpResponse response = client.execute(request);
		BufferedReader rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));
		String line = "";
		while ((line = rd.readLine()) != null) {
			if (line.contains("formatted_address")) {
				System.out.println(line);
				break;
			}
		}
	}
}