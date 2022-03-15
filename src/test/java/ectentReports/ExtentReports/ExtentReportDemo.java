package ectentReports.ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo {
	ExtentReports extent;

	@BeforeTest
	public void configExtentReport() {
		// Two important classes of extent reports
		// 1- ExtentReports, 2- ExtentSparkReporter

		String path = "/home/neel/eclipse-workspace/ExtentReports/reports/index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Demo Report");
		reporter.config().setDocumentTitle("Test Results");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Neel Chavan");
	}

	@Test
	public void initialDemo() {

		extent.createTest("Initial Demo");

		System.setProperty("webdriver.chrome.driver", "/home/neel/SeleniumSetup/chromedriver");
		WebDriver driver = new ChromeDriver();

		// Maximize Window
		driver.manage().window().maximize();

		// Open website
		driver.get("https://facebook.com");

		// Verify if the title is correct
		Assert.assertEquals(driver.getTitle(), "Facebook – log in or sign up");

		// Close the browser after execution
		driver.close();

		// This step stops the listening of the extent reports
		extent.flush();

	}

}
