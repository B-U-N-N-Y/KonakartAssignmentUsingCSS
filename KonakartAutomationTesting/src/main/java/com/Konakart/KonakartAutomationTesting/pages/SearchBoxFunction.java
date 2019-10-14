package com.Konakart.KonakartAutomationTesting.pages;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.Konakart.KonakartAutomationTesting.extentreports.ExtentReport;
import com.Konakart.KonakartAutomationTesting.helpers.Utility;
import com.Konakart.KonakartAutomationTesting.logreports.LogReport;


public class SearchBoxFunction {
	static LogReport logreport = new LogReport();

	/**
	 * This method takes input as string array and select and click dropdown option
	 * dynamically
	 * 
	 * @param data
	 */
	public static void serachBoxInput(String[] data,Properties loc) {
		Utility.selectDropdownByText(loc.getProperty("loc.konakart.homepage.dpdn"), data[0]);
		Utility.clickAndSendText(loc.getProperty("loc.konakart.search.txtbox"), data[1]);
	}

	/**
	 * This method validate the web page redirect to proper page or not
	 * 
	 * @param driver
	 * @param validatedata
	 * @param log
	 */
	public static void isRedirection(WebDriver driver, String validatedata, Logger log) {
		String title = driver.getTitle();
		Assert.assertEquals(title, validatedata, "Page is not redirect properly");
		ExtentReport.messagePrint("Page is redirecting to proper web page");
		log.info("Page is redirecting to proper web page");
	}

	/**
	 * This method validate that selected product is available or not
	 * 
	 * @param data
	 * @param log
	 */
	public static void validateProduct(String[] data, Logger log,Properties loc) {
		
		
		
		String[] title=Utility.getElement(loc.getProperty("loc.konakart.producttitle.txt")).getText().split("\n");
		for(int index=0;index<title.length;index++) {
			Assert.assertEquals(title[index], data[5+index], "Product title validationfailed");
			ExtentReport.messagePrint("Product title validate successfully");
			log.info("Product title validate successfully");
		};
//		String producttitle = Utility
//				.getElement(loc.getProperty("loc.konakart.producttitle.txt")).getText();
//		Assert.assertEquals(producttitle, data[1], "Product title validationfailed");
//		ExtentReport.messagePrint("Product title validate successfully");
//		log.info("Product title validate successfully");
//		String producprice = Utility
//				.getElement(loc.getProperty("loc.konakart.productprice.txt")).getText();
//		Assert.assertEquals(producprice, data[3], "Product price validationfailed");
//		ExtentReport.messagePrint("Product price validate successfully");
//		log.info("Product price validate successfully");
//		Utility.action(loc.getProperty("loc.konakart.productclick.btn"));
//		String addtocart = Utility
//				.getElement(loc.getProperty("loc.konakart.productaddtocart.txt")).getText();
//		
//		Assert.assertEquals(addtocart, data[6], "Product add to cart validationfailed");
//		ExtentReport.messagePrint("Product add to cart button validate successfully");
//		log.info("Product add to cart button validate successfully");
//		String addtowishlist = Utility
//				.getElement(loc.getProperty("loc.konakart.productaddtowishlist.txt")).getText();
//		Assert.assertEquals(addtowishlist, data[7], "Product add to wishlist validationfailed");
//		ExtentReport.messagePrint("Product add to wishlist button validate successfully");
//		log.info("Product add to wishlist button validate successfully");
//		String productavailibility = Utility
//				.getElement(loc.getProperty("loc.konakart.productavailaibilty.txt")).getText();
//		Assert.assertEquals(productavailibility, data[4].replace(" ", "\n"), "Product availibility validationfailed");
//		ExtentReport.messagePrint("Product availibility validate successfully");
//		log.info("Product availibility validate successfully");
	}

	/**
	 * By giving negative input validating that Web application working properly or
	 * not
	 * 
	 * @param data
	 * @param log
	 */
	public static void negativeInputvalidtion(String[] data, Logger log,Properties loc) {
		Utility.selectDropdownByText(loc.getProperty("loc.konakart.homepage.dpdn"), data[0]);
		Utility.clickAndSendText(loc.getProperty("loc.konakart.search.txtbox"), data[3]);
		Utility.clickElement(loc.getProperty("loc.konakart.search.btn"));
		String errormsg = Utility
				.getElement(loc.getProperty("loc.konakart.erromsg.txt")).getText();
		Assert.assertEquals(errormsg, data[4], "Negative input validation failed");
		ExtentReport.messagePrint("Negative input validation passed");
		log.info("Negative input validation passed");
	}
}
