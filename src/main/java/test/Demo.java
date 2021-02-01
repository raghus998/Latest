package test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class Demo {

	public static void main(String[] args) throws IOException   
	{
		URL url = new URL("https://funds.qsp.ca/");
		HttpURLConnection httpurlconection = (HttpURLConnection) url.openConnection();
		httpurlconection.connect();
		System.out.println(httpurlconection.getResponseCode());
		System.out.println(httpurlconection.getResponseMessage());
	
	

	}

}
