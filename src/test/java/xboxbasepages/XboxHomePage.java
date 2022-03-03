package xboxbasepages;

import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import util.Page;
import util.SystemUtil;
import util.TestCaseBase;
import util.Waiting;

public class XboxHomePage extends Page {
	
	@FindBy(xpath = ".//a[@href='/leaderboards']")
	public WebElement leaderboards;
	
	@FindBy(xpath = ".//input[@placeholder='Enter a gamertag to lookup']")
	public WebElement gamertagSearch;
	
	public XboxHomePage open() throws Exception {
		Properties PROPERTIES_RESOURCES = SystemUtil
				.loadPropertiesResources("/testdata_xbox.properties");
		String URL = PROPERTIES_RESOURCES.getProperty("xbox.url");
		TestCaseBase.threadDriver.get().navigate().to(URL);

		return this;
	}
	
	public XboxLeaderboardsPage gotoLeaderboardPage() throws Exception {
		Waiting.until(leaderboards);
		leaderboards.click();
		
		return new XboxLeaderboardsPage();
	}
	
	public XboxGamertagPage gotoGamertagPage() throws Exception {
		Properties PROPERTIES_RESOURCES = SystemUtil
				.loadPropertiesResources("/testdata_xbox.properties");
		String gamertag = PROPERTIES_RESOURCES.getProperty("xbox.gamertag");
		Waiting.until(gamertagSearch);
		gamertagSearch.sendKeys(gamertag + Keys.ENTER);
		
		return new XboxGamertagPage();
	}
}
