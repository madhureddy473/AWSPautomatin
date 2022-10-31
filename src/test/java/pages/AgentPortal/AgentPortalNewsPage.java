package pages.AgentPortal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AgentPortalNewsPage {



	//OBJECTS
	@FindBy(xpath="//strong[contains(text(), ' Latest News')]")
	WebElement latestNews;


	//CONSTRUCTOR
	public AgentPortalNewsPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	
	//METHODS
	public String getPageText() {
		return latestNews.getText();
	}


}
