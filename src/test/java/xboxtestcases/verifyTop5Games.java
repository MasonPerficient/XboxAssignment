package xboxtestcases;

import java.util.HashMap;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import util.CustomAssertion;
import util.TestCaseBase;
import util.TestData;
import xboxbasepages.XboxGamertagPage;
import xboxbasepages.XboxHomePage;

public class verifyTop5Games extends TestCaseBase{

	HashMap<String, String> expectedValues = new HashMap<String, String>();
	
	@BeforeMethod
	public void loadExpectedValues() {
		expectedValues.put("game1", TestData.get("gamertag.game1"));
		expectedValues.put("game2", TestData.get("gamertag.game2"));
		expectedValues.put("game3", TestData.get("gamertag.game3"));
		expectedValues.put("game4", TestData.get("gamertag.game4"));
		expectedValues.put("game5", TestData.get("gamertag.game5"));
	}
	
	@Test(groups = {"ChromeWin32"})
	public void verifyTop5Games() throws Exception {
		
		XboxHomePage xboxHomePage = new XboxHomePage();
		xboxHomePage.open();
		XboxGamertagPage gamertagPage = xboxHomePage.gotoGamertagPage();
		CustomAssertion customAssertion = new CustomAssertion();
		customAssertion.equals(gamertagPage.game1.getText(), expectedValues, "game1");
		customAssertion.equals(gamertagPage.game2.getText(), expectedValues, "game2");
		customAssertion.equals(gamertagPage.game3.getText(), expectedValues, "game3");
		customAssertion.equals(gamertagPage.game4.getText(), expectedValues, "game4");
		customAssertion.equals(gamertagPage.game5.getText(), expectedValues, "game5");
	}
}
