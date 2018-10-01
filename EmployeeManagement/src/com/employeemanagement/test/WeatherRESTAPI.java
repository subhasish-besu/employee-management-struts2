/**
 * 
 */
package com.employeemanagement.test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @author USER
 *
 */
public class WeatherRESTAPI {

	/**
	 * @param args
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public static void main(String[] args) throws ParserConfigurationException, SAXException {

		System.out.println("Hello");
		DecimalFormat df = new DecimalFormat("#.00");

		try {

			URL url = new URL(
					"http://api.openweathermap.org/data/2.5/weather?zip=560036,in&appid=1c5e63d034c546a6c2235529b53dfc80&mode=xml");

			StringBuilder strResponse = new StringBuilder();

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
				// System.out.println(output);
				strResponse.append(output);
			}
			conn.disconnect();

			System.out.println("Output Response -> " + strResponse.toString());

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(new ByteArrayInputStream(strResponse.toString().getBytes()));

			doc.getDocumentElement().normalize();

			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

			NodeList nList = doc.getElementsByTagName("temperature");

			System.out.println("----------------------------");
			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				System.out.println("\nCurrent Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					System.out.println("Current Temp in kelvin: " + eElement.getAttribute("value"));
					System.out.println("Max Temp in kelvin: " + eElement.getAttribute("max"));
					System.out.println("Min Temp in kelvin: " + eElement.getAttribute("min"));
					
					double currentCel = Double.parseDouble(eElement.getAttribute("value")); 
					double maxCel = Double.parseDouble(eElement.getAttribute("max")); 
					double minCel = Double.parseDouble(eElement.getAttribute("min")); 
					
					String s = df.format(123.0990000);
					System.out.println(s);
					
					System.out.println("Current Temp in celcious: " + df.format((currentCel-273.16)));
					System.out.println("Max Temp in celcious: " + df.format((maxCel-273.16)));
					System.out.println("Min Temp in celcious: " + df.format((minCel-273.16)));
					

				}
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
