package xboxbasepages;

import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import util.Page;
import util.SystemUtil;
import util.TestCaseBase;

public class XboxGamertagPage extends Page{
	
	@FindBy(xpath = "/html/body/div[1]/div[2]/div/div[1]/div/div/div[1]/h3/a")
	public WebElement game1;	
	
	@FindBy(xpath = "/html/body/div[1]/div[2]/div/div[2]/div/div/div[1]/h3/a")
	public WebElement game2;	
	
	@FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/div/div/div[1]/h3/a")
	public WebElement game3;	
	
	@FindBy(xpath = "/html/body/div[1]/div[2]/div/div[4]/div/div/div[1]/h3/a")
	public WebElement game4;
	
	@FindBy(xpath = "/html/body/div[1]/div[2]/div/div[5]/div/div/div[1]/h3/a")
	public WebElement game5;
	
	public XboxGamertagPage open() throws Exception {
		Properties PROPERTIES_RESOURCES = SystemUtil
				.loadPropertiesResources("/testdata_xbox.properties");
		String URL = PROPERTIES_RESOURCES.getProperty("xboxgamertag.url");
		TestCaseBase.threadDriver.get().navigate().to(URL);

		return this;
	}

}
