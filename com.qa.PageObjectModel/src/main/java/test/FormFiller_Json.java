package test;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.gson.stream.JsonReader;

public class FormFiller_Json {
	
		// Initializing the WebDriver
		WebDriver driver;

		// Initializing the WebDriverWait class
		WebDriverWait wait;
		
		// Creating an Object of JsonReader
		String JsonFilePath="C:\\Users\\Ishankawijerathne\\eclipse-workspace\\com.qa.PageObjectModel\\src\\main\\java\\data\\RegistrationData.json";
		JSONParser parser = new JSONParser();
		
		
		@BeforeMethod
		public void Pre_Condition() throws FileNotFoundException, IOException, ParseException {
			
			String url;
			
			System.setProperty("webdriver.chrome.driver",
					"C:\\EvonSys\\Automation\\Evonsys\\com.qa.training\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			
			Object obj = parser.parse(new FileReader(JsonFilePath));
			JSONObject jsonObject = (JSONObject) obj;
		    
		    url= (String) jsonObject.get("URL");
		    
		    driver.get(url);
		    driver.manage().window().maximize();
		}
		
		
		@AfterTest
		public void Post_Condition() {
			
			driver.quit();
		}
		
		
		@Test
		public void SignUpUserForm_guru99insurance() throws FileNotFoundException, IOException, ParseException {
			
			
			Object obj = parser.parse(new FileReader(JsonFilePath));
			JSONObject jsonObject = (JSONObject) obj;
			
			String RegistrationBrowserTitle=(String) jsonObject.get("PreConditionBrowserTitle"); 
			
		    Assert.assertEquals(driver.getTitle(), RegistrationBrowserTitle, "Page is loaded with registration page");
		    //System.out.println("The Pre-Condition Browser Title is: "+RegistrationBrowserTitle);
		    
		    
		}

}
