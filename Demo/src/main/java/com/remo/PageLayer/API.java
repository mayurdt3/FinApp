package com.remo.PageLayer;

import com.remo.base.BaseClass;
import com.remo.reader.ExcelFileReader;

/**
 * The API class extends BaseClass and provides methods to read data from an
 * Excel file for API Testing.
 */

public class API extends BaseClass {

	/**
	 * Constructor for the API class. Initializes an instance of ExcelFileReader.
	 */
	public API() {
		excel = new ExcelFileReader();
	}

	/**
	 * 
	 * This method is used to read Excel data which will store the MID data in 1D
	 * Array of object format containing MID data
	 * 
	 * @return 1D Array of object
	 */
	public String[] getMIDDataForProductVerification() {
		return excel.getData("APIVerifyProduct", 1);

	}

	/**
	 * This method is used to read Excel data which will store the ACTIVE MID data
	 * for verification.
	 * 
	 * @return 1D Array containing ACTIVE MIDs.
	 */

	public String[] getMerchantStatementPdfVerifyData() {
		return excel.getMerchantStatementData("APIVerifyProduct", 2);
	}

	/**
	 * This method is used to read Excel data which will store the Live MID data for
	 * verification.
	 * 
	 * @return 1D Array containing LIVE MIDs
	 */
	public String[] getLiveMerchantStatementPdfVerifyData() {
		return excel.getMerchantStatementData("APIVerifyProduct", 5);
	}
}
