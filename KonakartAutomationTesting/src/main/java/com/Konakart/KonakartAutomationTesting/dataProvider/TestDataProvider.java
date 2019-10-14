package com.Konakart.KonakartAutomationTesting.dataProvider;

import org.testng.annotations.DataProvider;

import com.Konakart.KonakartAutomationTesting.constants.FilePath;
import com.Konakart.KonakartAutomationTesting.utils.ProvideData;

/**
 * In this class, data is given by the dataprovider
 */
public class TestDataProvider {
	/**
	 * In this method, getting the More info button data object array and returning
	 * to the calling method
	 */

	@DataProvider(name = "searchbox")
	public Object[][] getSearchBoxData() {
		ProvideData provideData = new ProvideData(FilePath.TESTDATA_FILE, 0);
		Object[][] getData = provideData.provideData();
		return getData;
	}

	/**
	 * In this method, getting the Explore now button data into object array and
	 * returning to the calling method
	 */

	@DataProvider(name = "heroimage")
	public Object[][] getHeroImgData() {
		ProvideData provideData = new ProvideData(FilePath.TESTDATA_FILE, 1);
		Object[][] getData = provideData.provideData();
		return getData;
	}

	
	@DataProvider(name = "reviewdropdown")
	public Object[][] getReviewDropdown() {
		ProvideData provideData = new ProvideData(FilePath.TESTDATA_FILE, 2);
		Object[][] getData = provideData.provideData();
		return getData;
	}

	@DataProvider(name = "graphicsoption")
	public Object[][] getSearchGraphics() {
		ProvideData provideData = new ProvideData(FilePath.TESTDATA_FILE, 3);
		Object[][] getData = provideData.provideData();
		return getData;
	}

	@DataProvider(name = "product details")
	public Object[][] getProductValues() {
		ProvideData provideData = new ProvideData(FilePath.TESTDATA_FILE, 4);
		Object[][] getData = provideData.provideData();
		return getData;
	}

	@DataProvider(name = "priceslidebar")
	public Object[][] getPriceSlideValue() {
		ProvideData provideData = new ProvideData(FilePath.TESTDATA_FILE, 5);
		Object[][] getData = provideData.provideData();
		return getData;
	}

//	public static void main(String[] args) {
//
//		Object[][] data = new TestDataProvider().getCityData();
//		for (Object[] objects : data) {
//			String userName = (String) objects[0];
//			String password = (String) objects[1];
//			System.out.println(" " + userName + "   " + password);
//		}
//	}
}