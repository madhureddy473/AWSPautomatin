package pages.AgentWorks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AgentWorksAdministrationPage {


	//OBJECTS
	@FindBy(xpath="//strong[contains(text(), ' Administration ')]")
	WebElement adminPageLabel;


	//CONSTRUCTOR
	public AgentWorksAdministrationPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	
	//METHODS
	public String getAdminPageText() {
		return adminPageLabel.getText();
	}


}
