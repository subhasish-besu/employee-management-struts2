/**
 * 
 */
package com.employeemanagement.common;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.employeemanagement.dto.WeatherDTO;

/**
 * @author USER
 *
 */
public class EmployeeManagementCommon {

	
	public static WeatherDTO getWeather(String zip) {
		StringBuilder strResponse = new StringBuilder();
		WeatherDTO weather = new WeatherDTO();
		DecimalFormat df = new DecimalFormat("#.00");
		try {
			URL url = new URL(
					"http://api.openweathermap.org/data/2.5/weather?zip="+zip+",in&appid=1c5e63d034c546a6c2235529b53dfc80&mode=xml");

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/xml");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				//System.out.println(output);
				strResponse.append(output);
			}

			System.out.println("Output Response -> " + strResponse.toString());
			
			conn.disconnect();
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(new ByteArrayInputStream(strResponse.toString().getBytes()));

			doc.getDocumentElement().normalize();

			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

			NodeList nList = doc.getElementsByTagName("temperature");

			System.out.println("----------------------------");
			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				//System.out.println("\nCurrent Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					System.out.println("Current Temp in kelvin: " + eElement.getAttribute("value"));
					System.out.println("Max Temp in kelvin: " + eElement.getAttribute("max"));
					System.out.println("Min Temp in kelvin: " + eElement.getAttribute("min"));
					
					String currentCel = df.format(Double.parseDouble(eElement.getAttribute("value")) -273.16); 
					String maxCel = df.format(Double.parseDouble(eElement.getAttribute("max")) -273.16); 
					String minCel = df.format(Double.parseDouble(eElement.getAttribute("min")) -273.16); 
					
					weather.setCurTemp(currentCel);
					weather.setMaxTemp(maxCel);
					weather.setMinTemp(minCel);

				}
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return weather; 
	} // function end here ----
	
	
	
	
}
