package test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.Test;

public class Link
{
	@Test
	public void testLink() throws IOException
	{
		//The url to be testes
		URL url = new URL("https://selenium.dev/downloads/");
		
		//Estlblish the connection
		HttpURLConnection httpurlconnection = (HttpURLConnection) url.openConnection();
		httpurlconnection.setConnectTimeout(2000);
		
		//Connect to url
		httpurlconnection.connect();
		
		//Get the result
		System.out.println(httpurlconnection.getResponseCode());
		
		
	}

}
