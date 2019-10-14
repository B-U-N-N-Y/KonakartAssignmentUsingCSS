package com.Konakart.KonakartAutomationTesting.pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.Konakart.KonakartAutomationTesting.extentreports.ExtentReport;
import com.Konakart.KonakartAutomationTesting.helpers.Utility;
import com.Konakart.KonakartAutomationTesting.logreports.LogReport;

public class HeroImageFunction {

	static LogReport logreport = new LogReport();

	/**
	 * This method validate the which hero image is selected dynamically and also
	 * validate the of content hero image.
	 * 
	 * @param driver
	 * @param data
	 * @param log
	 */
	public static void heroImgContentValidation(WebDriver driver, String[] data, Logger log, Properties loc) {

		if (driver.getTitle().equalsIgnoreCase(data[0])) {
			pageDescriptionvalidation(data[1], log, loc);
			specificationValidation(data[2], log, loc);
			Utility.clickElement(loc.getProperty("loc.konakart.review.btn"));
		}

	}

	/**
	 * This method validate the product specification
	 * 
	 * @param validatedata
	 * @param log
	 */
	private static void specificationValidation(String validatedata, Logger log, Properties loc) {
		Utility.clickElement(loc.getProperty("loc.konakart.heroimg.specification.btn"));
		// Utility.scrollDownPage(0, 300);
		String specification = Utility.getElement(loc.getProperty("loc.konakart.heroimg.specification.txt")).getText();
		// System.out.println(specification);
		Assert.assertTrue(specification.contains(validatedata), "Failed");
		ExtentReport.messagePrint("specification validate successfully");
		log.info("specification validate successfully");
	}

	/**
	 * This method validate the product description
	 * 
	 * @param validatedata
	 * @param log
	 */
	private static void pageDescriptionvalidation(String validatedata, Logger log, Properties loc) {
		Utility.scrollDownPage(0, 300);
		String description = Utility.getElement(loc.getProperty("loc.konakart.heroimg.description.txt")).getText();
		// System.out.println(description);
		Assert.assertTrue(description.contains(validatedata), "Failed");
		ExtentReport.messagePrint("description validate successfully");
		log.info("description validate successfully");
	}

	/**
	 * This method validate the sorting the date functionality
	 * 
	 * @param sortingorder
	 * @param log
	 */
	public static void sortingDateValidation(String sortingoption, Logger log, Properties loc) {

		List<WebElement> elements = Utility.getElementsList(loc.getProperty("loc.konakart.reviewcount"));
		int loopCount = elements.size();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.ENGLISH);
		for (int index = 1; index < loopCount; index++) {
			String string1 = Utility
					.getElement(loc.getProperty("loc.konakart.reviewdates").replace("index", index + "")).getText();
			String string2 = Utility
					.getElement(loc.getProperty("loc.konakart.reviewdates").replace("index", (index + 1) + ""))
					.getText();
			String split1[] = string1.split(" ", 2);
			String split2[] = string2.split(" ", 2);
			if (split1[1].substring(1, 2).equals(" ")) {
				split1[1] = "0" + split1[1];
			}
			if (split2[1].substring(1, 2).equals(" ")) {
				split2[1] = "0" + split2[1];
			}
			LocalDate date1 = LocalDate.parse(split1[1], formatter);
			LocalDate date2 = LocalDate.parse(split2[1], formatter);
			int difference = date1.compareTo(date2);
			if (sortingoption.equalsIgnoreCase(
					Utility.getElement(loc.getProperty("loc.konakart.sortbydatemostrecent.txt")).getText())) {
				Assert.assertTrue(difference >= 0, "Sorting Functionality Failed");
				ExtentReport.messagePrint("Sorting by date Functionality Working Properly");
				log.info("Sorting by date Functionality Working Properly");
			} else if (sortingoption.equalsIgnoreCase(
					Utility.getElement(loc.getProperty("loc.konakart.sortbydateoldest.txt")).getText())) {
				Assert.assertTrue(difference <= 0, "Sorting Functionality Failed");
				ExtentReport.messagePrint("Sorting by date Functionality Working Properly");
				log.info("Sorting by date Functionality Working Properly");
			}

		}
	}

	/**
	 * This method to select dropdown option by index
	 * 
	 * @param index
	 */
	public static void heroImgSortOption(String sortingoption, Properties loc) {
		Utility.scrollDownPage(0, 200);
		Utility.selectDropdownByText(loc.getProperty("loc.konakart.review.sort.dpdn"), sortingoption);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Utility.explicitWait(loc.getProperty("loc.konakart.heroimgtitle.txt"),
		// 30);
	}

	/**
	 * This method validate the sorting functionality of review rating
	 * 
	 * @param sortOrder
	 * @param log
	 */
	public static void starRatingValidation(String sortingoption, Logger log,Properties loc) {
		List<WebElement> elements = Utility
				.getElementsList(loc.getProperty("loc.konakart.reviewcount"));
		int loopCount = elements.size();
		for (int index = 1; index < loopCount; index++) {
			int count1 = Utility.getElementsList(
					loc.getProperty("loc.konakart.ratingcount.txt").replace("index", index + ""))
					.size();
			int count2 = Utility.getElementsList(loc
					.getProperty("loc.konakart.ratingcount.txt").replace("index", (index + 1) + "")).size();
			int difference = count1 - count2;
			if (sortingoption.equalsIgnoreCase(Utility
					.getElement(loc.getProperty("loc.konakart.sortbyratinghightolow.txt"))
					.getText())) {
				Assert.assertTrue(difference >= 0, "Sorting Functionality Failed");
				ExtentReport.messagePrint("Sorting by rating Functionality Working Properly");
				log.info("Sorting by rating Functionality Working Properly");
			} else if (sortingoption.equalsIgnoreCase(Utility
					.getElement(loc.getProperty("loc.konakart.sortbyratinglowtohigh.txt"))
					.getText())) {
				Assert.assertTrue(difference <= 0, "Sorting Functionality Failed");
				ExtentReport.messagePrint("Sorting by rating Functionality Working Properly");
				log.info("Sorting by rating Functionality Working Properly");
			}
		}
	}

}
