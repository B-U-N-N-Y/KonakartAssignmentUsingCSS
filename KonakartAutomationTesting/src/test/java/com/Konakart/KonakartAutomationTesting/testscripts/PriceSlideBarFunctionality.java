package com.Konakart.KonakartAutomationTesting.testscripts;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.Konakart.KonakartAutomationTesting.constants.FilePath;
import com.Konakart.KonakartAutomationTesting.dataProvider.TestDataProvider;
import com.Konakart.KonakartAutomationTesting.pages.PriceSlideBar;
import com.Konakart.KonakartAutomationTesting.testbase.TestBase;
import com.Konakart.KonakartAutomationTesting.utils.ReadPropertiesFile;


public class PriceSlideBarFunctionality extends TestBase {
	public static Logger log;
	Properties loc=ReadPropertiesFile.loadProperty(FilePath.LOCATOR_FILE);

	@Test(priority = 8, dataProvider = "priceslidebar", dataProviderClass = TestDataProvider.class)
	public void priceSlideBar(String xoffset) {
		log = Logger.getLogger(PriceSlideBarFunctionality.class);
		logger = extent.startTest("Price slidebar functionality validation");
		PriceSlideBar.priceSlideBar(xoffset,loc);
		PriceSlideBar.priceValidation(log,loc);

	}
}
