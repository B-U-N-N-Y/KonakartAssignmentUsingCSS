package com.Konakart.KonakartAutomationTesting.pages;

import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.Konakart.KonakartAutomationTesting.extentreports.ExtentReport;
import com.Konakart.KonakartAutomationTesting.helpers.Utility;
import com.Konakart.KonakartAutomationTesting.logreports.LogReport;


public class PriceSlideBar {
	static LogReport logreport = new LogReport();

	public static void priceSlideBar(String xoffset, Properties loc) {
		Utility.clickElement(loc.getProperty("loc.konakart.hearder.computerperipherals"));
		Utility.scrollDownPage(0, 300);
		Utility.setAttributeValue(loc.getProperty("loc.konakart.priceslider"),
				Integer.parseInt(xoffset));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void priceValidation(Logger log,Properties loc) {
		List<WebElement> prices = Utility
				.getElementsList(loc.getProperty("loc.koanakart.pricesacordingslidebar"));
//		int pricecount = prices.size();
		String[] pricerange = Utility.getElement(loc.getProperty("loc.konakart.pricerange"))
				.getText().split("-");
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
