package test;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import data.ExcelReader;

public class FormFiller_Excel {

	// Initializing the WebDriver
	WebDriver driver;

	// Initializing the WebDriverWait class
	WebDriverWait wait;

	// Create an Object of ExcelRead class for calling para-meters
	ExcelReader excel = new ExcelReader();

	// Declaring a variable of Excel file path and Initializing
	String ExcelFileName = "C:\\Users\\Ishankawijerathne\\eclipse-workspace\\com.qa.PageObjectModel\\DataSheet\\data.xlsx";
	String SheetName = "RegistrationForm";

	@BeforeTest
	public void PreCondition() throws IOException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\EvonSys\\Automation\\Evonsys\\com.qa.training\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get(excel.readExcel(1, 0, ExcelFileName, SheetName));
		driver.manage().window().maximize();

	}

	@AfterTest
	public void PostCondition() {

		driver.quit();
	}

	@Test
	public void SignUpUserForm_guru99insurance() throws IOException, Throwable {

		// Verify whether the user signup form page is loaded
		Assert.assertEquals(driver.getTitle(), excel.readExcel(1, 1, ExcelFileName, "RegistrationForm"));

		// Select Title
		Select TitleDropdown = new Select(driver.findElement(By.xpath("//select[@id='user_title']")));
		TitleDropdown.selectByVisibleText(excel.readExcel(1, 3, ExcelFileName, SheetName));

		// Enter the first name
		WebElement FirstNameTextField = driver.findElement(By.xpath("//input[@id='user_firstname']"));
		FirstNameTextField.sendKeys(excel.readExcel(1, 4, ExcelFileName, SheetName));

		// Enter the Surname
		WebElement SurnameTextField = driver.findElement(By.xpath("//input[@id='user_surname']"));
		SurnameTextField.sendKeys(excel.readExcel(1, 5, ExcelFileName, SheetName));

		// Enter Phone
		WebElement PhoneTextField = driver.findElement(By.xpath("//input[@id='user_phone']"));
		PhoneTextField.sendKeys(excel.readExcel(1, 6, ExcelFileName, SheetName));

		// Select DOB Year
		Select DOBYear = new Select(driver.findElement(By.xpath("//select[@id='user_dateofbirth_1i']")));
		DOBYear.selectByValue(excel.readExcel(1, 7, ExcelFileName, SheetName));

		// Select DOB Month
		Select DOBMonth = new Select(driver.findElement(By.xpath("//select[@id='user_dateofbirth_2i']")));
		DOBMonth.selectByVisibleText(excel.readExcel(1, 8, ExcelFileName, SheetName));

		// Explicit Wait for day dropdown

		wait = new WebDriverWait(driver, 20);

		WebElement DOBDayDropdown;
		DOBDayDropdown = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='user_dateofbirth_3i']")));

		// Select DOB Day
		Select DOBDay = new Select(driver.findElement(By.xpath("//select[@id='user_dateofbirth_3i']")));
		DOBDay.selectByVisibleText(excel.readExcel(1, 9, ExcelFileName, SheetName));

		// Select a licencetype radio Option

		List<WebElement> RadioOption = driver.findElements(By.name("licencetype"));

		for (int i = 0; i < RadioOption.size(); i++) {

			String RadioOptionName = RadioOption.get(i).getAttribute("value");
			System.out.println(
					"The Radio Element " + RadioOption.get(i) + " is " + RadioOption.get(i).getAttribute("value"));

			if (RadioOptionName.equalsIgnoreCase(excel.readExcel(1, 10, ExcelFileName, SheetName))) {

				RadioOption.get(i).click();
				System.out.println("Radio Button is selected");
			} else {

				System.out.println("Radio Button is not selected");
			}
		}

		// Select Licence Period dropdown

		Select LicencePeriod = new Select(driver.findElement(By.xpath("//select[@id='user_licenceperiod']")));
		LicencePeriod.selectByVisibleText(excel.readExcel(1, 11, ExcelFileName, SheetName));

		// Select Occupation dropdown
		Select OccupationDropdown = new Select(driver.findElement(By.xpath("//select[@id='user_occupation_id']")));
		OccupationDropdown.selectByVisibleText(excel.readExcel(1, 12, ExcelFileName, SheetName));

		// Enter Address
		WebElement AddressTextField;
		AddressTextField = driver.findElement(By.xpath("//input[@id='user_address_attributes_street']"));
		AddressTextField.sendKeys(excel.readExcel(1, 13, ExcelFileName, SheetName));

		// Enter City
		WebElement CityTextField;
		CityTextField = driver.findElement(By.xpath("//input[@id='user_address_attributes_city']"));
		CityTextField.sendKeys(excel.readExcel(1, 14, ExcelFileName, SheetName));

		// Enter Country
		WebElement CountryTextField;
		CountryTextField = driver.findElement(By.xpath("//input[@id='user_address_attributes_county']"));
		CountryTextField.sendKeys(excel.readExcel(1, 15, ExcelFileName, SheetName));

		// Enter Post Code
		WebElement PostCodeTextField;
		PostCodeTextField = driver.findElement(By.xpath("//input[@id='user_address_attributes_postcode']"));
		PostCodeTextField.sendKeys(excel.readExcel(1, 16, ExcelFileName, SheetName));

		// Enter Email
		WebElement EmailTextField;
		EmailTextField = driver.findElement(By.xpath("//input[@id='user_user_detail_attributes_email']"));
		EmailTextField.sendKeys(excel.readExcel(1, 17, ExcelFileName, SheetName));

		// Enter Password
		WebElement PasswordTextField;
		PasswordTextField = driver.findElement(By.xpath("//input[@id='user_user_detail_attributes_password']"));
		PasswordTextField.sendKeys(excel.readExcel(1, 18, ExcelFileName, SheetName));

		// Enter Confirmation Password
		WebElement ConfirmPasswordTextField;
		ConfirmPasswordTextField = driver.findElement(By.xpath("//input[@id='user_user_detail_attributes_password_confirmation']"));
		ConfirmPasswordTextField.sendKeys(excel.readExcel(1, 19, ExcelFileName, SheetName));

		// Click on Create button
		WebElement CreateButton = driver.findElement(By.xpath("//input[@name='submit']"));
		CreateButton.click();

		Assert.assertEquals(driver.getTitle(), excel.readExcel(1, 2, ExcelFileName, SheetName));
	}

}
