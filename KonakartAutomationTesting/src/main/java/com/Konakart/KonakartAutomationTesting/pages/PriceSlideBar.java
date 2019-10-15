package com.Konakart.KonakartAutomationTesting.pages;

import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.Konakart.KonakartAutomationTesting.extentreports.ExtentReport;
import com.Konakart.KonakartAutomationTesting.helpers.Utility;
import com.Konakart.KonakartAutomationTesting.logreports.LogReport;

/**
 * This class check the price slide bar functionality.
 * 
 * @author arjun.santra
 *
 */
public class PriceSlideBar {
	static LogReport logreport = new LogReport();

	/**
	 * This method move the price slide bar according to given input value.
	 * 
	 * @param xoffset
	 * @param loc
	 */
	public static void priceSlideBar(String xoffset, Properties loc) {
		Utility.clickElement(loc.getProperty("loc.konakart.hearder.computerperipherals"));
		Utility.scrollDownPage(0, 400);
		Utility.setAttributeValue(loc.getProperty("loc.konakart.priceslider"), Integer.parseInt(xoffset));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * This method validate that all the available products prices are in that price
	 * slide bar range.
	 * 
	 * @param log
	 * @param loc
	 */
	public static void priceValidation(Logger log, Properties loc) {
		List<WebElement> prices = Utility.getElementsList(loc.getProperty("loc.koanakart.pricesacordingslidebar"));
		String[] pricerange = Utility.getElement(loc.getProperty("loc.konakart.pricerange")).getText().split("-");
		String minprice = pricerange[0].replace("$", "");
		String maxprice = pricerange[1].replace("$", "");
		for (WebElement price : prices) {
			String productprice = price.getText().replace("$", "");
			Assert.assertTrue(
					Float.parseFloat(productprice) >= Float.parseFloat(minprice)
							&& Float.parseFloat(productprice) <= Float.parseFloat(maxprice),
					"Price slidebar fuctionality validation failed");
			ExtentReport.messagePrint("Price slidebar fuctionality validate successfully");
			log.info("Price slidebar fuctionality validate successfully");
		}

	}
}
