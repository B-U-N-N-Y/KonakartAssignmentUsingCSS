package com.Konakart.KonakartAutomationTesting.testscripts;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.Konakart.KonakartAutomationTesting.constants.FilePath;
import com.Konakart.KonakartAutomationTesting.dataProvider.TestDataProvider;
import com.Konakart.KonakartAutomationTesting.helpers.Utility;
import com.Konakart.KonakartAutomationTesting.pages.SearchBoxFunction;
import com.Konakart.KonakartAutomationTesting.testbase.TestBase;
import com.Konakart.KonakartAutomationTesting.utils.ReadPropertiesFile;


public class HomePageSearchBoxFunctionality extends TestBase {
	public static Logger log;
	Properties loc=ReadPropertiesFile.loadProperty(FilePath.LOCATOR_FILE);

	@Test(priority = 1, dataProvider = "searchbox", dataProviderClass = TestDataProvider.class)
	public void searchBox(String[] data) {
		log = Logger.getLogger(HomePageSearchBoxFunctionality.class);
		logger = extent.startTest("Search box Functionality validation");
		SearchBoxFunction.isRedirection(driver, data[2], log);
		SearchBoxFunction.serachBoxInput(data,loc);
		Utility.clickElement(loc.getProperty("loc.konakart.search.btn"));
		SearchBoxFunction.validateProduct(data, log, loc);
		Utility.clickElement(loc.getProperty("loc.konakart.home.btn"));
		SearchBoxFunction.negativeInputvalidtion(data, log,loc);
	}
}