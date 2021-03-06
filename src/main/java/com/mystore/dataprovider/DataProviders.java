package com.mystore.dataprovider;

import org.testng.annotations.DataProvider;

import com.mystore.utilities.ExcelReader;

public class DataProviders {

	public ExcelReader reader;

	//Login
	@DataProvider
	public String[][] loginTest() throws Exception {
		reader = new ExcelReader();
		int totalRows = reader.getRowCount("Login");
		int totalColumns = reader.getColumnCount("Login", totalRows);

		String loginData[][] = new String[totalRows][totalColumns];
		for (int i = 1; i <= totalRows; i++) {
			for (int j = 0; j < totalColumns; j++) {
				loginData[i - 1][j] = reader.getCellData("Login", i, j);
			}
		}
		return loginData;

	}
	
	//create account
		@DataProvider
		public String[][] createAccount() throws Exception {
			reader = new ExcelReader();
			int totalRows = reader.getRowCount("Registration");
			int totalColumns = reader.getColumnCount("Registration", totalRows);

			String crrateAccountData[][] = new String[totalRows][totalColumns];
			for (int i = 1; i <= totalRows; i++) {
				for (int j = 0; j < totalColumns; j++) {
					crrateAccountData[i - 1][j] = reader.getCellData("Registration", i, j);
				}
			}
			
			return crrateAccountData;

		}

}
