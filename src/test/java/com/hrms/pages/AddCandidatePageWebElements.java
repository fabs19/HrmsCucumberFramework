package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.utils.CommonMethods;

public class AddCandidatePageWebElements extends CommonMethods {

	@FindBy(id = "addCandidate_firstName")
	public WebElement firstName;

	@FindBy(id = "addCandidate_middleName")
	public WebElement middleName;

	@FindBy(id = "addCandidate_lastName")
	public WebElement lastName;

	@FindBy(id = "addCandidate_email")
	public WebElement email;

	@FindBy(id = "addCandidate_contactNo")
	public WebElement contactNo;

	@FindBy(id = "addCandidate_vacancy")
	public WebElement vacancy;

	@FindBy(id = "addCandidate_resume")
	public WebElement resume;

	@FindBy(id = "addCandidate_keyWords")
	public WebElement keywords;

	@FindBy(id = "addCandidate_comment")
	public WebElement comment;

	@FindBy(id = "addCandidate_appliedDate")
	public WebElement calender;

	@FindBy(xpath = "//span[@class='status']")
	public WebElement applicationStatus;

	@FindBy(id = "btnSave")
	public WebElement saveBtn;

	public AddCandidatePageWebElements() {
		PageFactory.initElements(driver, this);
	}
}