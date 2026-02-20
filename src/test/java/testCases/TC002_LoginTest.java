package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	@Test(groups = { "sanity", "master" })
	public void verifyLogin() {
		logger.info("*********** Starting TC002_LoginTest ***********");
		try {
			// Home Page
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();

			// Login
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(prop.getProperty("email"));
			lp.setPassword(prop.getProperty("password"));
			lp.clcikLogin();

			// My Account
			MyAccountPage myacc = new MyAccountPage(driver);
			boolean targetPage = myacc.isMyAccoutPageExists();
			// Assert.assertEquals(targetPage, true, "Login Failed");
			Assert.assertTrue(targetPage);
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("*********** Ending TC002_LoginTest ***********");

	}
}
