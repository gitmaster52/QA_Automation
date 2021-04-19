package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AccountCreationPage extends BaseClass {

	Action action = new Action();
	public String typeGender="Mr";

	@FindBy(id = "email_create")
	private WebElement createAccount;

	@FindBy(xpath = "//button[@id='SubmitCreate' and @type='submit']")
	private WebElement submitButton;

	@FindBy(xpath = "//h1[contains(text(),'My account')]")
	WebElement createAccountTitle;

	@FindBy(id = "uniform-id_gender1")
	public WebElement mGender;

	@FindBy(id = "uniform-id_gender2")
	public WebElement fGender;
	
	@FindBy(id = "customer_firstname")
	private WebElement firstNameField;

	@FindBy(id = "customer_lastname")
	private WebElement lastNameField;

	@FindBy(id = "passwd")
	private WebElement passwordField;

	@FindBy(id = "days")
	private WebElement dateOfBirthDays;

	@FindBy(id = "months")
	private WebElement dateOfBirthMonths;

	@FindBy(id = "years")
	private WebElement dateOfBirthYears;

	@FindBy(id = "firstname")
	private WebElement addressFirstnameField;

	@FindBy(id = "lastname")
	private WebElement addressLastnameField;

	@FindBy(id = "address1")
	private WebElement addressField;

	@FindBy(id = "city")
	private WebElement cityField;

	@FindBy(id = "id_state")
	private WebElement stateDropdown;

	@FindBy(id = "postcode")
	private WebElement postalField;

	@FindBy(id = "id_country")
	private WebElement countryDropdown;

	@FindBy(id = "phone_mobile")
	private WebElement mobileNumberField;

	@FindBy(id = "alias")
	private WebElement addressAliansField;

	@FindBy(id = "submitAccount")
	private WebElement registerButton;

	public AccountCreationPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void createUserAccount(String typeEmail, String gender, String firstName, String lastName, String password,
			String days, String months, String years, String address,
			String city, String state, String postal, String country, String mobileNumber, String aAliens)
			throws Exception {
		Action.typeText(createAccount, typeEmail);
		action.click(submitButton);
		System.out.println(gender);
		if(typeGender.equalsIgnoreCase(gender))
		{
			action.click(mGender);
		}
		else
		{
			action.click(fGender);
		}
		Action.typeText(firstNameField, firstName);
		Action.typeText(lastNameField, lastName);
		Action.typeText(passwordField, password);
		Action.selectDropdownByValue(dateOfBirthDays, days);
		Action.selectDropdownByValue(dateOfBirthMonths, months);
		Action.selectDropdownByValue(dateOfBirthYears, years);
		Action.typeText(addressField, address);
		Action.typeText(cityField, city);
		Action.selectDropdownByText(stateDropdown, state);
		Action.typeText(postalField, postal);
		Action.selectDropdownByText(countryDropdown, country);
		Action.typeText(mobileNumberField, mobileNumber);
		Action.typeText(addressAliansField, aAliens);
		action.click(registerButton);
	}

	public boolean validateAccountTitle() {
		return Action.isPresent(createAccountTitle);
	}

}
