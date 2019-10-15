package com.Konakart.KonakartAutomationTesting.testscripts;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.Konakart.KonakartAutomationTesting.constants.FilePath;
import com.Konakart.KonakartAutomationTesting.dataProvider.TestDataProvider;
import com.Konakart.KonakartAutomationTesting.helpers.Utility;
import com.Konakart.KonakartAutomationTesting.pages.HeroImageFunction;
import com.Konakart.KonakartAutomationTesting.testbase.TestBase;
import com.Konakart.KonakartAutomationTesting.utils.ReadPropertiesFile;


public class HeroImageFunctionality extends TestBase {
	public static Logger log;
	Properties loc=ReadPropertiesFile.loadProperty(FilePath.LOCATOR_FILE);

	@Test(priority = 2)
	public void heroImageSelect() {
		log = Logger.getLogger(HeroImageFunctionality.class);
		logger = extent.startTest("Hero image Select");
		Utility.clickElement(loc.getProperty("loc.konakart.heroimg.btn"));
	}

	@Test(priority = 3, dataProvider = "heroimage", dataProviderClass = TestDataProvider.class)
	public void heroImgContent(String[] data) {
		log = Logger.getLogger(HeroImageFunctionality.class);
		logger = extent.startTest("Hero image content validation");
		// CommonUtility.clickElement(LoadPropertyFile.locators.getProperty("loc.konakart.heroimg.btn"));
		HeroImageFunction.heroImgContentValidation(driver, data, log,loc);

	}

	@Test(priority = 4, dataProvider = "reviewdropdown", dataProviderClass = TestDataProvider.class)
	public void heroImgSortingDateFunctionality(String[] data) {
		log = Logger.getLogger(HeroImageFunctionality.class);
		logger = extent.startTest("Hero image sorting validation by date");
		HeroImageFunction.heroImgSortOption(data[0],loc);
		HeroImageFunction.sortingDateValidation(data[0], log,loc);
		HeroImageFunction.heroImgSortOption(data[1],loc);
		HeroImageFunction.sortingDateValidation(data[1], log,loc);
	}

	@Test(priority = 5, dataProvider = "reviewdropdown", dataProviderClass = TestDataProvider.class)
	public void heroImgSortingRatingFunctionality(String[] data) {
		log = Logger.getLogger(HeroImageFunctionality.class);
		logger = extent.startTest("Hero image sorting validation by rating");
		HeroImageFunction.heroImgSortOption(data[2],loc);
		HeroImageFunction.starRatingValidation(data[2], log,loc);
		HeroImageFunction.heroImgSortOption(data[3],loc);
		HeroImageFunction.starRatingValidation(data[3], log,loc);
	}

}
