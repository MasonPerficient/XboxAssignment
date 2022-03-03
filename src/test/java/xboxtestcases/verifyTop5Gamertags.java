package xboxtestcases;

import java.util.HashMap;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import util.CustomAssertion;
import util.TestCaseBase;
import util.TestData;
import xboxbasepages.XboxHomePage;
import xboxbasepages.XboxLeaderboardsPage;

public class verifyTop5Gamertags extends TestCaseBase{
	
	HashMap<String, String> expectedValues = new HashMap<String, String>();
	
	@BeforeMethod
	public void loadExpectedValues() {
		expectedValues.put("rank1", TestData.get("leaderboard.rank1"));
		expectedValues.put("rank2", TestData.get("leaderboard.rank2"));
		expectedValues.put("rank3", TestData.get("leaderboard.rank3"));
		expectedValues.put("rank4", TestData.get("leaderboard.rank4"));
		expectedValues.put("rank5", TestData.get("leaderboard.rank5"));
	}

	@Test(groups = {"ChromeWin32"})
	public void verifyTop5Gts() throws Exception {
	
		XboxHomePage xboxHomePage = new XboxHomePage();
		xboxHomePage.open();
		XboxLeaderboardsPage leaderboards = xboxHomePage.gotoLeaderboardPage();
		CustomAssertion customAssertion = new CustomAssertion();
		customAssertion.equals(leaderboards.rank1.getText(), expectedValues, "rank1");
		customAssertion.equals(leaderboards.rank2.getText(), expectedValues, "rank2");
		customAssertion.equals(leaderboards.rank3.getText(), expectedValues, "rank3");
		customAssertion.equals(leaderboards.rank4.getText(), expectedValues, "rank4");
		customAssertion.equals(leaderboards.rank5.getText(), expectedValues, "rank5");
	}
	
}
