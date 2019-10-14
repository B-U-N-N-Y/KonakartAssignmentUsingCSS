package com.Konakart.KonakartAutomationTesting.testscripts;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.Konakart.KonakartAutomationTesting.constants.FilePath;
import com.Konakart.KonakartAutomationTesting.dataProvider.TestDataProvider;
import com.Konakart.KonakartAutomationTesting.helpers.Utility;
import com.Konakart.KonakartAutomationTesting.pages.ComputerperipheralFunction;
import com.Konakart.KonakartAutomationTesting.pages.SearchBoxFunction;
import com.Konakart.KonakartAutomationTesting.testbase.TestBase;
import com.Konakart.KonakartAutomationTesting.utils.ReadPropertiesFile;

public class ComuterPeripheralsFunctionality extends TestBase {

	public static Logger log;
	Properties loc=ReadPropertiesFile.loadProperty(FilePath.LOCATOR_FILE);

	@Test(priority = 5, dataProvider = "graphicsoption", dataProviderClass = TestDataProvider.class)
	public void searchBoxWithoutSearchOption(String[] data) {
		log = Logger.getLogger(ComuterPeripheralsFunctionality.class);
		logger = extent.startTest("validation of search box Functionality without using search options");
		SearchBoxFunction.serachBoxInput(data,loc);
		Utility.clickElement(loc.getProperty("loc.konakart.search.btn"));
		ComputerperipheralFunction.erroMsgValidation(data[2], log,loc);
	}

	@Test(priority = 6, dataProvider = "graphicsoption", dataProviderClass = TestDataProvider.class)
	public void searchBoxWithSearchOption(String[] data) {
		log = Logger.getLogger(ComuterPeripheralsFunctionality.class);
		logger = extent.startTest("validation of search box Functionality with using search options");
		SearchBoxFunction.serachBoxInput(data,loc);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Utility.selectDropdownByIndex(loc.getProperty("loc.konakart.search.txtbox"), 1);
		Utility.clickElement(loc.getProperty("loc.konakart.searchbox.options"));
	}

	@Test(priority = 7, dataProvider = "product details", dataProviderClass = TestDataProvider.class)
	public void productDetailsVerify(String[] data) {
		log = Logger.getLogger(ComuterPeripheralsFunctionality.class);
		logger = extent.startTest("Product details validation");
		ComputerperipheralFunction.productValidation(data, log,loc);
	}

}
