package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class FormFiller_XML {
	
		//Initializing the WebDriver
		WebDriver driver;

		//Initializing the WebDriverWait class
		WebDriverWait wait;
		
		//Initializing the xml data file
		String XMLFilePath= "C:\\Users\\Ishankawijerathne\\eclipse-workspace\\com.qa.PageObjectModel\\src\\main\\java\\data\\RegistrationData.xml";
		
		File fXmlFile = new File(XMLFilePath);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		
		@BeforeMethod
		public void Pre_Condition() throws ParserConfigurationException, SAXException, IOException {
			
			String url;
			
			System.setProperty("webdriver.chrome.driver",
					"C:\\EvonSys\\Automation\\Evonsys\\com.qa.training\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			
			url = doc.getElementsByTagName("URL").item(0).getTextContent();
			
			driver.get(url);
			driver.manage().window().maximize();
			
		}
		
		@AfterTest
		public void Post_Condition() {
			
			driver.quit();
		}
		
		@Test
		public void SignUpUserForm_guru99insurance() throws ParserConfigurationException, SAXException, IOException {
			
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			
			String CurrentBrowserTitle;
			CurrentBrowserTitle=doc.getElementsByTagName("PreConditionBrowserTitle").item(0).getTextContent();
			
			Assert.assertEquals(driver.getTitle(), CurrentBrowserTitle);
			System.out.println("The value is parsed from the xml is: "+CurrentBrowserTitle);
		}

}
